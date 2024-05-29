package com.ps.menu;


import java.util.Arrays;

public class PhillyCheeseSteakSandwich extends SignatureSandwich {

    public PhillyCheeseSteakSandwich() {
        super("8", "white", Arrays.asList("peppers", "mayo"), Arrays.asList("steak", "american"), true);
    }

    @Override
    public String getName() {
        return "Philly Cheese Steak";
    }
}

