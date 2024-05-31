package com.ps.menu;
import java.util.List;

public class Sandwich {
    //declaring variables
    private String size;
    private String breadType;
    private List<String> regularToppings;
    private List<String> premiumToppings;
    private boolean isToasted;
    private double basePrice;
    private double extraCost;

    public Sandwich(String size, String breadType, List<String> regularToppings, List<String> premiumToppings, boolean isToasted) {
        this.size = size;
        this.breadType = breadType;
        this.regularToppings = regularToppings;
        this.premiumToppings = premiumToppings;
        this.isToasted = isToasted;
        this.basePrice = calculateBasePrice(size);
        this.extraCost = calculateExtraCost();
    }

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
    @Override
    public String toString() {
        return String.format("Size: %s\", Bread: %s, Toppings: %s, Premium Toppings: %s, Toasted: %b, Price: $%.2f",
                size, breadType, regularToppings.toString(), premiumToppings.toString(), isToasted, getTotalPrice());
    }
    // Getters and setters omitted for enhanced redability and memory optimization
}