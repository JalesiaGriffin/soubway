package com.pluralsight.deli;

import java.util.ArrayList;

public class Order {
    private static ArrayList<Order> order = new ArrayList<Order>();

    public void  addSandwich(Sandwich sandwich){
        order.add(sandwich);
    }
    public void  addChips(Chips chips) {
        order.add(chips);
    }
    public void addDrinks (Drinks drinks){
        order.add(drinks);
    }

}
