package org.example.HospitalityManagementSystem.GUI;

import org.example.HospitalityManagementSystem.ClassEntity.Hotel;
import org.example.HospitalityManagementSystem.Implements.HotelDaoImp;
import org.example.HospitalityManagementSystem.InterfaceDao.HotelDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelManagementGUI extends JFrame {
    public HotelManagementGUI() {
        setTitle("ADD Hotel");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        HotelDao hotelDao = new HotelDaoImp();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        panel.add(new JLabel("Hotel Name:"));
        JTextField nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Location:"));
        JTextField locationField = new JTextField();
        panel.add(locationField);

        panel.add(new JLabel("Amenities:"));
        JTextField amenitiesField = new JTextField();
        panel.add(amenitiesField);

        panel.add(new JLabel("if want to delete pass id:"));
        JTextField delete = new JTextField();
        panel.add(delete);

        JButton addButton = new JButton("Add Hotel");
        JButton deleteButton = new JButton("Delete Hotel");

        panel.add(addButton);
        panel.add(deleteButton);

        add(panel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String location = locationField.getText();
                String amenities = amenitiesField.getText();

                Hotel hotel = new Hotel(0, name, location, amenities);
                hotelDao.addHotel(hotel);

                JOptionPane.showMessageDialog(null, "Hotel added successfully.");
                dispose();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(delete.getText());
                hotelDao.deleteHotel(id);

                JOptionPane.showMessageDialog(null, "Hotel deleted successfully.");
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HotelManagementGUI().setVisible(true);
            }
        });
    }

}
