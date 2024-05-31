package com.ps.gui;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class WelcomeWindow {
    public void welcomeWindow() {
        // Create the frame
        JFrame frame = new JFrame("Order Confirmed.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new BorderLayout());

        // Load the GIF image
        ImageIcon gifIcon = new ImageIcon("thank you.gif");
        JLabel label = new JLabel(gifIcon);

        // Add the label with the GIF to the frame
        frame.add(label, BorderLayout.CENTER);

        // Center the frame on the screen
        frame.pack(); // Adjusts the frame size to fit the GIF
        frame.setLocationRelativeTo(null);

        // Make the frame visible
        frame.setVisible(true);

        // Create a timer to close the window after 3 seconds
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                frame.dispose();
            }
        }, 3000);
    }
}
