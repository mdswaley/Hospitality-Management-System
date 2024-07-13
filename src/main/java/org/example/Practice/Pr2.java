package org.example.Practice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pr2 implements my {
    public static void main(String[] args) {
//        Set<String> set = new HashSet<>();
//
//        set.add("A");
//        set.add("B");
//        set.add("C");
//        set.add("A");
//
//        set.forEach(color -> System.out.println(" "+color));

//        Runnable rn = ()-> System.out.println("hello ");
//
//        Thread t1 = new Thread(rn);
//        t1.start();

//        try{
//            throw new test;
//        }catch (test t){
//            System.out.println("jerkg");
//        }finally {
//            System.out.println("rkmngl");
//        }

        my n = new Pr2();
        n.dis();

//        Thread t = Thread.currentThread();
//        System.out.println(t);

//        Stream<String> rr= Stream.of("a","b","c");
//        Optional<String> res = rr.filter(s->s.equals("d")).findFirst();
//
//        System.out.println(res);

//        Stream<Integer> st = Stream.of(1,2,3,4);
//        List<Integer> res = st.map(i->i*2).collect(Collectors.toList());
//        System.out.println(res);


    }
}

class test extends Exception{}
interface my{
    default void dis(){
        System.out.println("hello ");
    }
}
