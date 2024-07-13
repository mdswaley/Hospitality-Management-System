package org.example.AssignmentMod4;

public class MyCalculator {
    public long power(int n, int p) throws Exception {

        if (n < 0 || p < 0) {
            throw new Exception("n or p should not be negative");
        }
        if (n == 0 && p == 0) {
            throw new Exception("n and p should not be zero");
        }

        return (long) Math.pow(n, p);
    }
    public static void main(String[] args) {

        MyCalculator calculator = new MyCalculator();
        try {
            System.out.println(calculator.power(3, 5));
            System.out.println(calculator.power(2, 3));
            System.out.println(calculator.power(0, 0));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(calculator.power(-1, 2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(calculator.power(2, -1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
