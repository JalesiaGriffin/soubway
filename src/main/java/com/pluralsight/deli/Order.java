package com.pluralsight.deli;

import java.util.*;

public class Order {
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chip> chips;

    public Order() {
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
    }

    public void addSandwich(Sandwich sandwich){
        sandwiches.add(sandwich);
    }
    public void removeSandwich(Sandwich sandwich){sandwiches.remove(sandwich);}
    public void addChips(Chip chip) {
        chips.add(chip);
    }
    public void removeChip(Sandwich sandwich){sandwiches.remove(sandwich);}
    public void addDrink(Drink drink){
        drinks.add(drink);
    }
    public void removeDrink(Drink drink){drinks.remove(drink);}

    public void checkOut(){
        receipt();
    }

    public String receipt() {
        StringBuilder sb = new StringBuilder();

        sb.append("\nSandwiches");
        sandwiches.forEach(s -> {
            sb.append("\n").append(s.getBread()).append(" Sandwich");

            sb.append("\nToppings");
            s.getToppings().forEach(t -> sb.append("- ").append(t));
        });

        sb.append("\nDrinks");
        drinks.forEach(d ->{
            sb.append("-").append(d.getSize()).append(" ").append(d.getFlavor());
        });

        sb.append("\nChips");
        drinks.forEach(c ->{
            sb.append("-").append(c.getSize()).append(c.getFlavor());
        });

        sb.append("\n").append("Total: $").append(getTotalPrice());

        return sb.toString();
    }

    public double getTotalPrice(){
        double sandwichesTotal = sandwiches.stream().mapToDouble(Sandwich::getPrice).sum();
        double drinksTotal = drinks.stream().mapToDouble(Drink::getPrice).sum();
        double chipsTotal = chips.stream().mapToDouble(Chip::getPrice).sum();

        return sandwichesTotal + drinksTotal + chipsTotal;
    }
}
