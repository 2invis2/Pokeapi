package com.invis.pokeapi.features.data.model.more;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
class PokemonMoveVersion {
    private NamedAPIResource move_learn_method;
    private NamedAPIResource version_group;
    private int level_learned_at;
}
