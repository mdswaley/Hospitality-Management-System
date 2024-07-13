package org.example.Java8Ftr;

public class LambdaExp {
    public static void main(String[] args) {
        FunctionalInterfaceEx add = (a,b)->a + b; //lambda expresion
//        sort , quick and easy to understand.
        int res = add.operation(5,3);

        System.out.println(res);

    }
}
