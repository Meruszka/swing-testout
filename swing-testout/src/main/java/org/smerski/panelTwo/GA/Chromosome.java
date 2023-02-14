package org.smerski.panelTwo.GA;

public class Chromosome {
    private final Gene[] genes;
    private double fitness = 0;

    public Chromosome(int chromosomeLength) {
        this.genes = new Gene[chromosomeLength];
    }

    public Chromosome(Gene[] genes) {
        this.genes = genes;
    }

    public Gene[] getGenes() {
        return this.genes;
    }

    public Gene getGene(int offset) {
        return this.genes[offset];
    }

    public void setGene(int offset, Gene gene) {
        this.genes[offset] = gene;
        this.fitness = 0;
    }

    public int size() {
        return this.genes.length;
    }

    public double setFitness() {
        if (this.fitness == 0) {
            this.fitness = FitnessCalc.getFitness(this);
        }

        return this.fitness;
    }

    public double getFitness() {
        return this.fitness;
    }


    public void generateIndividual() {
        for (int gene = 0; gene < this.size(); gene++) {
            this.setGene(gene, new Gene());
        }
    }

    public String toString() {
        StringBuilder geneString = new StringBuilder();
        for (int i = 0; i < this.size(); i++) {
            geneString.append(this.getGene(i));
            geneString.append(" ");
        }

        return geneString.toString();
    }

    public void printChromosome() {
        System.out.println(this);
    }
}
