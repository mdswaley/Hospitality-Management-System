package org.example.JdbcDriver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class jdbcInsert {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemann","root","2003");
            PreparedStatement psmt = con.prepareStatement("insert into employee values (?,?,?)");

//            Scanner sc = new Scanner(System.in);

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while (true){
                System.out.print("Enter your ENO: ");
                int eno = Integer.parseInt(br.readLine());
                System.out.print("Enter your name: ");
                String name = br.readLine();
                System.out.print("Enter your Salary: ");
                int sl = Integer.parseInt(br.readLine());

//                put the value into table
                psmt.setInt(1,eno);
                psmt.setString(2,name);
                psmt.setInt(3,sl);

//                check how many record you update
                int count = psmt.executeUpdate();

                if (count > 0){
                    System.out.println(count+" record updated.");
                }else{
                    System.out.println("No record update.");
                }

                System.out.println("Do you want to insert more records: ");
                String ch = br.readLine();
                if (ch.equalsIgnoreCase("no")){
                    break;
                }
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
