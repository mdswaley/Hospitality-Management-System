package org.example.HospitalityManagementSystem.GUI;

import org.example.HospitalityManagementSystem.ClassEntity.Guest;
import org.example.HospitalityManagementSystem.Implements.GuestDaoImp;
import org.example.HospitalityManagementSystem.InterfaceDao.GuestDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuestManagementGUI extends JFrame {
    public GuestManagementGUI(){
        setTitle("ADD Guest");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        GuestDao guestDao = new GuestDaoImp();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        panel.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Email:"));
        JTextField emailField = new JTextField();
        panel.add(emailField);

        panel.add(new JLabel("Phone Number:"));
        JTextField phoneNumberField = new JTextField();
        panel.add(phoneNumberField);

        panel.add(new JLabel("if want to delete pass id:"));
        JTextField delete = new JTextField();
        panel.add(delete);

        JButton addButton = new JButton("Add Guest");
        JButton deletebtn = new JButton("Delete Guest");

        panel.add(deletebtn);
        panel.add(addButton);

        add(panel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String phoneNumber = phoneNumberField.getText();

                Guest guest = new Guest(0, name, email, phoneNumber);
                guestDao.addGuest(guest);

                JOptionPane.showMessageDialog(null, "Guest added successfully.");
                dispose();
            }
        });

        deletebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(delete.getText());
                guestDao.deleteGuest(id);


                JOptionPane.showMessageDialog(null, "Guest delete successfully.");
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GuestManagementGUI().setVisible(true);
            }
        });
    }
}
