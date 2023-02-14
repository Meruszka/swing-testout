package org.smerski;

import org.smerski.panelTwo.MyPanelTwo;

import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame(){
        super("Rysowanie Grafów");

//        JPanel panel = new MyPanelOne();
        JPanel panel = new MyPanelTwo();
        add(panel);

        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
        setLocation(50, 50);
        setVisible(true);
    }
}
