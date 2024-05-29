package com.ps.pos;

import com.ps.menu.*;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class POS implements POSInterface {
    private Order currentOrder;
    private Scanner scanner;

    public POS() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void takeOrder() {
        List<Sandwich> sandwiches = new ArrayList<>();
        List<Drink> drinks = new ArrayList<>();
        List<Chip> chips = new ArrayList<>();

        boolean moreSandwiches = true;
        while (moreSandwiches) {
            System.out.println("1) Create a custom sandwich");
            System.out.println("2) Choose a signature sandwich");
            int choice = scanner.nextInt();
            Sandwich sandwich = null;
            if (choice == 1) {
                sandwich = createSandwich();
            } else if (choice == 2) {
                sandwich = chooseSignatureSandwich();
                if (sandwich != null) {
                    customizeSandwich(sandwich);
                }
            }
            if (sandwich != null) {
                sandwiches.add(sandwich);
            }

            System.out.println("Would you like to add another sandwich? (yes/no)");
            moreSandwiches = scanner.next().equalsIgnoreCase("yes");
        }

        boolean moreDrinks = true;
        while (moreDrinks) {
            System.out.println("Would you like to add a drink? (yes/no)");
            if (scanner.next().equalsIgnoreCase("yes")) {
                drinks.add(createDrink());
            } else {
                moreDrinks = false;
            }
        }

        boolean moreChips = true;
        while (moreChips) {
            System.out.println("Would you like to add chips? (yes/no)");
            if (scanner.next().equalsIgnoreCase("yes")) {
                chips.add(createChip());
            } else {
                moreChips = false;
            }
        }

        currentOrder = new Order(sandwiches, drinks, chips);
    }

    private Sandwich createSandwich() {
        scanner.nextLine();  // Consume the newline character left over from previous input

        // Select bread type
        System.out.println("Select your bread type (white, wheat, rye, wrap):");
        String breadType = scanner.nextLine();

        // Select sandwich size
        System.out.println("Select sandwich size (4, 8, 12):");
        String size = scanner.nextLine();

        // Select regular toppings
        List<String> regularToppings = new ArrayList<>();
        System.out.println("Select your regular toppings (lettuce, peppers, onions, tomatoes, jalapenos, cucumbers, pickles, guacamole, mushrooms). Type 'done' when finished:");
        while (true) {
            String topping = scanner.nextLine();
            if (topping.equalsIgnoreCase("done")) break;
            if (Arrays.asList("lettuce", "peppers", "onions", "tomatoes", "jalapenos", "cucumbers", "pickles", "guacamole", "mushrooms").contains(topping.toLowerCase())) {
                regularToppings.add(topping);
            } else {
                System.out.println("Invalid topping. Please choose a valid regular topping or type 'done' to finish:");
            }
        }

        // Select premium toppings
        List<String> premiumToppings = new ArrayList<>();
        System.out.println("Select your premium toppings (steak, ham, salami, roast beef, chicken, bacon, american, provolone, cheddar, swiss, extra meat, extra cheese). Type 'done' when finished:");
        while (true) {
            String topping = scanner.nextLine();
            if (topping.equalsIgnoreCase("done")) break;
            if (Arrays.asList("steak", "ham", "salami", "roast beef", "chicken", "bacon", "american", "provolone", "cheddar", "swiss", "extra meat", "extra cheese").contains(topping.toLowerCase())) {
                premiumToppings.add(topping);
            } else {
                System.out.println("Invalid topping. Please choose a valid premium topping or type 'done' to finish:");
            }
        }

        // Select sauces
        System.out.println("Select your sauces (mayo, mustard, ketchup, ranch, thousand islands, vinaigrette). Type 'done' when finished:");
        while (true) {
            String sauce = scanner.nextLine();
            if (sauce.equalsIgnoreCase("done")) break;
            if (Arrays.asList("mayo", "mustard", "ketchup", "ranch", "thousand islands", "vinaigrette").contains(sauce.toLowerCase())) {
                regularToppings.add(sauce);  // Add sauces to regular toppings
            } else {
                System.out.println("Invalid sauce. Please choose a valid sauce or type 'done' to finish:");
            }
        }

        // Toasted option
        System.out.println("Would you like the sandwich toasted? (yes/no):");
        boolean isToasted = scanner.nextLine().equalsIgnoreCase("yes");

        return new Sandwich(size, breadType, regularToppings, premiumToppings, isToasted);
    }


    private Sandwich chooseSignatureSandwich() {
        System.out.println("Choose a signature sandwich:");
        System.out.println("1) BLT");
        System.out.println("2) Philly Cheese Steak");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                return new BLTSandwich();
            case 2:
                return new PhillyCheeseSteakSandwich();
            default:
                System.out.println("Invalid choice. Returning to menu.");
                return null;
        }
    }

    private void customizeSandwich(Sandwich sandwich) {
        // Implement sandwich customization logic
    }

    private Drink createDrink() {
        System.out.println("Enter drink size (small, medium, large):");
        String size = scanner.next();
        System.out.println("Enter drink flavor:");
        String flavor = scanner.next();
        return new Drink(size, flavor);
    }

    private Chip createChip() {
        System.out.println("Enter chip type:");
        String type = scanner.next();
        return new Chip(type);
    }

    @Override
    public void processPayment() {
        System.out.println(currentOrder);
        System.out.println("Confirm order? (yes/no):");
        if (scanner.next().equalsIgnoreCase("yes")) {
            printReceipt();
            System.out.println("Order confirmed.");
        } else {
            System.out.println("Order cancelled.");
        }
    }

    @Override
    public void printReceipt() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        String filename = "receipts.txt";
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(currentOrder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

