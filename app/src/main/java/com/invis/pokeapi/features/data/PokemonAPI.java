package com.invis.pokeapi.features.data;

import com.invis.pokeapi.features.data.model.PokemonJson;
import com.invis.pokeapi.features.data.model.PokemonListUrl;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonAPI {

    @GET("pokemon/?limit=1")
    Call<PokemonListUrl> getPokemonListUrl();

    @GET("pokemon/{pokemonOrder}/")
    Call<PokemonJson> getPokemon(@Path("pokemonOrder") String pokemonOrder);
}
