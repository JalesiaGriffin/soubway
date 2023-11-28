package com.pluralsight.deli;

import java.util.ArrayList;

public class Chip implements Price {


    private double price;
    private String name;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Chip(String name) {
        this.name = name;

    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price = 1.50;
    }

    public String toString() {
        if (getName().equalsIgnoreCase("pringles, sunchips, doritos, lays, cheetos")) {
            return name + " $" + price;
        } else {
            System.out.println("Sorry we do not have those. Please choose from the following: " +
                    "Pringles, Sunchips, Doritos, Lays, Cheetos");
        }

    }


}
















}
