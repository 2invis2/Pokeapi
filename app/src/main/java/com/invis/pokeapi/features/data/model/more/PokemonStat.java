package com.invis.pokeapi.features.data.model.more;

import com.invis.pokeapi.features.entity.more.PokemonStatApp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PokemonStat {
    private NamedAPIResource stat;
    private int effort;
    private int base_stat;

    public PokemonStatApp toPokemonStatApp(){
        return new PokemonStatApp(stat.getName(), base_stat);
    }
}
