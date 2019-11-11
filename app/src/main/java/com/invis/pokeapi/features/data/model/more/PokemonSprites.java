package com.invis.pokeapi.features.data.model.more;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PokemonSprites {
    private String front_default;
    private String front_shiny;
    private String front_female;
    private String front_shiny_female;
    private String back_default;
    private String back_shiny;
    private String back_female;
    private String back_shiny_female;
}
