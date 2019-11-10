package com.invis.pokeapi.features.list.presenter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.invis.pokeapi.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        BufferedReader reader = null;
        URL url = null;
        try {
            url = new URL("https://pokeapi.co/api/v2/pokemon/1/");
            HttpsURLConnection mConnect=(HttpsURLConnection)url.openConnection();
            mConnect.setRequestMethod("GET");
            mConnect.setReadTimeout(10000);
            mConnect.connect();
            reader= new BufferedReader(new InputStreamReader(mConnect.getInputStream()));

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
