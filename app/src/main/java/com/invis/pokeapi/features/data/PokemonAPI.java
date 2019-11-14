package com.invis.pokeapi.features.data;

import android.graphics.drawable.Drawable;

import com.invis.pokeapi.features.data.model.PokemonJson;
import com.invis.pokeapi.features.data.model.PokemonListUrl;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface PokemonAPI {

    @GET("pokemon/?limit=1")
    Call<PokemonListUrl> getPokemonListUrl();

    @GET("pokemon/{pokemonOrder}/")
    Call<PokemonJson> loadPokemon(@Path("pokemonOrder") String pokemonOrder);

    @GET
    Call<Drawable> loadPokemonImage(@Url String url);
}
