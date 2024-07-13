package org.example.HospitalityManagementSystem.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hospitality Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,2));

        JButton hotel = new JButton("ADD Hotel");
        JButton room = new JButton("ADD Room");
        JButton guest = new JButton("ADD Guest");
        JButton reservation = new JButton("ADD Reservation");
        JButton data = new JButton("Retrieve Data");

        panel.add(hotel);
        panel.add(room);
        panel.add(guest);
        panel.add(reservation);
        panel.add(data);

        frame.add(panel);
        frame.setVisible(true);

        hotel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HotelManagementGUI hotelGUI = new HotelManagementGUI();
                hotelGUI.setVisible(true);
            }
        });

        room.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RoomManagementGUI roomManagementGUI = new RoomManagementGUI();
                roomManagementGUI.setVisible(true);
            }
        });

        guest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuestManagementGUI guestManagementGUI = new GuestManagementGUI();
                guestManagementGUI.setVisible(true);
            }
        });

        reservation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReservationManagementGUI reservationManagementGUI = new ReservationManagementGUI();
                reservationManagementGUI.setVisible(true);
            }
        });

        data.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RetrieveDataGUI retrieveDataGUI = new RetrieveDataGUI();
                retrieveDataGUI.setVisible(true);
            }
        });

    }
}