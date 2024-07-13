package org.example.HospitalityManagementSystem.Implements;

import org.example.HospitalityManagementSystem.ClassEntity.Reservation;
import org.example.HospitalityManagementSystem.InterfaceDao.ReservationDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDaoImp implements ReservationDao {

    @Override
    public void addReservation(Reservation reservation) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitality_management","root","2003");
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO Reservations (guest_id, room_id, check_in_date, check_out_date) VALUES (?, ?, ?, ?)");

            pstmt.setInt(1, reservation.getGuestId());
            pstmt.setInt(2, reservation.getRoomId());
            pstmt.setDate(3, reservation.getCheckInDate());
            pstmt.setDate(4, reservation.getCheckOutDate());
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public Reservation getReservation(int reservationId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitality_management","root","2003");
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Reservations WHERE reservation_id = ?");

            pstmt.setInt(1, reservationId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Reservation(
                        rs.getInt("reservation_id"),
                        rs.getInt("guest_id"),
                        rs.getInt("room_id"),
                        rs.getDate("check_in_date"),
                        rs.getDate("check_out_date")
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<Reservation> getAllReservations() {

        List<Reservation> reservations = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitality_management","root","2003");
            Statement smt = con.createStatement();
            ResultSet rs = smt.executeQuery("SELECT * FROM Reservations");

            while (rs.next()) {
                reservations.add(new Reservation(
                        rs.getInt("reservation_id"),
                        rs.getInt("guest_id"),
                        rs.getInt("room_id"),
                        rs.getDate("check_in_date"),
                        rs.getDate("check_out_date")
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return reservations;
    }

    @Override
    public void updateReservation(Reservation reservation) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitality_management","root","2003");
            PreparedStatement pstmt = con.prepareStatement("UPDATE Reservations SET guest_id = ?, room_id = ?, check_in_date = ?, check_out_date = ? WHERE reservation_id = ?");

            pstmt.setInt(1, reservation.getGuestId());
            pstmt.setInt(2, reservation.getRoomId());
            pstmt.setDate(3, reservation.getCheckInDate());
            pstmt.setDate(4, reservation.getCheckOutDate());
            pstmt.setInt(5, reservation.getId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteReservation(int reservationId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitality_management","root","2003");
            PreparedStatement pstmt = con.prepareStatement("DELETE FROM Reservations WHERE reservation_id = ?");

            pstmt.setInt(1, reservationId);
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Reservation> getReservationsByRoom(int roomId) {
        List<Reservation> reservations = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitality_management","root","2003");
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Reservations WHERE room_id = ?");

            pstmt.setInt(1, roomId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                reservations.add(new Reservation(
                        rs.getInt("reservation_id"),
                        rs.getInt("guest_id"),
                        rs.getInt("room_id"),
                        rs.getDate("check_in_date"),
                        rs.getDate("check_out_date")
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return reservations;
    }
}
