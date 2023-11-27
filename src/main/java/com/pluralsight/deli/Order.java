package com.pluralsight.deli;

import java.util.*;

public class Order {
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chip> chips;

    public void addSandwich(Sandwich sandwich){
        sandwiches.add(sandwich);
    }
    public void addChips(Chip chip) {
        chips.add(chip);
    }
    public void addDrink(Drink drink){
        drinks.add(drink);
    }

    public void checkOut(){
        System.out.println("Sandwiches");
        sandwiches.forEach(s -> {
            System.out.println("\n" + s.getBread() + " Sandwich");
            System.out.println("\nToppings");
            s.getToppings().forEach(t -> System.out.println("- "+ t));
        });

        System.out.println("\nDrinks");
        drinks.forEach(d ->{
            System.out.println("-" + d.getSize() + " " + d.getFlavor());
        });

        System.out.println("\nChips");
        drinks.forEach(c ->{
            System.out.println("-" + c.getSize() + " " + c.getFlavor());
        });

        double sandwichesTotal = sandwiches.stream().mapToDouble(Sandwich::getPrice).sum();
        double drinksTotal = drinks.stream().mapToDouble(Drink::getPrice).sum();
        double chipsTotal = chips.stream().mapToDouble(Chip::getPrice).sum();
        double totalPrice = sandwichesTotal + drinksTotal + chipsTotal;

        System.out.println("\n\nTotal Price");
        System.out.println(totalPrice);
    }
}
