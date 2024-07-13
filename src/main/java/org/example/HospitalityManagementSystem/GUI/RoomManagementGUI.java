package org.example.HospitalityManagementSystem.GUI;

import org.example.HospitalityManagementSystem.ClassEntity.Room;
import org.example.HospitalityManagementSystem.Implements.RoomDaoImp;
import org.example.HospitalityManagementSystem.InterfaceDao.RoomDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomManagementGUI extends JFrame{
    public RoomManagementGUI() {
        setTitle("ADD Room");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        RoomDao roomDao = new RoomDaoImp();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        panel.add(new JLabel("Hotel ID:"));
        JTextField hotelIdField = new JTextField();
        panel.add(hotelIdField);

        panel.add(new JLabel("Room Number:"));
        JTextField roomNumberField = new JTextField();
        panel.add(roomNumberField);

        panel.add(new JLabel("Type:"));
        JTextField typeField = new JTextField();
        panel.add(typeField);

        panel.add(new JLabel("Price:"));
        JTextField priceField = new JTextField();
        panel.add(priceField);

        panel.add(new JLabel("if want to delete pass id:"));
        JTextField delete = new JTextField();
        panel.add(delete);

        JButton addButton = new JButton("Add Room");
        JButton deletebtn = new JButton("Delete Room");
        panel.add(addButton);
        panel.add(deletebtn);

        add(panel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int hotelId = Integer.parseInt(hotelIdField.getText());
                String roomNumber = roomNumberField.getText();
                String type = typeField.getText();
                double price = Double.parseDouble(priceField.getText());

                Room room = new Room(0, hotelId, roomNumber, type, price, "Available");
                roomDao.addRoom(room);

                JOptionPane.showMessageDialog(null, "Room added successfully.");
                dispose();
            }
        });

        deletebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(delete.getText());

                roomDao.deleteRoom(id);
                JOptionPane.showMessageDialog(null, "Room delete successfully.");
                dispose();
            }
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RoomManagementGUI().setVisible(true);
            }
        });
    }
}
