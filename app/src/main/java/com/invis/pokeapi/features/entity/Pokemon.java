package com.invis.pokeapi.features.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Pokemon {

    @AllArgsConstructor
    @Getter
    @Setter
    private class Stat {
        private String name;
        private int value;
    }

    private String name;
    private int number;
    private int height;
    private int weight;
    private String type1;
    private String type2;
    private Stat hp;
    private Stat attack;
    private Stat defense;
}
