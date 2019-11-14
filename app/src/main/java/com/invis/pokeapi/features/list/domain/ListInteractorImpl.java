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

    @Override
    public int maxPokemon(List<Pokemon> pokemonList, boolean checkAttack, boolean checkDefense, boolean checkHp) {
        if(checkAttack || checkDefense || checkHp) {
            int indexMaxPokemon = 0;
            for (int i = 1; i < pokemonList.size(); i++) {
                indexMaxPokemon = ChecksPokemon.maxPokemon(pokemonList.get(indexMaxPokemon), pokemonList.get(i),
                        indexMaxPokemon, i, checkAttack, checkDefense, checkHp);
            }
            return indexMaxPokemon;
        } else{
            return 0;
        }
    }
}
