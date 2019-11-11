package com.invis.pokeapi.features.data;

import com.invis.pokeapi.features.data.model.PokemonJson;

import java.util.ArrayList;

public interface PokemonRepository {
    ArrayList<String> loadPokemonListUrl();
    ArrayList<PokemonJson> loadPokemonList();
}
