package org.example.AssignmentMod4;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetOpr {
    public static void main(String[] args) {
        HashSet<String> fruits = new HashSet<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("cherry");
        fruits.add("date");
        fruits.add("fig");
        System.out.println("Initial HashSet: " + fruits);


        fruits.add("banana");
        System.out.println("After adding 'banana' again: " + fruits);

        System.out.println("Size of HashSet: " + fruits.size());


        System.out.println("Elements of HashSet:");
        for (String s:fruits) {
            System.out.print(s+" ");
        }
    }
}
