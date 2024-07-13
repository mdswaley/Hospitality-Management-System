package org.example.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.util.Objects;

public class SwingAdvanceComponents {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Task Manager");

        String[] colname = {"Task","Category","Priority","Completion"};
        Object[][] data = {
                {"Task1", "Work", "High", 30},
                {"Task2", "Personal", "Medium", 60},
                {"Task3", "Work", "Low", 70}
        };

        JTable taskTable = new JTable(new DefaultTableModel(data,colname));
        JScrollPane tableSclPane = new JScrollPane(taskTable);

//        JTree -> root,branches
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Category");
        DefaultMutableTreeNode work = new DefaultMutableTreeNode("Work");
        DefaultMutableTreeNode personal = new DefaultMutableTreeNode("Personal");

        root.add(work);
        root.add(personal);

        JTree jTree = new JTree(root);
        JScrollPane treeSclPane = new JScrollPane(jTree);


//        list
        String[] str = {"High","Medium","Low"};
        JList<String> lst = new JList<>(str);
        JScrollPane lstSclPane = new JScrollPane(lst);


//        TabbedPane
        JTabbedPane jt = new JTabbedPane();
        jt.addTab("All Task",tableSclPane);
        jt.addTab("Category's",treeSclPane);
        jt.addTab("Priority's",lstSclPane);

//        Progress bar
        JProgressBar jpb = new JProgressBar();
        jpb.setStringPainted(true);


//        JSlider
        JSlider js = new JSlider(JSlider.HORIZONTAL,0,100,50);
        js.setMajorTickSpacing(20);
        js.setMinorTickSpacing(5);
        js.setPaintTicks(true);
        js.setPaintLabels(true);


//        Spinner
        SpinnerModel spinnerModel = new SpinnerNumberModel(3,1,6,5);
        JSpinner tasksp = new JSpinner(spinnerModel);


//        layout
        frame.setLayout(new BorderLayout());
        frame.add(jt,BorderLayout.CENTER);

        frame.add(createprioritypanel(js), BorderLayout.SOUTH);
        frame.add(createprogresspanel(jpb), BorderLayout.NORTH);
        frame.add(createspineerspanel(tasksp), BorderLayout. EAST);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setSize (800, 600);
        frame.setVisible(true);

    }
    private static JPanel createprioritypanel(JSlider slider){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("Task Priority "));
        panel.add(slider);
        return panel;
    }

    private static JPanel createprogresspanel(JProgressBar slider){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("Task completion"));
        panel.add(slider);
        return panel;
    }
    private static JPanel createspineerspanel(JSpinner slider){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("Number of task"));
        panel.add(slider);
        return panel;
    }


}
