package org.example.HospitalityManagementSystem.InterfaceDao;

import org.example.HospitalityManagementSystem.ClassEntity.Reservation;

import java.util.List;

public interface ReservationDao {
    void addReservation(Reservation reservation);
    Reservation getReservation(int reservationId);
    List<Reservation> getAllReservations();
    void updateReservation(Reservation reservation);
    void deleteReservation(int reservationId);
    List<Reservation> getReservationsByRoom(int roomId);
}
