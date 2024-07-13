package org.example.Java8Ftr;
@FunctionalInterface
public interface FunctionalInterfaceEx {
    int operation(int a ,int b); //only one abstract method

//    but multiple default method
    default void display(){
        System.out.println("HELLO");
    }

}
