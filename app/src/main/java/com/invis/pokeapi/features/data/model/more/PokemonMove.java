package com.invis.pokeapi.features.data.model.more;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PokemonMove {
    private NamedAPIResource move;
    private ArrayList<PokemonMoveVersion> version_group_details;
}
