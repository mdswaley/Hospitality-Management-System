package org.example.Practice;

public class pr3 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("load");
        }catch (ClassNotFoundException e){
            System.out.println(e);
        }
    }
}
