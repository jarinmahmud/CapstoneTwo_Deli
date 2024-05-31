package com.ps.menu;


public class Chip {

    //declaring variable for chips
    private String type;
    private double price;

    public Chip(String type) {
        this.type = type;
        this.price = 1.50;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Chip Type: %s, Price: $%.2f", type, price);
    }
}

