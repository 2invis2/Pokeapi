package com.invis.pokeapi.features.data;

import android.graphics.drawable.Drawable;

import com.invis.pokeapi.features.data.model.PokemonJson;
import com.invis.pokeapi.features.data.model.PokemonListUrl;
import com.invis.pokeapi.network.Carry;

public interface PokemonServer {
    void loadPokemonListUrl(Carry<PokemonListUrl> carry);

    void loadPokemon(String order, Carry<PokemonJson> carry);
    void loadPokemonImage(String url, Carry<Drawable> carry);
}
