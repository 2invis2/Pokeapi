package com.invis.pokeapi.features.list.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.invis.pokeapi.R;
import com.invis.pokeapi.features.entity.Pokemon;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonHolder> {

    private final List<Pokemon> pokemons = new ArrayList<>();
    private final LayoutInflater inflater;
    private final SelectPokemonListener selectPokemonListener;

    PokemonAdapter(Context context, SelectPokemonListener selectPokemonListener) {
        inflater = LayoutInflater.from(context);
        this.selectPokemonListener = selectPokemonListener;
    }

    @NonNull
    @Override
    public PokemonHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View itemView = inflater.inflate(R.layout.pokemon_item, parent, false);
        return new PokemonHolder(itemView, selectPokemonListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonHolder holder, int position) {
        holder.bind(pokemons.get(position));
    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }

    public void setPokemons(List<Pokemon> pokemonList) {
        pokemons.clear();
        pokemons.addAll(pokemonList);
        notifyDataSetChanged();
    }

    public List<Pokemon> getPokemons(){
        return pokemons;
    }

    class PokemonHolder extends RecyclerView.ViewHolder {

        private final TextView pokemonNameView;
        private final TextView pokemonAttackView;
        private final TextView pokemonDefenseView;
        private final TextView pokemonHpView;
        private final ImageView pokemonImageView;
        private final SelectPokemonListener selectPokemonListener;

        PokemonHolder(View view, SelectPokemonListener selectBookListener) {
            super(view);
            this.selectPokemonListener = selectBookListener;
            pokemonImageView = view.findViewById(R.id.pokemon_item_image);
            pokemonNameView = view.findViewById(R.id.pokemon_item_name);
            pokemonAttackView = view.findViewById(R.id.pokemon_item_attack);
            pokemonDefenseView = view.findViewById(R.id.pokemon_item_defense);
            pokemonHpView = view.findViewById(R.id.pokemon_item_hp);
        }

        void bind(final Pokemon pokemon) {

            Picasso.get()
                    .load(pokemon.getImageUrl())
                    .placeholder(R.drawable.pokemon_placeholder)
                    .error(R.drawable.pokemon_placeholder_error)
                    .into(pokemonImageView);

            pokemonNameView.setText(pokemon.getName());

            pokemonAttackView.setText(R.string.str_attack);
            pokemonAttackView.setText(pokemonAttackView.getText() +
                    String.valueOf(pokemon.getStats().get(pokemon.indexStat("attack")).getValue()));

            pokemonDefenseView.setText(R.string.str_defense);
            pokemonDefenseView.setText(pokemonDefenseView.getText() +
                    String.valueOf(pokemon.getStats().get(pokemon.indexStat("defense")).getValue()));

            pokemonHpView.setText(R.string.str_hp);
            pokemonHpView.setText(pokemonHpView.getText() +
                    String.valueOf(pokemon.getStats().get(pokemon.indexStat("hp")).getValue()));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectPokemonListener.onPokemonSelect(pokemon);
                }
            });
        }
    }

    interface SelectPokemonListener {

        void onPokemonSelect(Pokemon pokemon);
    }

}