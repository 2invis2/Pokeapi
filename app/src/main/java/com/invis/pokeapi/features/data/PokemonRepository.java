package com.invis.pokeapi.features.data;

import com.invis.pokeapi.features.entity.Pokemon;
import com.invis.pokeapi.network.Carry;

import java.util.List;

public interface PokemonRepository {
    void loadPokemonList(Carry<List<Pokemon>> carry) ;
}
