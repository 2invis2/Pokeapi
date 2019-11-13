package com.invis.pokeapi.features.list.domain;

import com.invis.pokeapi.features.data.PokemonRepository;
import com.invis.pokeapi.features.entity.Pokemon;
import com.invis.pokeapi.network.Carry;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ListInteractorImpl implements ListInteractor {
    private PokemonRepository repository;


    @Override
    public void loadPokemonList(Carry<Pokemon> carry) {
        repository.loadPokemonList(carry);
    }


}
