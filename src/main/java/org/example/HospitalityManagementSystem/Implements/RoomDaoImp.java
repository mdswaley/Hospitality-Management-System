package org.example.HospitalityManagementSystem.Implements;

import org.example.HospitalityManagementSystem.ClassEntity.Room;
import org.example.HospitalityManagementSystem.InterfaceDao.RoomDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDaoImp implements RoomDao {
    @Override
    public void addRoom(Room room) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitality_management","root","2003");
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO Rooms(hotel_id, rm_num, rm_type, price, status) VALUES (?, ?, ?, ?, ?)");

            pstmt.setInt(1, room.getHotelId());
            pstmt.setString(2, room.getRoomNumber());
            pstmt.setString(3, room.getType());
            pstmt.setDouble(4, room.getPrice());
            pstmt.setString(5, room.getStatus());
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);;
        }

    }

    @Override
    public Room getRoom(int roomId) {

        try  {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitality_management","root","2003");
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Rooms WHERE rm_id = ?");
            pstmt.setInt(1, roomId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Room(
                        rs.getInt("rm_id"),
                        rs.getInt("hotel_id"),
                        rs.getString("rm_num"),
                        rs.getString("rm_type"),
                        rs.getDouble("price"),
                        rs.getString("status")
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitality_management","root","2003");
            Statement smt = con.createStatement();
            ResultSet rs = smt.executeQuery("SELECT * FROM Rooms");
            while (rs.next()) {
                rooms.add(new Room(
                        rs.getInt("rm_id"),
                        rs.getInt("hotel_id"),
                        rs.getString("rm_num"),
                        rs.getString("rm_type"),
                        rs.getDouble("price"),
                        rs.getString("status")
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return rooms;
    }

    @Override
    public void updateRoom(Room room) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitality_management","root","2003");
            PreparedStatement pstmt = con.prepareStatement("UPDATE Rooms SET hotel_id = ?, rm_num = ?, rm_type = ?, price = ?, status = ? WHERE rm_id = ?");

            pstmt.setInt(1, room.getHotelId());
            pstmt.setString(2, room.getRoomNumber());
            pstmt.setString(3, room.getType());
            pstmt.setDouble(4, room.getPrice());
            pstmt.setString(5, room.getStatus());
            pstmt.setInt(6, room.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteRoom(int roomId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitality_management","root","2003");
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM Rooms WHERE rm_id = ?");
            pstmt.setInt(1, roomId);
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
