package org.smerski.panelOne;

import lombok.Getter;
import lombok.Setter;

public class Node {

    @Getter @Setter
    private char character;
    @Setter @Getter
    private int x;
    @Getter @Setter
    private int y;
    @Getter @Setter
    private int dim;


    public Node(){}

    public Node(char character, int dim){
        this.character = character;
        this.dim = dim;

        this.x = 10 + (int)(Math.random() * 900);
        this.y = 10 + (int)(Math.random() * 700);

    }

    public Node(char character, int x, int y, int dim){
        this.character = character;
        this.x = x;
        this.y = y;
        this.dim = dim;
    }
}
