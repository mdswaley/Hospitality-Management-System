package org.example.JdbcDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbcConnection {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            //connection string -> mysql
            //database url uniform resource locator, db name, location
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemann","root","2003");
            Statement smt = con.createStatement();

            smt.executeUpdate("create table employee(eno int,ename varchar(30),esalary int)");
            System.out.println("Table created successfully");
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
