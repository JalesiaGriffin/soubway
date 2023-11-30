package com.pluralsight.deli;

public class Chip implements Price {
    private String name;

    public Chip(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getPrice() {
        return 1.50;
    }

}