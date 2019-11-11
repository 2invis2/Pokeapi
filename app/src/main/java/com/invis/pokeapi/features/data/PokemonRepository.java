package com.invis.pokeapi.features.data;

import com.invis.pokeapi.features.entity.Pokemon;

import java.util.ArrayList;

public interface PokemonRepository {
    ArrayList<String> loadPokemonListUrl();
    ArrayList<Pokemon> loadPokemonList();
}
