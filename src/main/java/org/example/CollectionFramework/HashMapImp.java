package org.example.CollectionFramework;

import java.util.HashMap;
import java.util.Map;

public class HashMapImp {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
//        it is a key and value pairs.
//        it is in any order
        map.put("MD",93);
        map.put("Swaley",90);
        map.put("Sahil",96);
        map.put("Sohel",77);
        map.put("Sania",80);

        System.out.println(map);
//      print
        for (String key : map.keySet()) {
            System.out.println(key);
        }

        for (Integer val : map.values()) {
            System.out.println(val);
        }

//        or

        for (Map.Entry<String,Integer> ent: map.entrySet()) {
            System.out.println(ent.getKey() +" : "+ent.getValue());
        }

//        to get particular value

        System.out.println("Swaley : "+map.get("Swaley"));

//        is key contain or not
        if (map.containsKey("Swaley")){
            System.out.println("True");
        }else{
            System.out.println("False");
        }

        map.remove("MD");
        System.out.println();
        System.out.println("After removing");
        for (Map.Entry<String,Integer> ent: map.entrySet()) {
            System.out.println(ent.getKey() +" : "+ent.getValue());
        }




    }
}
