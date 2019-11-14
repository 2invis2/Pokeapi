package com.invis.pokeapi.features.data;

import com.invis.pokeapi.features.data.model.PokemonJson;
import com.invis.pokeapi.features.data.model.PokemonListUrl;
import com.invis.pokeapi.features.entity.Pokemon;
import com.invis.pokeapi.network.Carry;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PokemonRepositoryImpl implements PokemonRepository {
    private PokemonServer pokemonServer;

    @Override
    public void loadPokemonList(final Carry<List<Pokemon>> carry) {
        pokemonServer.loadPokemonListUrl(new Carry<PokemonListUrl>() {

            @Override
            public void onSuccess(PokemonListUrl result) {
                final int sizeList = 30;
                final List<Pokemon> pokemonList = new ArrayList<Pokemon>();

                int allPokemon = 807;
                Random rndPokemonOrder = new Random();
                int pokemonOrder;

                for (int i = 0; i < sizeList; i++) {
                    pokemonOrder = rndPokemonOrder.nextInt(allPokemon) + 1;
                    pokemonServer.loadPokemon(new String().valueOf(pokemonOrder), new Carry<PokemonJson>() {
                        @Override
                        public void onSuccess(PokemonJson result) {
                            pokemonList.add(result.toPokemon());
                            if (pokemonList.size() == sizeList ){
                                carry.onSuccess(pokemonList);
                            }
                        }

                        @Override
                        public void onFailure(Throwable throwable) {
                            System.out.println(throwable);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                System.out.println(throwable);
            }
        });
    }
}
