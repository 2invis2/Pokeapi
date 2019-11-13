package com.invis.pokeapi.features.data;

import com.invis.pokeapi.features.data.model.PokemonJson;
import com.invis.pokeapi.features.data.model.PokemonListUrl;
import com.invis.pokeapi.network.Carry;
import com.invis.pokeapi.network.DefaultCallback;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PokemonServerImpl implements PokemonServer {
    private PokemonAPI pokemonAPI;

    @Override
    public void loadPokemonListUrl(Carry<PokemonListUrl> carry) {
        pokemonAPI.getPokemonListUrl().enqueue(new DefaultCallback<>(carry));

    }

    @Override
    public void getPokemon(String order, Carry<PokemonJson> carry) {
        pokemonAPI.getPokemon(order).enqueue(new DefaultCallback<>(carry));
    }

}
