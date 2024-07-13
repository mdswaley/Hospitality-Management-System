package org.example.HospitalityManagementSystem.Implements;

import org.example.HospitalityManagementSystem.ClassEntity.Hotel;
import org.example.HospitalityManagementSystem.InterfaceDao.HotelDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDaoImp implements HotelDao {
    @Override
    public void addHotel(Hotel hotel) {
       try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitality_management","root","2003");
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO hotels(name, location, amenities) VALUES (?, ?, ?)");

            pstmt.setString(1, hotel.getName());
            pstmt.setString(2, hotel.getLocation());
            pstmt.setString(3, hotel.getAmenities());
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);;
        }
    }

    @Override
    public Hotel getHotel(int hotelId) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitality_management","root","2003");
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Hotels WHERE ht_id = ?");

            pstmt.setInt(1, hotelId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Hotel(
                        rs.getInt("ht_id"),
                        rs.getString("name"),
                        rs.getString("location"),
                        rs.getString("amenities")
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitality_management","root","2003");
            Statement smt = con.createStatement();
            ResultSet rs = smt.executeQuery("SELECT * FROM Hotels");
            while (rs.next()) {
                hotels.add(new Hotel(
                        rs.getInt("ht_id"),
                        rs.getString("name"),
                        rs.getString("location"),
                        rs.getString("amenities")
                ));
            }

        }catch (Exception e){
            System.out.println(e);
        }
        return hotels;
    }

    @Override
    public void updateHotel(Hotel hotel) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitality_management","root","2003");
            PreparedStatement pstmt = con.prepareStatement("UPDATE Hotels SET name = ?, location = ?, amenities = ? WHERE ht_id = ?");
            pstmt.setString(1, hotel.getName());
            pstmt.setString(2, hotel.getLocation());
            pstmt.setString(3, hotel.getAmenities());
            pstmt.setInt(4, hotel.getId());
            pstmt.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }

    }

    @Override
    public void deleteHotel(int hotelId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitality_management","root","2003");
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM Hotels WHERE ht_id = ?");
            pstmt.setInt(1, hotelId);
            pstmt.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
