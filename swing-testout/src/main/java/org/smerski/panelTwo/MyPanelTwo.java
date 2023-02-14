package org.smerski.panelTwo;

import javax.swing.*;
import java.awt.*;

public class MyPanelTwo extends JPanel {

    public MyPanelTwo(){

    }

    private int function(int x){
        return x;
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.BLACK);
        g2d.drawLine(0, 600, 1000, 600);

        g2d.setColor(Color.RED);
        for(int i = 0; i < 1000; i++){
            g2d.drawLine(i, 600 - function(i), i + 1, 600 - function(i + 1));
        }


    }
}
