package com.ps.menu;

import java.util.List;

public class Order {
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chip> chips;

    // Constructor
    public Order(List<Sandwich> sandwiches, List<Drink> drinks, List<Chip> chips) {
        this.sandwiches = sandwiches;
        this.drinks = drinks;
        this.chips = chips;
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Sandwich sandwich : sandwiches) {
            total += sandwich.getTotalPrice();
        }
        for (Drink drink : drinks) {
            total += drink.getPrice();
        }
        for (Chip chip : chips) {
            total += chip.getPrice();
        }
        return total;
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public void setSandwiches(List<Sandwich> sandwiches) {
        this.sandwiches = sandwiches;
    }

    public List<Chip> getChips() {
        return chips;
    }

    public void setChips(List<Chip> chips) {
        this.chips = chips;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    @Override
    public String toString() {
        return "Order{" +
                "sandwiches=" + sandwiches +
                ", drinks=" + drinks +
                ", chips=" + chips +
                '}';
    }

    // Getters and toString() method
}

