package com.invis.pokeapi.features.data;

import com.invis.pokeapi.features.entity.Pokemon;
import com.invis.pokeapi.network.Carry;

public interface PokemonRepository {
    void loadPokemonList(Carry<Pokemon> carry) ;
}
