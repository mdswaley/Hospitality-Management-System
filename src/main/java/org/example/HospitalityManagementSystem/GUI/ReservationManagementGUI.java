package org.example.HospitalityManagementSystem.GUI;

import org.example.HospitalityManagementSystem.ClassEntity.Reservation;
import org.example.HospitalityManagementSystem.Implements.ReservationDaoImp;
import org.example.HospitalityManagementSystem.InterfaceDao.ReservationDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class ReservationManagementGUI extends JFrame {
    public ReservationManagementGUI(){
        setTitle("ADD Reservation");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        ReservationDao reservationDao = new ReservationDaoImp();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        panel.add(new JLabel("Room ID:"));
        JTextField roomIdField = new JTextField();
        panel.add(roomIdField);

        panel.add(new JLabel("Guest ID:"));
        JTextField guestIdField = new JTextField();
        panel.add(guestIdField);

        panel.add(new JLabel("Check-In Date (yyyy-mm-dd):"));
        JTextField checkInField = new JTextField();
        panel.add(checkInField);

        panel.add(new JLabel("Check-Out Date (yyyy-mm-dd):"));
        JTextField checkOutField = new JTextField();
        panel.add(checkOutField);

        JButton addButton = new JButton("Add Reservation");
        panel.add(addButton);

        add(panel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int roomId = Integer.parseInt(roomIdField.getText());
                int guestId = Integer.parseInt(guestIdField.getText());
                Date checkIn = Date.valueOf(checkInField.getText());
                Date checkOut = Date.valueOf(checkOutField.getText());

                Reservation reservation = new Reservation(0, roomId, guestId, checkIn, checkOut);
                reservationDao.addReservation(reservation);

                JOptionPane.showMessageDialog(null, "Reservation added successfully.");
                dispose();

            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ReservationManagementGUI().setVisible(true);
            }
        });
    }
}
