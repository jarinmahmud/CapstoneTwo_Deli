package com.ps.pos;

import com.ps.menu.*;
import java.io.File;
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

    //Color variable for font
    String resetColor = "\u001B[0m"; // reset variable of font color
    String makeYellow = "\u001B[33m"; // setting variable for yellow font color
    String makeBlue = "\u001B[34m"; // setting variable for blue font color

    public POS() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    // taking order method
    public void takeOrder() {

        //Lists to hold menu items as arraylist
        List<Sandwich> sandwiches = new ArrayList<>();
        List<Drink> drinks = new ArrayList<>();
        List<Chip> chips = new ArrayList<>();

        boolean moreSandwiches = true;
        while (moreSandwiches) {
            //Order Screen
            System.out.println(makeYellow + "Order Screen" + resetColor);
            System.out.println(makeYellow + "............." + resetColor);
            System.out.println("(1) Create a custom sandwich");
            System.out.println("(2) Choose a signature sandwich");
            System.out.println("(3) Only Drink and/or Chips");

            //enter choice
            int choice = scanner.nextInt();
            Sandwich sandwich = null;
            if (choice == 1) {
                sandwich = createSandwich(); // calls to create sandwich
            } else if (choice == 2) {
                sandwich = chooseSignatureSandwich(); // calls to create custom sandwich
            }else if  (choice == 3) {
            break;
            }else{
                System.out.println(makeBlue + "Invalid Option." +resetColor);
            }
            //adding more sandwich
            if (sandwich != null) {
                sandwiches.add(sandwich);
            }

            System.out.println(makeYellow + "Would you like to add another sandwich? (yes/no)" + resetColor);
            moreSandwiches = scanner.next().equalsIgnoreCase("yes");
        }

        // adding drinks
        boolean moreDrinks = true;
        while (moreDrinks) {
            System.out.println(makeYellow + "Would you like to add a drink? (yes/no)" + resetColor);
            if (scanner.next().equalsIgnoreCase("yes")) {
                drinks.add(createDrink());
            } else {
                moreDrinks = false;
            }
        }

        //adding chips
        boolean moreChips = true;
        while (moreChips) {
            System.out.println(makeYellow + "Would you like to add chips? (yes/no)" + resetColor);
            if (scanner.next().equalsIgnoreCase("yes")) {
                chips.add(createChip());
            } else {
                moreChips = false;
            }
        }
        currentOrder = new Order(sandwiches, drinks, chips);
    }

    // creating sandwich method
    private Sandwich createSandwich() {
        scanner.nextLine();  //newline

        // Selecting bread type
        System.out.println(makeYellow + "SELECT BREAD TYPE:" +resetColor + " \n white \n wheat \n rye \n wrap ");
        String breadType = scanner.nextLine();
            switch (breadType.toLowerCase()) {
                case "white":
                    break;
                case "wheat":
                    break;
                case "rye":
                    break;
                case "wrap":
                    break;
                default:
                    System.out.println(makeBlue + "Invalid Choice." +resetColor);
                    return null;
            }

        // Selecting sandwich size
        System.out.println(makeYellow + "SELECT SANDWICH SIZE:" +resetColor + "\n 4 \n 8 \n 12 ");
        String size = scanner.nextLine();
        switch (size.toLowerCase()) {
            case "4":
                break;
            case "8":
                break;
            case "12":
                break;
            default:
                System.out.println(makeBlue + "Invalid Choice." +resetColor);
                return null;
        }

        // Selecting regular toppings
        List<String> regularToppings = new ArrayList<>(); // arraylist of toppings
        System.out.println(makeYellow + "SELECT REGULAR TOPPING:" +resetColor+ " \n lettuce \n peppers \n onions \n tomatoes \n jalapenos \n cucumbers \n pickles \n guacamole \n mushrooms \n Type 'done' when finished.");
        while (true) {
            String topping = scanner.nextLine();
            if (topping.equalsIgnoreCase("done")) break;
            if (Arrays.asList("lettuce", "peppers", "onions", "tomatoes", "jalapenos", "cucumbers", "pickles", "guacamole", "mushrooms").contains(topping.toLowerCase())) {
                regularToppings.add(topping);
            } else {
                System.out.println(makeBlue + "Invalid topping. Please choose a valid regular topping or type 'done' to finish:" +resetColor);
            }
        }

        // Selecting premium toppings
        List<String> premiumToppings = new ArrayList<>(); // arraylist of premium topping
        System.out.println(makeYellow + "SELECT PREMIUM TOPPING AND CHEESE: " +resetColor+ " \n steak \n ham \n salami \n roasted beef \n chicken \n bacon \n american \n provolone" +
                " \n cheddar \n swiss \n extra meat \n extra cheese \n Type 'done' when finished.");
        while (true) {
            String topping = scanner.nextLine();
            if (topping.equalsIgnoreCase("done")) break;
            if (Arrays.asList("steak", "ham", "salami", "roast beef", "chicken", "bacon", "american", "provolone", "cheddar", "swiss", "extra meat", "extra cheese").contains(topping.toLowerCase())) {
                premiumToppings.add(topping);
            } else {
                System.out.println(makeBlue + "Invalid topping. Please choose a valid premium topping or type 'done' to finish:" +resetColor);
            }
        }

        // Selecting sauces
        System.out.println(makeYellow + "SELECT SAUCES:  "+resetColor+ "\n mayo \n mustard \n ketchup \n ranch \n thousand islands \n vinaigrette \n Type 'done' when finished. " );
        while (true) {
            String sauce = scanner.nextLine();
            if (sauce.equalsIgnoreCase("done")) break;
            if (Arrays.asList("mayo", "mustard", "ketchup", "ranch", "thousand islands", "vinaigrette").contains(sauce.toLowerCase())) {
                regularToppings.add(sauce);  // Add sauces to regular toppings
            } else {
                System.out.println(makeBlue + "Invalid sauce. Please choose a valid sauce or type 'done' to finish:" +resetColor);
            }
        }

        // Toasted option
        System.out.println(makeYellow + "Would you like the sandwich toasted? (yes/no):" +resetColor);
        boolean isToasted = scanner.nextLine().equalsIgnoreCase("yes");

        return new Sandwich(size, breadType, regularToppings, premiumToppings, isToasted);
    }

    // choosing signature sandwich method
    private Sandwich chooseSignatureSandwich() {
        System.out.println(makeYellow + "Choose a signature sandwich:" +resetColor);
        System.out.println("(1) BLT");
        System.out.println("(2) Philly Cheese Steak");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                return new BLTSandwich();
            case 2:
                return new PhillyCheeseSteakSandwich();
            default:
                System.out.println(makeBlue + "Invalid choice. Returning to menu." +resetColor);
                return null;
        }
    }

    //choosing drink
    private Drink createDrink() {
        System.out.println(makeYellow + "ENTER DRINK SIZE:" + resetColor + " \n small \n medium \n large");
        String size = scanner.next();
        switch (size.toLowerCase()) {
            case "small":
                break;
            case "medium":
                break;
            case "large":
                break;
            default:
                System.out.println(makeBlue + "Invalid Choice." +resetColor);
                return null;
        }
        System.out.println(makeYellow + "ENTER YOUR PREFFERED DRINK:" +resetColor + "\n coke \n fanta \n gatorade");
        String drinkName = scanner.next();
        switch (drinkName.toLowerCase()) {
            case "coke":
                break;
            case "fanta":
                break;
            case "gatorade":
                break;
            default:
                System.out.println(makeBlue + "Invalid Choice." +resetColor);
                return null;
        }
        return new Drink(size, drinkName);
    }

    //Choosing Chips
    private Chip createChip() {
        System.out.println(makeYellow + "ENTER CHIPS TYPE:" + resetColor + "\n potato \n sweet potato \n banana");
        String type = scanner.next();
        switch (type.toLowerCase()) {
            case "potato":
                break;
            case "sweet potato":
                break;
            case "banana":
                break;
            default:
                System.out.println(makeBlue + "Invalid Choice." +resetColor);
                return null;
        }
        return new Chip(type);
    }

    //Processing Payment
    @Override
    public void processPayment() {
        System.out.println(currentOrder);
        System.out.println(makeYellow + "Confirm order? (yes/no):" +resetColor);
        if (scanner.next().equalsIgnoreCase("yes")) {
            printReceipt();
            System.out.println(makeBlue + "Order confirmed." +resetColor);
        } else {
            System.out.println(makeBlue + "Order cancelled." +resetColor);
        }
    }

    //printing and storing receipt
    @Override
    public void printReceipt() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        String directoryPath = "receipts";
        String filename = directoryPath + "/" + timestamp + ".txt";

        // Creating the receipts directory if it doesn't exist
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(currentOrder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}