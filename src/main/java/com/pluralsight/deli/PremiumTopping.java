package com.pluralsight.deli;

public class PremiumTopping extends Topping {
    enum meats {steak, ham, salami, roastbeef, chicken, bacon};
    enum cheeses {american, provolone, cheddar, swiss};
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

    private static boolean isMeat(){
        try (meats.valueOf(getName().toLowerCase())){
            return true;
        } catch (IllegalArgumentException e){
            return false;
        }
    }

    private static boolean isCheese(){
        try (cheeses.valueOf(getName().toLowerCase)){
            return true;
        } catch (IllegalArgumentException e){
            return false;
        }
    }
}
