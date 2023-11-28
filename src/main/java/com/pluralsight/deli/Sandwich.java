package com.pluralsight.deli;

import java.util.ArrayList;

public class Sandwich implements Price {

    //Jada please add Size

    private double price;

    public Sandwich(double price, String bread, boolean toasted, boolean extraCheese, boolean extraMeat, String size) {
        this.price = price;
        this.bread = bread;
        this.toasted = toasted;
        this.extraCheese = extraCheese;
        this.extraMeat = extraMeat;
        this.size = size;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<Topping> toppings) {
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
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    private String bread;
    private ArrayList<Topping> toppings = new ArrayList<Topping>();
    private boolean toasted;
    private boolean extraCheese;
    private boolean extraMeat;
    private String size;







    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {

    }

}
