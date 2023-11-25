package com.pluralsight.deli;

public class Chips implements Price {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Chips(String name) {
        this.name = name;
    }

    public String name;
    @Override
    public double getPrice() {
        return 0;
    }

}
