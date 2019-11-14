package com.invis.pokeapi.features.description.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.invis.pokeapi.R;
import com.invis.pokeapi.features.BaseActivity;
import com.invis.pokeapi.features.MvpView;
import com.invis.pokeapi.features.entity.Pokemon;
import com.invis.pokeapi.features.list.presenter.ListActivity;

import java.util.ArrayList;

public class DescriptionActivity extends BaseActivity implements DescriptionView {
    private DescriptionPresenter descriptionPresenter;
    private Pokemon pokemon;
    private ArrayList<Pokemon> pokemonList;
    private ImageView pokemonImageView;
    private TextView pokemonNameView;
    private TextView pokemonNumberView;
    private TextView pokemonWeightView;
    private TextView pokemonHeightView;
    private TextView pokemonType1View;
    private TextView pokemonType2View;
    private TextView pokemonAttackView;
    private TextView pokemonDefenseView;
    private TextView pokemonHpView;

    @Override
    protected  DescriptionPresenter getPresenter() {
        descriptionPresenter = new DescriptionPresenter();
        return descriptionPresenter;
    }

    @Override
    protected MvpView getMvpView() {
        return this;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        pokemon = (Pokemon)getIntent().getParcelableExtra("Pokemon");
        pokemonList = getIntent().<Pokemon>getParcelableArrayListExtra("PokemonList");

        initView();
    }

    @Override
    protected void onPause() {
        super.onPause();
        descriptionPresenter.hideActivity();
    }

    @Override
    protected void onStart(){
        super.onStart();
        descriptionPresenter.onViewReady();
    }

    private void initView(){
        pokemonImageView = (ImageView) findViewById(R.id.description_pokemon_sprites);
        pokemonNameView = (TextView) findViewById(R.id.description_pokemon_name);
        pokemonNumberView = (TextView) findViewById(R.id.description_pokemon_number);
        pokemonWeightView = (TextView) findViewById(R.id.description_pokemon_weight);
        pokemonHeightView = (TextView) findViewById(R.id.description_pokemon_height);
        pokemonType1View = (TextView) findViewById(R.id.description_pokemon_type1);
        pokemonType2View = (TextView) findViewById(R.id.description_pokemon_type2);
        pokemonAttackView = (TextView) findViewById(R.id.description_pokemon_attack);
        pokemonDefenseView = (TextView) findViewById(R.id.description_pokemon_defense);
        pokemonHpView = (TextView) findViewById(R.id.description_pokemon_hp);
    }



    @Override
    public void hideActivity() {
        super.onStop();
        Intent intent = new Intent(DescriptionActivity.this, ListActivity.class);
        intent.putExtra("Load", false);
        intent.putParcelableArrayListExtra ("PokemonList", pokemonList);
        startActivity(intent);
    }

    @Override
    public void showPokemon() {
        pokemonNameView.setText(pokemon.getName());
        pokemonNumberView.setText(pokemonNameView.getText() +
                String.valueOf(pokemon.getOrder()));
        pokemonWeightView.setText(pokemonWeightView.getText() +
                String.valueOf(pokemon.getWeight()));
        pokemonHeightView.setText(pokemonHeightView.getText() +
                String.valueOf(pokemon.getHeight()));
        pokemonType1View.setText(pokemonType1View.getText()
                + pokemon.getTypes().get(0));
        if (pokemon.getTypes().size() == 2) {
            pokemonType2View.setVisibility(View.VISIBLE);
            pokemonType2View.setText(pokemonType2View.getText()
                    + pokemon.getTypes().get(1));
        }
        pokemonAttackView.setText(pokemonAttackView.getText() +
                String.valueOf(pokemon.getStats().get(pokemon.indexStat("attack")).getValue()));
        pokemonDefenseView.setText(pokemonDefenseView.getText() +
                String.valueOf(pokemon.getStats().get(pokemon.indexStat("defense")).getValue()));
        pokemonHpView.setText(pokemonHpView.getText() +
                String.valueOf(pokemon.getStats().get(pokemon.indexStat("hp")).getValue()));
    }
}
