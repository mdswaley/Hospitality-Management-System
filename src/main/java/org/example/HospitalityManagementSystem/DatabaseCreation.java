package org.example.HospitalityManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseCreation {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitality_management","root","2003");
            Statement smt = con.createStatement();

//            create hotels table
            smt.executeUpdate("create table if not exists " +
                    "Hotels(ht_id int AUTO_INCREMENT primary key,name varchar(30)," +
                    "location varchar(80),amenities text)");


//            create room belongs to hotel id
            smt.executeUpdate("create table if not exists Rooms(rm_id int AUTO_INCREMENT primary key," +
                    "hotel_id int,rm_num varchar(50),rm_type varchar(30),price int,status varchar(20)," +
                    "foreign key (hotel_id) references Hotels(ht_id))");


//             Create Guests table
            smt.executeUpdate("CREATE TABLE IF NOT EXISTS Guests (guest_id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(100) NOT NULL," +
                    "email VARCHAR(100) NOT NULL," +
                    "phone_number VARCHAR(15) NOT NULL)");


//            create Reservations table
            smt.executeUpdate("CREATE TABLE IF NOT EXISTS Reservations (reservation_id INT AUTO_INCREMENT PRIMARY KEY," +
                    "guest_id INT,room_id INT," +
                    "check_in_date DATE NOT NULL," +
                    "check_out_date DATE NOT NULL," +
                    "FOREIGN KEY (guest_id) REFERENCES Guests(guest_id)," +
                    "FOREIGN KEY (room_id) REFERENCES Rooms(rm_id))");


            System.out.println("Tables created successfully!");

            con.close();



        }catch (Exception e){
            System.out.println(e);
        }

    }
}
