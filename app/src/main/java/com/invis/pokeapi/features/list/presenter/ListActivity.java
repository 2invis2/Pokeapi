package com.invis.pokeapi.features.list.presenter;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.invis.pokeapi.R;
import com.invis.pokeapi.features.BaseActivity;
import com.invis.pokeapi.features.MvpView;
import com.invis.pokeapi.features.entity.Pokemon;

import java.util.ArrayList;

public class ListActivity extends BaseActivity implements ListView {

    private ListPresenter presenter;
    private TextView pokemon;
    private ArrayList<Pokemon> pokemonList;

    @Override
    protected  ListPresenter getPresenter() {
        presenter = new PresenterFactory().createPresenter(this);
        return presenter;
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

        pokemon = (TextView) findViewById(R.id.text_view);
    }

    @Override
    protected void onStart(){
        super.onStart();
        presenter.loadPokemonList();
    }

    @Override
    public void showPokemonList(Pokemon pokemonServer) {
        pokemonList = new ArrayList<Pokemon>(0);
        pokemonList.add(pokemonServer);

        pokemon.setText(pokemonList.get(0).getName());
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
