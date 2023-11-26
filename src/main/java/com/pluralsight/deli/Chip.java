package com.pluralsight.deli;

import javax.swing.*;
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

    public Chip(String name, double price) {
        this.name = name;
        this.price = price;
    }
    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String toString(){
        return name + " $" + price;
    }






}
