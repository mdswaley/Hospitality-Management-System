package org.example.HospitalityManagementSystem.Implements;

import org.example.HospitalityManagementSystem.ClassEntity.Guest;
import org.example.HospitalityManagementSystem.ClassEntity.Room;
import org.example.HospitalityManagementSystem.InterfaceDao.GuestDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuestDaoImp implements GuestDao {
    @Override
    public void addGuest(Guest guest) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitality_management","root","2003");
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO Guests(name,email,phone_number) VALUES (?, ?, ?)");
            pstmt.setString(1,guest.getName());
            pstmt.setString(2,guest.getEmail());
            pstmt.setString(3,guest.getPhoneNumber());

            pstmt.executeUpdate();

        }catch (Exception e){
            System.out.println(e);
        }

    }

    @Override
    public Guest getGuest(int guestId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitality_management","root","2003");
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Guests WHERE guest_id = ?");
            pstmt.setInt(1,guestId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                return new Guest(
                        rs.getInt("guest_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone_number")
                );
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Guest> getAllGuests() {
        List<Guest> guest = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitality_management","root","2003");
            Statement smt = con.createStatement();
            ResultSet rs = smt.executeQuery("SELECT * FROM Guests");

            while (rs.next()){
                guest.add(new Guest(
                        rs.getInt("guest_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone_number")
                ));
            }


        }catch (Exception e){
            System.out.println(e);
        }

        return guest;
    }

    @Override
    public void updateGuest(Guest guest) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitality_management","root","2003");
            PreparedStatement pstmt = con.prepareStatement("UPDATE Guests SET name = ?, email = ?, phone_number = ? WHERE guest_id = ?");

            pstmt.setInt(1, guest.getId());
            pstmt.setString(2,guest.getName());
            pstmt.setString(3, guest.getEmail());
            pstmt.setString(4, guest.getPhoneNumber());

            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteGuest(int guestId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitality_management","root","2003");
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM Guests WHERE guest_id = ?");
            pstmt.setInt(1, guestId);
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
