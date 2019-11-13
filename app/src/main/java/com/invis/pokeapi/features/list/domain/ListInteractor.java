package com.invis.pokeapi.features.list.domain;

import com.invis.pokeapi.features.entity.Pokemon;
import com.invis.pokeapi.network.Carry;

public interface ListInteractor {
   void loadPokemonList(Carry<Pokemon> carry);
}
