package org.example.CollectionFramework;

import java.util.ArrayList;

public class ArrayListImp {
    public static void main(String[] args) {
        ArrayList<Gadget> gd = new ArrayList<>();

//        add list
        gd.add(new Gadget("SmartPhone",25000));
        gd.add(new Gadget("Laptop",65000));
        gd.add(new Gadget("HeadPhone",5000));

//        print list of gadget
        for (Gadget g: gd) {
            System.out.println(g);
        }

//        get index
        Gadget lapInd = gd.get(1);
        System.out.println("Laptop index: "+lapInd);

//        remove one list
        gd.remove(0);

        System.out.println(gd);
    }
}
