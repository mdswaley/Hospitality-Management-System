package org.example.GUI;

import javax.swing.*;

public class test {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Code to be executed on the EDT
            System.out.println("This runs on the Event Dispatch Thread");
        });

        System.out.println("This runs on the main thread");
    }
}
