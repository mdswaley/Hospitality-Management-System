package org.example.JdbcDriver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbcDelete {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemann","root","2003");
            Statement smt = con.createStatement();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                System.out.println("Enter delete ENO: ");
                int eno = Integer.parseInt(br.readLine());

                int count = smt.executeUpdate("delete from employee where eno="+eno);

                if (count == 1){
                    System.out.println(count+" record is deleted");
                }else{
                    System.out.println("no record is deleted");
                }

//                mutiple record want to delete
                System.out.println("Do you want to delete more recode");
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
