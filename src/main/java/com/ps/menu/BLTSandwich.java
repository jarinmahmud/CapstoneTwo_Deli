package com.ps.menu;


import java.util.Arrays;

public class BLTSandwich extends SignatureSandwich {

    public BLTSandwich() {
        super("8", "white", Arrays.asList("lettuce", "tomato"), Arrays.asList("bacon", "cheddar"), true);
    }

    @Override
    public String getName() {
        return "BLT";
    }
}

