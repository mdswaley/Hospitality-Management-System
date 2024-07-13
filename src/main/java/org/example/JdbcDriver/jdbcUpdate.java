package org.example.JdbcDriver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbcUpdate {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemann", "root", "2003");
            Statement smt = con.createStatement();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter eno whose data has to be updated: ");
            int eno = Integer.parseInt(br.readLine());
            System.out.println("Enter new salary: ");
            int sal = Integer.parseInt(br.readLine());

            int count = smt.executeUpdate("update employee set esalary=" + sal + " where eno=" + eno);
            if (count > 0) {
                System.out.println(count + " record are updated.");
            } else {
                System.out.println("no record updated.");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
