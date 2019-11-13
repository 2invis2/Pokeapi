package com.invis.pokeapi.features.data;

import com.invis.pokeapi.features.data.model.PokemonJson;
import com.invis.pokeapi.features.data.model.PokemonListUrl;
import com.invis.pokeapi.features.entity.Pokemon;
import com.invis.pokeapi.network.Carry;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PokemonRepositoryImpl implements PokemonRepository {
    private PokemonServer pokemonServer;

    @Override
    public void loadPokemonList(final Carry<Pokemon> carry) {
        pokemonServer.loadPokemonListUrl(new Carry<PokemonListUrl>() {

            @Override
            public void onSuccess(PokemonListUrl result) {
           //     pokemonListUrl = new PokemonListUrl(result);
                //System.out.println(result.getCount());
             //   for (int i = 0; i < result.getResults().size(); i++) {
                int i=0;
                    String[] urlSplitArray = result.getResults().get(i).getUrl().split("/");
                    pokemonServer.getPokemon(urlSplitArray[6], new Carry<PokemonJson>() {
                                @Override
                                public void onSuccess(PokemonJson result) {
                                    carry.onSuccess(result.toPokemon());
                                }

                                @Override
                                public void onFailure(Throwable throwable) {}
                            }
                    );
               // }
            }


            @Override
            public void onFailure(Throwable throwable) {
                System.out.println(throwable);
            }
        });
    }
}
