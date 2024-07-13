package org.example.CollectionFramework;

import java.util.TreeSet;

public class TreeSetImp {
    public static void main(String[] args) {
        TreeSet<String> set = new TreeSet<>();

        set.add("BMW");
        set.add("Suzuki");
        set.add("Alto");
        set.add("Mahindra");
        set.add("BMW");
        set.add("Kawasaki");

//        TreeSet:-sorted order arrange.(ASC)

        for (String s: set) {
            System.out.println(s);
        }

        System.out.println(set.contains("BMW"));

        set.remove("Alto");
        System.out.println();
        System.out.println("After removing");

        for (String s: set) {
            System.out.println(s);
        }


    }
}
