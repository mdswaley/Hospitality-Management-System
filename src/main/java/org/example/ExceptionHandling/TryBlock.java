package org.example.ExceptionHandling;

import java.util.Scanner;

public class TryBlock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nt = sc.nextInt();
        int dn = sc.nextInt();



        try {
            int res = nt/dn;
            System.out.println(res);
//            Unchecked exception
        }catch (ArithmeticException e){
            System.out.println("Error ; Division by zero not possible.");
        }finally{
            sc.close();
            System.out.println("Finally block executed"); //it is always execute whether exception occurred or not

        }
    }
}
