package com.invis.pokeapi.features.entity;

public class Wrapper<T> {

    private String status;
    private String message;
    private T data;

    public Wrapper(T data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
