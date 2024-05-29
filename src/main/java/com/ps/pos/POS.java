package com.ps.pos;

import com.ps.menu.*;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
        // Implement sandwich creation logic
        return null;
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
        String filename = "receipts/" + timestamp + ".txt";
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(currentOrder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

