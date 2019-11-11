package com.invis.pokeapi.features.data;

import com.invis.pokeapi.features.data.model.PokemonJson;
import com.invis.pokeapi.network.Carry;

import java.util.ArrayList;

public interface PokemonServer {
    void loadPokemonListUrl(Carry<ArrayList<String>> carry);

    void getPokemon(String order, Carry<PokemonJson> carry);
}
