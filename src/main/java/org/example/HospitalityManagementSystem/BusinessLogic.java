package org.example.HospitalityManagementSystem;

import org.example.HospitalityManagementSystem.ClassEntity.Reservation;
import org.example.HospitalityManagementSystem.ClassEntity.Room;
import org.example.HospitalityManagementSystem.Implements.ReservationDaoImp;
import org.example.HospitalityManagementSystem.Implements.RoomDaoImp;
import org.example.HospitalityManagementSystem.InterfaceDao.ReservationDao;
import org.example.HospitalityManagementSystem.InterfaceDao.RoomDao;

import java.sql.Date;
import java.util.List;

public class BusinessLogic {
    private RoomDao roomDAO = new RoomDaoImp();
    private ReservationDao reservationDAO = new ReservationDaoImp();

    public boolean isRoomAvailable(int roomId, Date checkIn, Date checkOut) {
        List<Reservation> reservations = reservationDAO.getReservationsByRoom(roomId);
        for (Reservation reservation : reservations) {
            if (checkIn.before(reservation.getCheckOutDate()) && checkOut.after(reservation.getCheckInDate())) {
                return false;
            }
        }
        return true;
    }

    public double calculateReservationCost(int roomId, Date checkIn, Date checkOut) {
        Room room = roomDAO.getRoom(roomId);
        long diffInMillies = Math.abs(checkOut.getTime() - checkIn.getTime());
        long diff = diffInMillies / (1000 * 60 * 60 * 24);
        return diff * room.getPrice();
    }
}
