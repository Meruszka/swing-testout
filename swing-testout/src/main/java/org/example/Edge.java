package org.example;

import lombok.Getter;
import lombok.Setter;

public class Edge {

    @Getter @Setter
    private Node node1;
    @Getter @Setter
    private Node node2;
    @Getter @Setter
    private int weight;

    public Edge(Node node1, Node node2, int weight){
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

}
