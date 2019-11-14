package com.invis.pokeapi.features.list.presenter;

import com.invis.pokeapi.features.MvpPresenter;
import com.invis.pokeapi.features.entity.Pokemon;
import com.invis.pokeapi.features.list.domain.ListInteractor;
import com.invis.pokeapi.network.Carry;

import java.util.List;

public class ListPresenter extends MvpPresenter<ListView> {
    private ListInteractor listInteractor;

    ListPresenter (ListInteractor listInteractor){ this.listInteractor = listInteractor;}

    public void loadPokemonList() {
       listInteractor.loadPokemonList(new Carry<List<Pokemon>>() {
            @Override
            public void onSuccess(List<Pokemon> result) {
                view.showPokemonList(result);
            }

            @Override
            public void onFailure(Throwable throwable) {
                view.showError(throwable.getMessage());
            }
        });
    }

    public void onPokemonSelected(Pokemon pokemon) {
        view.hideActivity(pokemon);
    }

    @Override
    protected void onViewReady(){
        this.loadPokemonList();
    }
}
