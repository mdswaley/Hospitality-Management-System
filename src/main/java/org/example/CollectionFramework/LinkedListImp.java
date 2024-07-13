package org.example.CollectionFramework;

import java.util.LinkedList;

public class LinkedListImp {
    public static void main(String[] args) {
        LinkedList<Gadget> gd = new LinkedList<>();


        gd.add(new Gadget("SmartPhone",35000));
        gd.add(new Gadget("Laptop",75000));
        gd.add(new Gadget("HeadPhone",10000));

        for (Gadget g: gd) {
            System.out.println(g);
        }

        Gadget lapInd = gd.get(1);
        System.out.println("Laptop details: "+lapInd);

//        means remove head data.
        System.out.println("Remove first ");
        gd.removeFirst();

        for (Gadget g: gd) {
            System.out.println(g);
        }

        gd.removeLast();
        System.out.println("Remove Last ");
        for (Gadget g: gd) {
            System.out.println(g);
        }

    }
}
