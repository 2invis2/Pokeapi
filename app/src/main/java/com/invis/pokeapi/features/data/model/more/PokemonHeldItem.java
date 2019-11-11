package com.invis.pokeapi.features.data.model.more;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PokemonHeldItem {
    private NamedAPIResource version;
    private int rarity;
}
