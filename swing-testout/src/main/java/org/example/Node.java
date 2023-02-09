package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;


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

        this.x = 10 + (int)(Math.random() * 990);
        this.y = 10 + (int)(Math.random() * 790);

    }

    public Node(char character, int x, int y, int dim){
        this.character = character;
        this.x = x;
        this.y = y;
        this.dim = dim;
    }
}
