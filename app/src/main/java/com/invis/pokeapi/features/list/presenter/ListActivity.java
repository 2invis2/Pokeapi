package com.invis.pokeapi.features.list.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.invis.pokeapi.R;
import com.invis.pokeapi.features.BaseActivity;
import com.invis.pokeapi.features.MvpView;
import com.invis.pokeapi.features.description.presenter.DescriptionActivity;
import com.invis.pokeapi.features.entity.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends BaseActivity implements ListView {

    private ListPresenter listPresenter;
    private ArrayList<Pokemon> pokemonList;
    private RecyclerView recyclerView;
    private PokemonAdapter adapter;
    private boolean load;

    @Override
    protected  ListPresenter getPresenter() {
        listPresenter = new ListPresenterFactory().createPresenter(this);
        return listPresenter;
    }

    @Override
    protected MvpView getMvpView() {
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);



        initView();
    }

    private void initView(){
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new PokemonAdapter(this, new PokemonAdapter.SelectPokemonListener() {
            @Override
            public void onPokemonSelect(Pokemon pokemon) {
                listPresenter.onPokemonSelected(pokemon);
            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onStart(){
        super.onStart();
        load = true;

        load = getIntent().getBooleanExtra("Load", true);
        if(load) {
            listPresenter.onViewReady();
        } else {
            showPokemonList(getIntent().<Pokemon>getParcelableArrayListExtra("PokemonList"));
        }
    }

    @Override
    public void showPokemonList(List<Pokemon> pokemonList) {
        adapter.setPokemons(pokemonList);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void hideActivity(Pokemon pokemon) {
        super.onStop();
        Intent intent = new Intent(ListActivity.this, DescriptionActivity.class);
        intent.putExtra("Pokemon", pokemon);
        intent.putParcelableArrayListExtra ("PokemonList", (ArrayList<Pokemon>) adapter.getPokemons());
        startActivity(intent);
    }
}
