package com.ps.pos;

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
            System.out.println("Customizing sandwich...");
            Sandwich sandwich = createSandwich();
            sandwiches.add(sandwich);

            System.out.println("Would you like to add another sandwich? (yes/no)");
            moreSandwiches = scanner.next().equalsIgnoreCase("yes");
        }

        boolean moreDrinks = true;
        while (moreDrinks) {
            System.out.println("Would you like to add a drink? (yes/no)");
            if (scanner.next().equalsIgnoreCase("yes")) {
                Drink drink = createDrink();
                drinks.add(drink);
            } else {
                moreDrinks = false;
            }
        }

        boolean moreChips = true;
        while (moreChips) {
            System.out.println("Would you like to add chips? (yes/no)");
            if (scanner.next().equalsIgnoreCase("yes")) {
                Chip chip = createChip();
                chips.add(chip);
            } else {
                moreChips = false;
            }
        }

        currentOrder = new Order(sandwiches, drinks, chips);
    }

    private Sandwich createSandwich() {
        // Implement sandwich creation logic with user input for size, bread, toppings, etc.
        // Use scanner to take user inputs and create a Sandwich object
    }

    private Drink createDrink() {
        // Implement drink creation logic with user input for name and price
    }

    private Chip createChip() {
        // Implement chip creation logic with user input for name and price
    }

    @Override
    public void processPayment() {
        // Implement payment processing logic
        System.out.println("Processing payment...");
    }

    @Override
    public void printReceipt() {
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        String receiptFileName = "receipts/" + dateTime + ".txt";

        try (FileWriter writer = new FileWriter(receiptFileName)) {
            writer.write("Order Receipt\n");
            writer.write("====================\n");
            for (Sandwich sandwich : currentOrder.getSandwiches()) {
                writer.write(sandwich.toString() + "\n");
            }
            for (Drink drink : currentOrder.getDrinks()) {
                writer.write(drink.toString() + "\n");
            }
            for (Chip chip : currentOrder.getChips()) {
                writer.write(chip.toString() + "\n");
            }
            writer.write("====================\n");
            writer.write("Total Price: $" + currentOrder.calculateTotalPrice() + "\n");
            System.out.println("Receipt saved to " + receiptFileName);
        } catch (IOException e) {
            System.err.println("Error writing receipt: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        POS posSystem = new POS

