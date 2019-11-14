package com.invis.pokeapi.features.description.presenter;

import com.invis.pokeapi.features.MvpPresenter;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DescriptionPresenter extends MvpPresenter<DescriptionView> {

    @Override
    protected void onViewReady() {
        this.loadPokemon();
    }

    public void loadPokemon(){
        view.showPokemon();
    }

    public void hideActivity() {
        view.hideActivity();
    }
}
