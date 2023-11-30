package com.pluralsight.deli;

public class Drink implements Price {
    private String size;
    private String flavor;
    private double price;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
        this.price = getPrice();
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
            case "small" -> price = 2.00;
            case "medium" -> price = 2.50;
            case "large" -> price = 3.00;
            default -> System.out.println("invalid.");
        }
        return price;
    }
}
