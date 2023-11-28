package com.pluralsight.deli;

public abstract class Topping implements Price {
private String name;
private String size;
private double price;

    public Topping(String name, String size) {
        this.name = name;
        this.size = size;
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

    public String getSize() {
        return size;
    }

    public abstract double getPrice();

}
