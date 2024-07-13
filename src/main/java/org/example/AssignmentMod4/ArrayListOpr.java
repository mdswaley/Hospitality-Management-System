package org.example.AssignmentMod4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListOpr {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println("Initial ArrayList: " + list);

        list.add(6);
        System.out.println("After adding 6: " + list);

        list.add(2, 10);
        System.out.println("After inserting 10 at index 2: " + list);

        list.remove(3);
        System.out.println("After removing the value at index 3: " + list);
    }
}
