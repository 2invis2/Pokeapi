package com.invis.pokeapi.features.data.model;

import com.invis.pokeapi.features.data.model.more.NamedAPIResource;
import com.invis.pokeapi.features.data.model.more.PokemonAbility;
import com.invis.pokeapi.features.data.model.more.PokemonHeldItem;
import com.invis.pokeapi.features.data.model.more.PokemonMove;
import com.invis.pokeapi.features.data.model.more.PokemonSprites;
import com.invis.pokeapi.features.data.model.more.PokemonStat;
import com.invis.pokeapi.features.data.model.more.PokemonType;
import com.invis.pokeapi.features.data.model.more.VersionGameIndex;
import com.invis.pokeapi.features.entity.Pokemon;
import com.invis.pokeapi.features.entity.more.PokemonStatApp;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//https://pokeapi.co/docs/v2.html/#pokemon

@Getter
@Setter
@AllArgsConstructor
public class PokemonJson {

    private int id;
    private String name;
    private int base_experience;
    private int height;
    private boolean is_default;
    private int order;
    private int weight;
    private ArrayList<PokemonAbility> abilities;
    private ArrayList<NamedAPIResource> forms;
    private ArrayList<VersionGameIndex> game_indices;
    private ArrayList<PokemonHeldItem> held_items;
    private String location_area_encounters;
    private ArrayList<PokemonMove> moves;
    private NamedAPIResource species;
    private PokemonSprites sprites;
    private ArrayList<PokemonStat> stats;
    private ArrayList<PokemonType> types;

    public Pokemon toPokemon(){
        ArrayList<String> pokemonTypes = new ArrayList<String>(0);
        for (int i = 0; i < types.size(); i++){
            pokemonTypes.add(types.get(i).getType().getName());
        }

        ArrayList<PokemonStatApp> pokemonStatsApp = new ArrayList<PokemonStatApp>(0);
        for (int i = 0; i < stats.size(); i++){
            pokemonStatsApp.add(stats.get(i).toPokemonStatApp());
        }
        return new Pokemon(id, name, height, weight, pokemonTypes, pokemonStatsApp);
    }
}
