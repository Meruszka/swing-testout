package org.smerski.panelTwo.GA;

public class Gene {
    private double g;

    public Gene(double g){
        this.g = g;
    }
    public Gene(){
        this.g = (Math.random() * 10) - 5; // double
        //this.g = (int) Math.round(Math.random() * 200); // int
    }
    public void mutate(){
        if(Math.random() >= 0.5) {
            this.g += 1;
        }else{
            this.g -= 1;
        }
    }

    public double fitnessCal(Gene second){
        return Math.abs(this.g - second.g);
    }

    @Override
    public String toString() {
        return String.valueOf(this.g);
    }

    public double getG(){
        return this.g;
    }
}
