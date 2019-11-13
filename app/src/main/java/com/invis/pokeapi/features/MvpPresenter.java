package com.invis.pokeapi.features;

public class MvpPresenter<View extends MvpView> {

    protected View view;

    public void attachView(View view) {
        this.view = view;
        onViewReady();
    }

    public void detachView() {
        view = null;
    }

    protected void onViewReady() {
    }
}
