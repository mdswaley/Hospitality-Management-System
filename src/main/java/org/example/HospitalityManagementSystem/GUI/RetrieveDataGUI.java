package org.example.HospitalityManagementSystem.GUI;

import org.example.HospitalityManagementSystem.ClassEntity.Guest;
import org.example.HospitalityManagementSystem.ClassEntity.Hotel;
import org.example.HospitalityManagementSystem.ClassEntity.Reservation;
import org.example.HospitalityManagementSystem.ClassEntity.Room;
import org.example.HospitalityManagementSystem.Implements.GuestDaoImp;
import org.example.HospitalityManagementSystem.Implements.HotelDaoImp;
import org.example.HospitalityManagementSystem.Implements.ReservationDaoImp;
import org.example.HospitalityManagementSystem.Implements.RoomDaoImp;
import org.example.HospitalityManagementSystem.InterfaceDao.GuestDao;
import org.example.HospitalityManagementSystem.InterfaceDao.HotelDao;
import org.example.HospitalityManagementSystem.InterfaceDao.ReservationDao;
import org.example.HospitalityManagementSystem.InterfaceDao.RoomDao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class RetrieveDataGUI extends JFrame {
   public RetrieveDataGUI(){
       setTitle("Retrieve Data");
       setSize(800, 600);
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       setLocationRelativeTo(null);

       HotelDao hotelDao = new HotelDaoImp();
       RoomDao roomDao = new RoomDaoImp();
       GuestDao guestDao = new GuestDaoImp();
       ReservationDao reservationDao = new ReservationDaoImp();

       JPanel panel = new JPanel();
       panel.setLayout(new BorderLayout());

       JTabbedPane tabbedPane = new JTabbedPane();

       tabbedPane.addTab("Hotels", createHotelTablePanel(hotelDao));
       tabbedPane.addTab("Rooms", createRoomTablePanel(roomDao));
       tabbedPane.addTab("Guests", createGuestTablePanel(guestDao));
       tabbedPane.addTab("Reservations", createReservationTablePanel(reservationDao));

       panel.add(tabbedPane, BorderLayout.CENTER);

       add(panel);
    }
    private JPanel createHotelTablePanel(HotelDao hotelDao) {

        JPanel hotelPanel = new JPanel(new BorderLayout());
        String[] columnNames = {"ID", "Name", "Location", "Amenities","Delete"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);
        JButton del = new JButton("Delete");

        List<Hotel> hotels = hotelDao.getAllHotels();
        for (Hotel hotel : hotels) {
            Object[] row = {
                    hotel.getId(),
                    hotel.getName(),
                    hotel.getLocation(),
                    hotel.getAmenities(),
                    del
            };
            model.addRow(row);
        }
        hotelPanel.add(new JScrollPane(table), BorderLayout.CENTER);
        return hotelPanel;
    }

    private JPanel createRoomTablePanel(RoomDao roomDao) {

        JPanel roomPanel = new JPanel(new BorderLayout());
        String[] columnNames = {"ID", "Hotel ID", "Room Number", "Type", "Price", "Status"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        JTable table = new JTable(model);
        List<Room> rooms = roomDao.getAllRooms();
        for (Room room : rooms) {
            Object[] row = {
                    room.getId(),
                    room.getHotelId(),
                    room.getRoomNumber(),
                    room.getType(),
                    room.getPrice(),
                    room.getStatus()
            };
            model.addRow(row);
        }
        roomPanel.add(new JScrollPane(table), BorderLayout.CENTER);
        return roomPanel;
    }

    private JPanel createGuestTablePanel(GuestDao guestDao) {

        JPanel guestPanel = new JPanel(new BorderLayout());
        String[] columnNames = {"ID", "Name", "Email", "Phone Number"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        JTable table = new JTable(model);
        List<Guest> guests = guestDao.getAllGuests();
        for (Guest guest : guests) {
            Object[] row = {
                    guest.getId(),
                    guest.getName(),
                    guest.getEmail(),
                    guest.getPhoneNumber()};
            model.addRow(row);
        }
        guestPanel.add(new JScrollPane(table), BorderLayout.CENTER);
        return guestPanel;
    }

    private JPanel createReservationTablePanel(ReservationDao reservationDao) {

        JPanel reservationPanel = new JPanel(new BorderLayout());
        String[] columnNames = {"ID", "Room ID", "Guest ID", "Check-In Date", "Check-Out Date"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        JTable table = new JTable(model);
        List<Reservation> reservations = reservationDao.getAllReservations();
        for (Reservation reservation : reservations) {
            Object[] row = {
                    reservation.getId(),
                    reservation.getRoomId(),
                    reservation.getGuestId(),
                    reservation.getCheckInDate(),
                    reservation.getCheckOutDate()
            };
            model.addRow(row);
        }
        reservationPanel.add(new JScrollPane(table), BorderLayout.CENTER);
        return reservationPanel;
    }
}
