package org.example.GUI;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AWTLayoutApplication {
    public static void main(String[] args) {
        Frame frame = new Frame("Layout Application");
        frame.setSize(300,300);
        frame.setVisible(true);

//        create a  flow layout
        FlowLayout flowLayout = new FlowLayout();
//        flowLay(flowLayout,frame);





//        creating border layout
        BorderLayout borderLayout = new BorderLayout();
//        borderLay(borderLayout,frame);




//        creating Grid layout
        GridLayout gridLayout = new GridLayout(2,2);
        gridLay(gridLayout,frame);








//        close frame
        closeFrame(frame);




    }

    public static void closeFrame(Frame frame){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });
    }
    public static void flowLay(FlowLayout flowLayout,Frame frame){
        //create panel belong to flowlayout
        Panel panel = new Panel(flowLayout);

        panel.add(new Button("button1"));
        panel.add(new Button("button2"));
        panel.add(new Button("button3"));
        panel.add(new Button("button4"));
        panel.add(new Button("button5"));
        panel.add(new Button("button6"));

        frame.add(panel);
    }
    public static void borderLay(BorderLayout borderLayout,Frame frame){
        frame.setLayout(borderLayout);
        Button button6 = new Button("button 6");
        Button button7 = new Button("button 7");
        Button button8 = new Button("button 8");
        Button button9 = new Button("button 9");

        frame.add(button6,borderLayout.NORTH);
        frame.add(button7,borderLayout.SOUTH);
        frame.add(button8,borderLayout.CENTER);
        frame.add(button9,borderLayout.WEST);

    }

    public static void gridLay(GridLayout gridLayout,Frame frame){
        Panel panel = new Panel(gridLayout);
        panel.add(new Button("btn 1"));
        panel.add(new Button("btn 2"));
        panel.add(new Button("btn 3"));
        panel.add(new Button("btn 4"));

        frame.add(panel);
    }
}
