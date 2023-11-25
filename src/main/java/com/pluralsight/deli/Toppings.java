package com.pluralsight.deli;

public abstract class Toppings implements Price {

    @Override
    public double getPrice() {
        return 0;
    }
}
