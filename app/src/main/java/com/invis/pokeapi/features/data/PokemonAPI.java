package com.invis.pokeapi.features.data;

import com.invis.pokeapi.features.entity.Pokemon;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonAPI {
    @GET("pokemon/?limit=30")
    Call<ArrayList<String>> getPokemonListUrl();

    @GET("pokemon/[pokemonOrder]")
    Call<Pokemon> getPokemon(@Path ("pokemonOrder") String pokemonOrder);
}
