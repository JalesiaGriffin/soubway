package com.pluralsight.deli;

import java.util.ArrayList;

public class Sandwich implements Price {


    private double price;

    public Sandwich(String bread, boolean toasted, boolean extraCheese, boolean extraMeat, String size) { // only needs bread and size

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
        // switch statement to add .30, .60, or .90 to the price depending on the size
        return extraCheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public boolean isExtraMeat() {
        // switch statement to add .50, 1.00, or 1.50 to the price depending on the size
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

        if (getBread().equalsIgnoreCase("white,wheat, rye, wrap")) {

            switch (getSize()) {
                case "4":
                    price = 5.50;
                case "8":
                    price = 7.00;
                case "12":
                    price = 8.50;
            }
        } else {
            System.out.println("Please input the correct size: (4 , 8, or 12");

        }
        return price;
    }

    @Override
    public void setPrice(double price) {

    }
}



