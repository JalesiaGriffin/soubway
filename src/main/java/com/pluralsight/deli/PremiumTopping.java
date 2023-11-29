package com.pluralsight.deli;

import java.util.*;

public class PremiumTopping extends Topping {
    private final List<String> meats = new ArrayList<>(Arrays.asList("steak", "ham", "salami", "roast beef", "chicken", "bacon"));
    private final List<String> cheese = new ArrayList<>(Arrays.asList("american", "provolone", "cheddar", "swiss"));

    public PremiumTopping(String name) {
        super(name);
    }

    @Override
    public double getPrice(String size){
        double price = 0.0;
        if (isMeat()){
            switch(size){
                case "4"-> price = 1.00;
                case "8" -> price = 2.00;
                case "12" -> price = 3.00;
                default -> System.out.println("invalid.");
            }
        } else if (isCheese()){
            switch(size){
                case "4"-> price = .75;
                case "8" -> price = 1.50;
                case "12" -> price = 2.25;
                default -> System.out.println("invalid.");
            }
        }
    return price;
    }

    private boolean isMeat(){
        return meats.contains(getName().toLowerCase());
    }

    private boolean isCheese(){
        return cheese.contains(getName().toLowerCase());
    }
}
