package com.invis.pokeapi.features.list.domain;

import com.invis.pokeapi.features.entity.Pokemon;
import com.invis.pokeapi.network.Carry;

import java.util.List;

public interface ListInteractor {
   void loadPokemonList(Carry<List<Pokemon>> carry);
   int maxPokemon (List<Pokemon> pokemonList, boolean checkAttack, boolean checkDefense, boolean checkHp);
}
