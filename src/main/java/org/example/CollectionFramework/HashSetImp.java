package org.example.CollectionFramework;

import java.util.HashSet;

public class HashSetImp{
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();

        set.add("BMW");
        set.add("Suzuki");
        set.add("Mahindra");
        set.add("BMW");
        set.add("Kawasaki");

//        HashSet:-show only unique value(not show BMW two time)
//               :-Unordered list(no order of element)

        for (String s:set) {
            System.out.println(s);
        }

//        want to find particular element
//        contains():- boolean type return true if present else false.
        System.out.println(set.contains("Mahindra"));

//        remove
        set.remove("Kawasaki");
        System.out.println();
        System.out.println("After removing");

        for (String s:set) {
            System.out.println(s);
        }




    }
}
