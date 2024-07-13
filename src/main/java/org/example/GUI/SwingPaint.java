package org.example.GUI;

import javax.swing.*;
import java.awt.*;

public class SwingPaint {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            customLookAndFeel.setCustomLookAndFeel();

            JFrame frame = new JFrame("Custom Look");
            frame.setSize(400,400);

            customPaintComp cp = new customPaintComp();

            frame.add(cp);
            frame.setVisible(true);
        });
    }
}
class customPaintComp extends JPanel{
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
//        custom paint logic
        g.setColor(Color.ORANGE);
        g.fill3DRect(100,50,200,50,true);

        g.setColor(Color.WHITE);
        g.fill3DRect(100,100,200,50,true);

        g.setColor(Color.GREEN);
        g.fill3DRect(100,150,200,50,true);

    }
}
class customLookAndFeel{
    public static void setCustomLookAndFeel(){
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
