package com.invis.pokeapi.features.list.presenter;

import com.invis.pokeapi.features.MvpView;
import com.invis.pokeapi.features.entity.Pokemon;

import java.util.List;

public interface ListView extends MvpView {

    void showPokemonList(List<Pokemon> pokemonList);
    void showError(String message);

    void hideActivity(Pokemon pokemon);

}
