package com.invis.pokeapi.features.data;

import com.invis.pokeapi.features.data.model.PokemonJson;
import com.invis.pokeapi.features.data.model.PokemonListUrl;
import com.invis.pokeapi.network.Carry;

public interface PokemonServer {
    void loadPokemonListUrl(Carry<PokemonListUrl> carry);

    void getPokemon(String order, Carry<PokemonJson> carry);
}
