package com.pluralsight.deli;

import java.util.ArrayList;

public class Sandwich implements Price {
    private double price;
    public Sandwich(double price, String bread, boolean toasted, boolean extraCheese, boolean extraMeat) {
        this.price = price;
        this.bread = bread;
        this.toasted = toasted;
        this.extraCheese = extraCheese;
        this.extraMeat = extraMeat;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public ArrayList<Toppings> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<Toppings> toppings) {
        this.toppings = toppings;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public boolean isExtraCheese() {
        return extraCheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public boolean isExtraMeat() {
        return extraMeat;
    }

    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
    }

    private String bread;
    private ArrayList<Toppings> toppings = new ArrayList<Toppings>();
    private boolean toasted;
    private boolean extraCheese;
    private boolean extraMeat;





    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {

    }

}
