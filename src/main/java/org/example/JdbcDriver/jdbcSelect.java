package org.example.JdbcDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbcSelect {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemann", "root", "2003");
            Statement smt = con.createStatement();

            ResultSet rs = smt.executeQuery("SELECT * FROM employee");
//            rs.next():-it take boolean value give true until no row find.
            while (rs.next()){
                int eno = rs.getInt(1);
                String name = rs.getString(2);
                int sal = rs.getInt(3);

                System.out.print("Eno : "+eno);
                System.out.print(" Name : "+name);
                System.out.print(" Salary : "+sal);

                System.out.println();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
