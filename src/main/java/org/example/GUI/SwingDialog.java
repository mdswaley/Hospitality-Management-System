package org.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class SwingDialog {
    public static void main(String[] args) {
        /*SwingUtilities.invokeLater(): This method takes a Runnable object
        (which is usually provided as a lambda expression or an anonymous class)
        and schedules it to be executed on the EDT.*/


        /*Event Dispatch Thread (EDT): This is the thread responsible for handling
        all the events in a Swing application, such as user interactions
        (mouse clicks, key presses) and repainting the GUI. It's essential
        to execute GUI-related code on this thread to prevent concurrency issues.*/
        
        SwingUtilities.invokeLater(()->{
            JFrame frame = new JFrame("Show Message");
            frame.setSize(500,500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JButton file = new JButton("Show File Chooser Dialog");
            file.addActionListener(e -> showFileChooser(frame));



            JButton color = new JButton("Show Color Chooser Dialog");
            color.addActionListener(e -> showColorChooser(frame));


            JButton dialog = new JButton("Show Dialog");
            dialog.addActionListener(e -> showcustomdialog(frame));


            JPanel panel = new JPanel(new FlowLayout());
            panel.add(file);
            panel.add(color);
            panel.add(dialog);


            frame.add(panel);
            frame.setVisible(true);

        });
    }
    private static void showFileChooser(JFrame frame){
        JFileChooser file = new JFileChooser();
        int result = file.showOpenDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION){
            File selecterFile = file.getSelectedFile();
            JOptionPane.showMessageDialog(frame,"Selected file: "+selecterFile.getAbsolutePath(),"File: ",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(frame,"file selection cancel.","File: ",JOptionPane.INFORMATION_MESSAGE);

        }
    }
    private static void showColorChooser(JFrame frame){
        Color selectedcol = JColorChooser.showDialog(frame,"Choose a color : ",Color.RED);
        if (selectedcol != null){
            JOptionPane.showMessageDialog(frame,"selected color : "+selectedcol,"Color Choose",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(frame,"selected color cancel.","Color Choose",JOptionPane.WARNING_MESSAGE);
        }


    }
    private static void showcustomdialog (JFrame frame) {
        JDialog customdialog = new JDialog (frame, "Custom Dialog", true);
        customdialog.setSize(300,200);

        JLabel label = new JLabel ("This ia a custom dialog");
        JButton closebtn = new JButton("Close");

        closebtn.addActionListener (e -> customdialog.dispose());
        customdialog.setLayout(new BorderLayout());

        customdialog.add(label, BorderLayout.CENTER);
        customdialog.add(closebtn, BorderLayout.SOUTH);

        customdialog.setVisible(true);
    }
}
