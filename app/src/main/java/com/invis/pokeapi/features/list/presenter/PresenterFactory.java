package com.invis.pokeapi.features.list.presenter;

import android.content.Context;

import com.invis.pokeapi.App;
import com.invis.pokeapi.features.data.PokemonAPI;
import com.invis.pokeapi.features.data.PokemonRepository;
import com.invis.pokeapi.features.data.PokemonRepositoryImpl;
import com.invis.pokeapi.features.data.PokemonServer;
import com.invis.pokeapi.features.data.PokemonServerImpl;
import com.invis.pokeapi.features.list.domain.ListInteractor;
import com.invis.pokeapi.features.list.domain.ListInteractorImpl;

final class PresenterFactory {

    static ListPresenter createPresenter(Context context) {
        final PokemonAPI api = App.getRetrofitProvider(context)
                .getRetrofit()
                .create(PokemonAPI.class);

        final PokemonServer server = new PokemonServerImpl(api);
        final PokemonRepository repository = new PokemonRepositoryImpl(server);
        final ListInteractor interactor = new ListInteractorImpl(repository);

        return new ListPresenter(interactor);
    }

}
