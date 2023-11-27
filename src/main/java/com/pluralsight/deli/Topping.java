package com.pluralsight.deli;

public abstract class Topping implements Price {
private String name;
private double price;




    @Override
    public double getPrice() {
        return 0;
    }
}
