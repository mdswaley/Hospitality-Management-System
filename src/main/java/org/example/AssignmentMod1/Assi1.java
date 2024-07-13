package org.example.AssignmentMod1;

public class Assi1 {
    public static void main(String[] args) {
        double itemPrice = 10.00;
        int numberOfItems = 5;
        double taxRate = 8.0;
        double discountPercentage = 10.0;


        double subtotal = itemPrice * numberOfItems;


        double taxAmount = (subtotal * taxRate) / 100;


        double discountAmount = (subtotal * discountPercentage) / 100;


        double totalCost = subtotal + taxAmount - discountAmount;


        System.out.println("Subtotal: " + subtotal);
        System.out.println("Tax Amount: $" + taxAmount);
        System.out.println("Discount Amount: $" + discountAmount);
        System.out.println("Total Cost: $" + totalCost);
    }
}
