package org.example.GUI;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AWTApplication {
    public static void main(String[] args) {

//        Frame is class which is like a main window for our application.
        Frame fm = new Frame("AWT Application");

        fm.setSize(400,400);
//        window listener - interface window event.
        fm.addWindowListener(new WindowAdapter() {
//            for close window
            @Override
            public void windowClosing(WindowEvent e){
                fm.dispose();
            }
        });
//        visible window or frame.
        fm.setVisible(true);

//        add label to frame
        Label label = new Label("Name: ");
        label.setBounds(50,50,50,20);
//        label.setSize(200,200);
        fm.add(label);


//        add text field
        TextField textField = new TextField();
        textField.setBounds(110,50,150,20);
        fm.add(textField);


//        add button
        Button btn = new Button("Submit");
        btn.setBounds(110,80,150,20);

//        add check box
        Checkbox ch = new Checkbox("Check condition");
        ch.setBounds(110,100,150,20);

//        check box group
        CheckboxGroup chk = new CheckboxGroup();
        Checkbox redio1 = new Checkbox("One",false,chk);
        Checkbox redio2 = new Checkbox("Two",false,chk);

        redio1.setBounds(20,120,70,20);
        redio2.setBounds(150,120,70,20);

        Scrollbar sb = new Scrollbar();
        sb.setBounds(30,160,150,20);

        fm.add(ch);
        fm.add(redio1);
        fm.add(redio2);
        fm.add(btn);
        fm.add(sb);

    }
}
