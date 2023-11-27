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
        
    }
}
