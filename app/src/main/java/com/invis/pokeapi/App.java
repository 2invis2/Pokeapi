package com.invis.pokeapi;

import android.app.Application;
import android.content.Context;

import com.invis.pokeapi.network.RetrofitProvider;

public final class App extends Application {

    private RetrofitProvider retrofitProvider;

    public static RetrofitProvider getRetrofitProvider(Context context) {
        return getApp(context).retrofitProvider;
    }

    private static App getApp(Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitProvider = new RetrofitProvider();
    }
}