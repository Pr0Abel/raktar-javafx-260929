package com.example.raktar;

public class Raktar {
    private String id;
    private String targy;

    public Raktar(String id, String targy) {
        this.id = id;
        this.targy = targy;
    }

    public String getId() {
        return id;
    }

    public String getTargy() {
        return targy;
    }

    @Override
    public String toString() {
        return targy;
    }
}
