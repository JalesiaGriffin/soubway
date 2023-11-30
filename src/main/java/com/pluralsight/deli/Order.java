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
        System.out.println("Checkout");
        System.out.println(receipt());
    }

    public String receipt() {
        StringBuilder sb = new StringBuilder();

        if(!sandwiches.isEmpty()){
            sb.append("\nSandwiches");
            sandwiches.forEach(s -> {
                sb.append("\n").append(s.getBread().toLowerCase()).append(" bread ").append("sandwich");
                sb.append("\ntoppings");
                s.getToppings().forEach(t -> sb.append("\n").append(" - ").append(t.getName()));
            });
        }

        if (!drinks.isEmpty()){
            sb.append("\n\nDrinks");
            drinks.forEach(d ->{
                sb.append("\n").append(" - ").append(d.getSize()).append(" ").append(d.getFlavor());
            });
        }

        if (!chips.isEmpty()){
            sb.append("\n\nChips");
            chips.forEach(c ->{
                sb.append("\n").append(" - ").append(c.getName());
            });
        }

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
