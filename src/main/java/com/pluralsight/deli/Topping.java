package com.pluralsight.deli;

public abstract class Topping implements Price {
private String name;
private double price;

    public Topping(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice(){return price;}

    public double getPrice(String size){return price;}

}
