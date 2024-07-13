package org.example.Java8Ftr;

import java.util.Arrays;
import java.util.List;

public class StreamApiEx {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(10,22,13,30,55);

        int sum = arr.stream().filter(n->n%2 == 0).mapToInt(Integer :: intValue).sum();
//    arr.stream() :- sequence wise number like 1st 10 then 22 etc.
//    filter(n->n%2 == 0) :- filter from stream only even value.
//    mapToInt(Integer :: intValue):-array list is integer type, so it convert to int type.
//    sum():- it is inbuilt method which sum of even number only.

        System.out.println("Sum of Even number : "+sum);

        List<String> str = Arrays.asList("ABC","CAB","BCA");
        String res = str.stream().reduce("",(a,b)->a+b.charAt(1));
        /*
        First Iteration:
          a = "" (initial value)
          b = "ABC"
          b.charAt(1) = 'B'
          a + b.charAt(1) = "" + 'B' = "B"
          a is now "B"
        Second Iteration:
          a = "B"
          b = "CAB"
          b.charAt(1) = 'A'
          a + b.charAt(1) = "B" + 'A' = "BA"
          a is now "BA"
        Third Iteration:
          a = "BA"
          b = "BCA"
          b.charAt(1) = 'C'
          a + b.charAt(1) = "BA" + 'C' = "BAC"
          a is now "BAC"
        Result:

            After all iterations, a becomes "BAC".
            So, res will be "BAC".*/
        System.out.println(res);

    }
}
