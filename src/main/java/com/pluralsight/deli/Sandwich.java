package com.pluralsight.deli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sandwich implements Price {
    private String bread;
    private ArrayList<Topping> toppings;
    private boolean toasted;
    private boolean extraCheese;
    private boolean extraMeat;
    private String size;
    private double price;

    public Sandwich(String bread, String size) {
        this.bread = bread;
        this.toppings = new ArrayList<Topping>();
        this.size = size;
        extraMeat = false;
        extraCheese = false;
        toasted = false;
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

    public boolean isToasted() {return toasted;}

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    @Override
    public double getPrice() {
        switch (getSize()) {
            case "4" -> price = 5.50;
            case "8" -> price = 7.00;
            case "12" -> price = 8.50;
            default -> System.out.println("invalid size.");
        }

        if(isExtraMeat()) {
            switch (size) {
                case "4" -> price += 0.50;
                case "8" -> price += 1.00;
                case "12" -> price += 1.50;
                default -> System.out.println("invalid size.");
            }
        }

        if(isExtraCheese()){
            switch (size) {
                case "4" -> price += 0.30;
                case "8" -> price += 0.60;
                case "12" -> price += 0.90;
                default -> System.out.println("invalid size.");
            }
        }
        return price;
    }

    public boolean isExtraCheese() {
        return extraCheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public boolean isExtraMeat() {return extraMeat;}

    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public void addExtraCheese(){
        extraCheese = true;
    }

    public void addExtraMeat(){
        extraMeat = true;
    }

    public void toast(){toasted = true;}
    public ArrayList<PremiumTopping> getPremiumToppings() {
        return new ArrayList<>(Arrays.asList((PremiumTopping)toppings.get(0), (PremiumTopping) toppings.get(1)));
    }
}



