package com.invis.pokeapi.features.data.model;

import com.invis.pokeapi.features.data.model.more.NamedAPIResource;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
public class PokemonListUrl {
    private int count;
    private String next;
    private String previous;
    private List<NamedAPIResource> results;

    public PokemonListUrl(PokemonListUrl pokemonListUrl){
        this.count = pokemonListUrl.getCount();
        this.next = pokemonListUrl.getNext();
        this.previous = pokemonListUrl.getPrevious();
        this.results = pokemonListUrl.getResults();
    }
}
