package com.ps.menu;

import java.util.List;

public class Sandwich {
    private String size;
    private String breadType;
    private List<String> regularToppings;
    private List<String> premiumToppings;
    private boolean isToasted;
    private double basePrice;
    private double extraCost;

    // Constructor
    public Sandwich(String size, String breadType, List<String> regularToppings, List<String> premiumToppings, boolean isToasted) {
        this.size = size;
        this.breadType = breadType;
        this.regularToppings = regularToppings;
        this.premiumToppings = premiumToppings;
        this.isToasted = isToasted;
        this.basePrice = calculateBasePrice(size);
        this.extraCost = calculateExtraCost();
    }

    // Calculate base price based on size
    private double calculateBasePrice(String size) {
        switch (size) {
            case "4":
                return 5.50;
            case "8":
                return 7.00;
            case "12":
                return 8.50;
            default:
                return 0;
        }
    }

    // Calculate extra cost based on premium toppings
    private double calculateExtraCost() {
        double extraCost = 0;
        for (String topping : premiumToppings) {
            switch (topping.toLowerCase()) {
                case "steak":
                case "ham":
                case "salami":
                case "roast beef":
                case "chicken":
                case "bacon":
                    extraCost += getPremiumToppingCost(size, 1.00, 2.00, 3.00);
                    break;
                case "extra meat":
                    extraCost += getPremiumToppingCost(size, 0.50, 1.00, 1.50);
                    break;
                case "american":
                case "provolone":
                case "cheddar":
                case "swiss":
                    extraCost += getPremiumToppingCost(size, 0.75, 1.50, 2.25);
                    break;
                case "extra cheese":
                    extraCost += getPremiumToppingCost(size, 0.30, 0.60, 0.90);
                    break;
            }
        }
        return extraCost;
    }

    // Helper method to get premium topping cost
    private double getPremiumToppingCost(String size, double cost4, double cost8, double cost12) {
        switch (size) {
            case "4":
                return cost4;
            case "8":
                return cost8;
            case "12":
                return cost12;
            default:
                return 0;
        }
    }

    public double getTotalPrice() {
        return basePrice + extraCost;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public List<String> getRegularToppings() {
        return regularToppings;
    }

    public void setRegularToppings(List<String> regularToppings) {
        this.regularToppings = regularToppings;
    }

    public List<String> getPremiumToppings() {
        return premiumToppings;
    }

    public void setPremiumToppings(List<String> premiumToppings) {
        this.premiumToppings = premiumToppings;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getExtraCost() {
        return extraCost;
    }

    public void setExtraCost(double extraCost) {
        this.extraCost = extraCost;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "size='" + size + '\'' +
                ", breadType='" + breadType + '\'' +
                ", regularToppings=" + regularToppings +
                ", premiumToppings=" + premiumToppings +
                ", isToasted=" + isToasted +
                ", basePrice=" + basePrice +
                ", extraCost=" + extraCost +
                '}';
    }

    // Getters and setters
}

