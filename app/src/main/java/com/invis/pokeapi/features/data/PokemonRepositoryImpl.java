package com.invis.pokeapi.features.data;

import com.invis.pokeapi.features.data.model.PokemonJson;
import com.invis.pokeapi.features.entity.Pokemon;
import com.invis.pokeapi.network.Carry;

import java.util.ArrayList;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PokemonRepositoryImpl implements PokemonRepository {
    private PokemonServer pokemonServer;

    @Override
    public ArrayList<String> loadPokemonListUrl() {
        final ArrayList<String> pokemonListUrl = new ArrayList<String>(0);
        pokemonServer.loadPokemonListUrl(new Carry<ArrayList<String>>() {

            @Override
            public void onSuccess(ArrayList<String> result) {
                pokemonListUrl.addAll(result);
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        }
        );
        return pokemonListUrl;
    }

    @Override
    public ArrayList<Pokemon> loadPokemonList() {
        final ArrayList<Pokemon> pokemonList = new ArrayList<Pokemon>();
        ArrayList<String> pokemonListUrl = this.loadPokemonListUrl();

        for (int i = 0; i < pokemonListUrl.size(); i++) {
            String[] urlSplitArray = pokemonListUrl.get(i).split("/");
            pokemonServer.getPokemon(urlSplitArray[5], new Carry<PokemonJson>() {
                @Override
                public void onSuccess(PokemonJson result) {
                    pokemonList.add(result.toPokemon());
                }

                @Override
                public void onFailure(Throwable throwable) {}
            }
            );
        }
        return pokemonList;
    }
}
