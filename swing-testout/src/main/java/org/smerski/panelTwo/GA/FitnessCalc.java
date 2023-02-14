package org.smerski.panelTwo.GA;

public class FitnessCalc {
    // points for x = { 0, 1, 2, 5, 10}
    private static Gene[] solution;

    private static int[] xs;

    public static void setSolution(Gene[] newSolution) {
        solution = newSolution;
    }

    public static void setXs(int[] newXs){
        xs = newXs;
    }

    public static double getFitness(Chromosome chromosome) {
        double fitness = 1000;
        double[] ys = new double[5];

        for (int i = 0; i < xs.length; i++){
            ys[i] = polynomial(chromosome, xs[i]);
        }

        for (int i = 0; i < ys.length; i++){
            double cals = Math.abs(ys[i] - solution[i].getG());
            fitness -= cals;

        }

//        for (int geneIndex = 0; geneIndex < chromosome.size(); geneIndex++) {
//            double cals = chromosome.getGene(geneIndex).fitnessCal(solution[geneIndex]);
//            fitness -= cals;
//        }

        fitness /= 1000;

        return fitness;
    }

    public static double polynomial(Chromosome chromosome, int x){
        double temp = 0.0;
        double chromSize = chromosome.size();
        for (Gene g : chromosome.getGenes()){
            if (chromSize != 0){
                temp += g.getG() * Math.pow(x, chromSize);
                chromSize -= 1;
            }else{
                temp += g.getG();
            }
        }
        return temp;
    }

}
