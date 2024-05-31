package com.ps.menu;


public class Drink {

    //variables for drinks
    private String size;
    private String flavor;
    private double price;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
        this.price = calculatePrice(size);
    }

    private double calculatePrice(String size) {
        switch (size.toLowerCase()) {
            case "small":
                return 2.00;
            case "medium":
                return 2.50;
            case "large":
                return 3.00;
            default:
                return 0;
        }
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Drink Size: %s, Flavor: %s, Price: $%.2f", size, flavor, price);
    }
}

