package com.ps.menu;


import java.util.List;

public abstract class SignatureSandwich extends Sandwich {

    public SignatureSandwich(String size, String breadType, List<String> regularToppings, List<String> premiumToppings, boolean isToasted) {
        super(size, breadType, regularToppings, premiumToppings, isToasted);
    }

    // Abstract method to get the name of the signature sandwich
    public abstract String getName();
}

