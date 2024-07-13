package org.example.Practice;

public class Regex {
    public static void main(String[] args) {
        String s1 = "aa";
        String s2 = "a*";

        System.out.println(calReg(s1,s2));
    }
    public static boolean calReg(String s1,String s2){
        int n1 = s1.length();
        int n2 = s2.length();
        int i = 0;
        int j = 0;
        while(i<n1 && j<n2){
            if (s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }else if(s2.charAt(i)=='*'){
                return true;
            }

        }
        return false;
    }
}
