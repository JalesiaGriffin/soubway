package com.pluralsight.deli;

import java.util.ArrayList;

public class Sandwich implements Price {
    private final  double PRICE;

    public Sandwich(double price) {
        PRICE = price;
    }

    public Sandwich(double PRICE, String bread, ArrayList<toppings> toppings, boolean toasted, boolean extraCheese, boolean extraMeat) {
        this.PRICE = PRICE;
        this.bread = bread;
        this.toppings = toppings;
        this.toasted = toasted;
        this.extraCheese = extraCheese;
        this.extraMeat = extraMeat;
    }

    private String bread;
    private ArrayList<toppings> toppings = new ArrayList<toppings>();
    private boolean toasted;
    private boolean extraCheese;
    private boolean extraMeat;


    @Override
    public double getPrice() {

    }
}
