package com.ps;
import com.ps.pos.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        POS pos = new POS();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to DELI-cious POS");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            int choice = scanner.nextInt();

            if (choice == 1) {
                pos.takeOrder();
                pos.processPayment();
            } else if (choice == 0) {
                System.out.println("Exiting the application...");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
