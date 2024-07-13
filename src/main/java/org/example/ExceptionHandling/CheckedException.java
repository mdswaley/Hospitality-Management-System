package org.example.ExceptionHandling;

public class CheckedException {
    public static void main(String[] args) {
        try{
//            Class c = Class.forName("org.example.ExceptionHandling.CheckedException");
            Class c = Class.forName("class2");
            System.out.println("jfwiebg");
        }catch (ClassNotFoundException e){
            System.out.println("Class does not exist pls check the class name.");
        }
    }
}
