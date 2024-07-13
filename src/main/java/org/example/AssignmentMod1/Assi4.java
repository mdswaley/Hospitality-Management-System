package org.example.AssignmentMod1;

public class Assi4 {
    public static void main(String[] args) {
        int weeks = 7;
        double[] temp = {30.4 ,23.6 ,96.22 ,89.9 ,36.8,41.2,43.6};
        double avg;
        double sum = 0;

        double highTemp = Double.MIN_VALUE;
        double lowTemp = Double.MAX_VALUE;

        int day80 = 0;
        int day60 = 0;

        for (int i = 0; i < temp.length; i++) {
            sum += temp[i];

            if (temp[i]>highTemp){
                highTemp = temp[i];
            }

            if (temp[i]<lowTemp){
                lowTemp = temp[i];
            }
            if (temp[i]>80){
                day80++;
            }

            if (temp[i]<60){
                day60++;
            }

        }
        avg = sum/weeks;


        System.out.println("Average Daily Temperature: " + avg);
        System.out.println("The highest daily temperature : "+highTemp);
        System.out.println("The lowest daily temperature : "+lowTemp);
        System.out.println("The number of days with temperatures above 80 degrees Fahrenheit : "+day80);
        System.out.println("The number of days with temperatures below 60 degrees Fahrenheit : "+day60);




    }
}
