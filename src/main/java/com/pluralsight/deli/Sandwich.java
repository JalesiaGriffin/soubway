package com.pluralsight.deli;

import java.util.ArrayList;

public class Sandwich implements Price {
    private final  double PRICE;
    public Sandwich(double PRICE, String bread, boolean toasted, boolean extraCheese, boolean extraMeat) {
        this.PRICE = PRICE;
        this.bread = bread;
        this.toasted = toasted;
        this.extraCheese = extraCheese;
        this.extraMeat = extraMeat;
    }

    private String bread;
    public ArrayList<Toppings> toppings = new ArrayList<Toppings>();
    private boolean toasted;
    private boolean extraCheese;
    private boolean extraMeat;





    @Override
    public double getPrice() {
        return 0;
    }

}
