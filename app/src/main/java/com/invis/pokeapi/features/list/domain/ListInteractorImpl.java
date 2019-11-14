package com.invis.pokeapi.features.list.domain;

import com.invis.pokeapi.features.data.PokemonRepository;
import com.invis.pokeapi.features.entity.Pokemon;
import com.invis.pokeapi.network.Carry;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ListInteractorImpl implements ListInteractor {
    private PokemonRepository repository;


    @Override
    public void loadPokemonList(Carry<List<Pokemon>> carry) {
        repository.loadPokemonList(carry);
    }


}
