package com.ps;
import com.ps.gui.WelcomeWindow;
import com.ps.pos.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Displaying the Welcome GUI
        WelcomeWindow open = new WelcomeWindow();
        open.welcomeWindow();

        //Color Variables
        String resetColor = "\u001B[0m"; // reset variable of font color
        String makeYellow = "\u001B[33m"; // setting variable for yellow font color
        String makeBlue = "\u001B[34m"; // setting variable for blue font color
        String smiley = "\uD83D\uDE00";   // prints smiley

        //Taking value for order
        POS pos = new POS();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            //Home Screen
            System.out.println(makeYellow + "Welcome to DELI-cious POS" + resetColor);
            System.out.println(makeYellow + ".........................." + resetColor);
            System.out.println("(1) New Order");
            System.out.println("(0) Exit");
            int choice = scanner.nextInt();

            if (choice == 1) {
                pos.takeOrder();
                pos.processPayment();
            } else if (choice == 0) {
                System.out.println(makeYellow + "THANK YOU. SEE YOU AGAIN." + smiley + resetColor);
                break;
            } else {
                System.out.println(makeBlue + "Invalid choice. Please try again." + resetColor);
            }
        }
        scanner.close();
        //Ensures System Exit
        System.exit(0);

    }
}
