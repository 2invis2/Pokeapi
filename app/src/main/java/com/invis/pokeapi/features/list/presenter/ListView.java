package com.invis.pokeapi.features.list.presenter;

import com.invis.pokeapi.features.MvpView;
import com.invis.pokeapi.features.entity.Pokemon;

public interface ListView extends MvpView {

    void showPokemonList(Pokemon pokemon);
    void showError(String message);
}
