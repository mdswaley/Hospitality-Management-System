package org.example.Java8Ftr;

import java.time.LocalDate;
import java.time.LocalTime;

public class DateAndTime {
    public static void main(String[] args) {
        LocalDate ld = LocalDate.now();

        System.out.println("current date:-"+ld);

        LocalTime lt = LocalTime.now();

        System.out.println("current time:-"+lt);
    }
}
