package com.pluralsight.deli;

import java.util.*;

public class Order {
    private final List<Sandwich> sandwiches;
    private final List<Drink> drinks;
    private final List<Chip> chips;

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
        System.out.println("\nCheckout");
        System.out.println(orderDetails());
    }

    public String orderDetails() {
        StringBuilder sb = new StringBuilder();

        if(!sandwiches.isEmpty()){
            sb.append("Sandwiches");
            sandwiches.forEach(s -> {
                String toasted = s.isToasted() ? " (toasted)": "";
                sb.append("\n").append(s.getBread().toLowerCase()).append(" Bread ").append("Sandwich").append(toasted);
                sb.append("\ntoppings");
                s.getToppings().forEach(t -> sb.append("\n").append(" - ").append(t.getName()));

                if(s.isExtraMeat()){
                    sb.append("\n - extra meat");
                }
                if(s.isExtraCheese()){
                    sb.append("\n - extra cheese");
                }
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

        sb.append("\n\n").append("Total: $").append(getTotalPrice());

        return sb.toString();
    }

    public double getTotalPrice(){
        double sandwichesTotal = sandwiches.stream().mapToDouble(Sandwich::getPrice).sum();

        double toppingsTotal = 0.00;
        for (Sandwich s : sandwiches){
            for (PremiumTopping pt: s.getPremiumToppings()){
                toppingsTotal += pt.getPrice(s.getSize());
            }
        }

        double drinksTotal = drinks.stream().mapToDouble(Drink::getPrice).sum();
        double chipsTotal = chips.stream().mapToDouble(Chip::getPrice).sum();

        return sandwichesTotal + toppingsTotal + drinksTotal + chipsTotal;
    }
}
