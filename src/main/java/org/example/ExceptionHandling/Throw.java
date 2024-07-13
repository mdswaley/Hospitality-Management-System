package org.example.ExceptionHandling;

public class Throw {
    public static void main(String[] args) {
        try{
            int age = -4;
            validate(age);
            System.out.println("age is valid");

        }catch (IllegalArgumentException e){
            System.out.println("IllegalArgumentException is caught : "+e.getMessage());
        }
    }
    public static void validate(int age) throws IllegalArgumentException{
        if (age < 0){
            throw new IllegalArgumentException("age can't be -ve.");
        }
//        if +ve do nothing

    }
}
