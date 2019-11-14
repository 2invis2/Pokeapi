package com.invis.pokeapi.features.list.domain;

import com.invis.pokeapi.features.entity.Pokemon;

public class ChecksPokemon {

    public static int maxPokemon(Pokemon pokemonOne, Pokemon pokemonTwo, int indexPokemonOne, int indexPokemonTwo,
                                 boolean checkAttack, boolean checkDefense, boolean checkHp){
        int attackPokemonOne = pokemonOne.getStats().get(pokemonOne.indexStat("attack")).getValue();
        int defensePokemonOne = pokemonOne.getStats().get(pokemonOne.indexStat("defense")).getValue();
        int hpPokemonOne = pokemonOne.getStats().get(pokemonOne.indexStat("hp")).getValue();

        int attackPokemonTwo = pokemonTwo.getStats().get(pokemonTwo.indexStat("attack")).getValue();
        int defensePokemonTwo = pokemonTwo.getStats().get(pokemonTwo.indexStat("defense")).getValue();
        int hpPokemonTwo = pokemonTwo.getStats().get(pokemonTwo.indexStat("hp")).getValue();

        if(checkAttack && checkDefense && checkHp){
            if ((attackPokemonOne + defensePokemonOne + hpPokemonOne) >
                    (attackPokemonTwo + defensePokemonTwo + hpPokemonTwo)) {
                return indexPokemonOne;
            } else {
                return indexPokemonTwo;
            }
        }
        if(checkAttack && checkDefense) {
            if ((attackPokemonOne + defensePokemonOne) >
                    (attackPokemonTwo + defensePokemonTwo)) {
                return indexPokemonOne;
            } else {
                return indexPokemonTwo;
            }
        }
        if(checkAttack && checkHp) {
            if ((attackPokemonOne + hpPokemonOne) >
                    (attackPokemonTwo + hpPokemonTwo)) {
                return indexPokemonOne;
            } else {
                return indexPokemonTwo;
            }
        }
        if(checkDefense && checkHp) {
            if ((defensePokemonOne + hpPokemonOne) >
                    (defensePokemonTwo + hpPokemonTwo)) {
                return indexPokemonOne;
            } else {
                return indexPokemonTwo;
            }
        }
        if(checkAttack) {
            if ((attackPokemonOne ) > (attackPokemonTwo)) {
                return indexPokemonOne;
            } else {
                return indexPokemonTwo;
            }
        }
        if(checkDefense) {
            if ((defensePokemonOne) > (defensePokemonTwo)) {
                return indexPokemonOne;
            } else {
                return indexPokemonTwo;
            }
        }
        if(checkHp) {
            if ((hpPokemonOne) > (hpPokemonTwo)) {
                return indexPokemonOne;
            } else {
                return indexPokemonTwo;
            }
        }
        return -1;
    }
}
