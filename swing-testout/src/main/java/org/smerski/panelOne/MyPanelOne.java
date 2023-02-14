package org.smerski.panelOne;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyPanelOne extends JPanel {

    private final int dim = 40;
    ArrayList<Node> nodeList = new ArrayList<>();
    ArrayList<Edge> edgeList = new ArrayList<>();
    String letters = "ABCDEFGHIJKLOPRSTUWXYZ";
    public MyPanelOne(){

        for(int i = 0; i < 5; i++){
            nodeList.add(new Node(letters.charAt(i), dim));
        }
        edgeList.add(new Edge(nodeList.get(0), nodeList.get(1), 1));
        edgeList.add(new Edge(nodeList.get(0), nodeList.get(2), 1));
        edgeList.add(new Edge(nodeList.get(0), nodeList.get(3), 1));

    }




    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for(Edge edge : edgeList){
            g2d.setColor(Color.BLACK);
            g2d.drawLine(edge.getNode1().getX() + 20, edge.getNode1().getY() + 20, edge.getNode2().getX() + 20, edge.getNode2().getY() + 20);
        }

        for(Node node : nodeList){
            g2d.setColor(Color.WHITE);
            g2d.fillOval(node.getX(), node.getY(), node.getDim(), node.getDim());
            g2d.setColor(Color.BLACK);
            g2d.drawOval(node.getX(), node.getY(), node.getDim(), node.getDim());
            g2d.drawString(String.valueOf(node.getCharacter()), node.getX() + 15, node.getY() + 25);
        }


    }
}
