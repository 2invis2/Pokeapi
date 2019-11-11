package com.invis.pokeapi.features.list.domain;

import com.invis.pokeapi.features.data.PokemonRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ListInteractorImpl implements ListInteractor {
    private PokemonRepository repository;


}
