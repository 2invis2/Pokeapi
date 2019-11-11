package com.invis.pokeapi.features.data;

import com.invis.pokeapi.features.data.model.PokemonJson;
import com.invis.pokeapi.network.Carry;

import java.util.ArrayList;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PokemonRepositoryImpl implements PokemonRepository {
    private PokemonServer pokemonServer;

    @Override
    public ArrayList<String> loadPokemonListUrl() {
        final ArrayList<String> pokemonListUrl = new ArrayList<String>();
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
    public ArrayList<PokemonJson> loadPokemonList() {
        final ArrayList<PokemonJson> pokemonList = new ArrayList<PokemonJson>();
        ArrayList<String> pokemonListUrl = this.loadPokemonListUrl();

        for (int i = 0; i < pokemonListUrl.size(); i++) {
            String[] urlSplitArray = pokemonListUrl.get(i).split("/");
            pokemonServer.getPokemon(urlSplitArray[5], new Carry<PokemonJson>() {
                @Override
                public void onSuccess(PokemonJson result) {
                    pokemonList.add(result);
                }

                @Override
                public void onFailure(Throwable throwable) {}
            }
            );
        }
        return pokemonList;
    }
}
