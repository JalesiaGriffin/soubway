package com.pluralsight.deli;

public abstract class Topping implements Price {

    @Override
    public double getPrice() {
        return 0;
    }
}
