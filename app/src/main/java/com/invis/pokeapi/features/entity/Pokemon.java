package com.invis.pokeapi.features.entity;

import com.invis.pokeapi.features.entity.more.PokemonStatApp;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Pokemon {
    private int order;
    private String name;
    private int height;
    private int weight;
    private ArrayList<String> types;
    private ArrayList<PokemonStatApp> stats;
}
