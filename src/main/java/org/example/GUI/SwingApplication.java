package org.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingApplication {
    public static void main(String[] args) {

     //  AWT and Swing are the two toolkits for building interactive Graphical User Interfaces (GUI)

        JFrame jFrame = new JFrame("Registration form");
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);



        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(8,2,5,5));

        JLabel name = new JLabel("Name: ");
        JLabel email = new JLabel("Email: ");
        JLabel password = new JLabel("Password: ");
        JLabel gender = new JLabel("Gender: ");
        JLabel interest = new JLabel("Interest: ");

        JTextField all = new JTextField();
        JTextField all2 = new JTextField();
        JTextField password2 = new JTextField();

//        JOptionPane jOptionPane = new JOptionPane();
//        jOptionPane.


        JRadioButton male = new JRadioButton("Male");
        JRadioButton female = new JRadioButton("Female");
        ButtonGroup genderGrp = new ButtonGroup();
        genderGrp.add(male);
        genderGrp.add(female);

        JCheckBox java = new JCheckBox("JAVA");
        JCheckBox c = new JCheckBox("C");
        JCheckBox python = new JCheckBox("Python");
        JCheckBox js = new JCheckBox("JavaScript");


        jPanel.add(name);
        jPanel.add(all);
        jPanel.add(email);
        jPanel.add(all2);
        jPanel.add(password);
        jPanel.add(password2);
        jPanel.add(gender);
        jPanel.add(male);
        jPanel.add(female);
        jPanel.add(interest);
        jPanel.add(java);
        jPanel.add(c);
        jPanel.add(python);
        jPanel.add(js);


        JButton jButton = new JButton("Submit");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = all.getText();
                String email = all2.getText();
                char[] pass = password2.getText().toCharArray();
                String gender = male.isSelected()?"Male":"Female";
                String interest = "";
                if (java.isSelected()){
                    interest += java.getText();
                }else if(python.isSelected()){
                    interest += python.getText();
                }else if(c.isSelected()){
                    interest += c.getText();
                }else{
                    interest += js.getText();
                }

                String message = "Name: "+name+"\nEmail: "+email+ "\nGender : " +gender +"\n Interests :" +interest;
                JOptionPane.showMessageDialog(jFrame,message,"Register successfully",JOptionPane.INFORMATION_MESSAGE);
            }
        });




        jPanel.add(jButton);



        jFrame.add(jPanel);

        jFrame.setSize(500,500);
        jFrame.setVisible(true);



    }
}
