package com.pluralsight.deli;

public class Drink implements Price {
    private String size;
    private String flavor;

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
        return 0;
    }

    @Override
    public void setPrice(double Price) {
        
    }


}
