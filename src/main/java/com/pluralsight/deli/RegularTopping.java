package com.pluralsight.deli;

public class RegularTopping extends Topping{
    public RegularTopping(String name) {
        super(name);
    }

    @Override
    public double getPrice() {
        return 0.00;
    }
}
