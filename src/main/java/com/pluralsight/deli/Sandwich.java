package com.pluralsight.deli;

import java.util.ArrayList;

public class Sandwich implements Price {
    private String bread;
    private ArrayList<Topping> toppings = new ArrayList<Topping>();
    private boolean toasted;
    private boolean extraCheese;
    private boolean extraMeat;
    private String size;
    private double price;

    public Sandwich(String bread, String size) {
        this.bread = bread;
        this.toppings = new ArrayList<Topping>();
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

            switch (size) {
                case "4":
                    price += 0.30;
                    break;
                case "8":
                    price += 0.60;
                    break;
                case "12":
                    price += 0.90;
                    break;
                default: price += 0.0;
            }

        return extraCheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public boolean isExtraMeat() {


            switch (size) {
                case "4":
                    price += 0.50;
                    break;
                case "8":
                    price += 1.00;
                    break;
                case "12":
                    price += 1.50;
                    break;
                default: price += 0;
            }
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




    @Override
    public double getPrice() {
            switch (getSize()) {
                case "4":
                    price = 5.50;
                    break;
                case "8":
                    price = 7.00;
                    break;
                case "12":
                    price = 8.50;
                    break;
                default:
                    System.out.println("invalid size.");
            }

            price += toppings.stream().mapToDouble(Topping::getPrice).sum();

        return price;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }
}



