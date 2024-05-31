package com.ps.gui;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class WelcomeWindow {
    public void welcomeWindow() {
        // Creating the frame
        JFrame frame = new JFrame("Welcome to DELI-cious"); // sets the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // terminates the frame when user closes
        frame.setSize(200, 100); // sets size of frame
        frame.setLayout(new BorderLayout()); // sets layout with no gap border

        // Loading the GIF image
        ImageIcon gifIcon = new ImageIcon("logo.gif"); // paints icon from image
        JLabel label = new JLabel(gifIcon); // sets display area of the specified image to display

        // Adding the label with the GIF to the frame
        frame.add(label, BorderLayout.CENTER);

        // Centering the frame on the screen
        frame.pack(); // Adjusts the frame size to fit the GIF
        frame.setLocationRelativeTo(null); // // Sets the location of the window relative to the specified component.

        // Making the frame visible
        frame.setVisible(true);

        // timer to close the window after 5 seconds
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                frame.dispose();
            }
        }, 5000);
    }

}
