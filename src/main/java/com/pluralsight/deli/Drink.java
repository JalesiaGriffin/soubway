package com.pluralsight.deli;

public class Drink implements Price {
    private String size;
    private String flavor;
    private double price;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public String toString() {
        return "Drinks{" +
                "size='" + size + '\'' +
                ", flavor='" + flavor + '\'' +
                '}';
    }

    @Override
    public double getPrice() {
        switch(size.toLowerCase()){
            case "small"-> price = 0.75;
            case "medium" -> price = 1.50;
            case "large" -> price = 2.25;
            default -> System.out.println("invalid.");
        }
        return price;
    }
}
