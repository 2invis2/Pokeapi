package com.invis.pokeapi.features.data.model.more;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PokemonAbility {
    private boolean is_hidden;
    private int slot;
    private NamedAPIResource ability;
}
