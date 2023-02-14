package org.smerski.panelTwo.GA;

public class Population {
    private final Chromosome[] chromosomes;

    public Population(int populationSize, int chromosomeLength) {
        this.chromosomes = new Chromosome[populationSize];

        for (int chromosomeIndex = 0; chromosomeIndex < populationSize; chromosomeIndex++) {
            this.chromosomes[chromosomeIndex] = new Chromosome(chromosomeLength);
        }
    }

    public Population(int populationSize) {
        this.chromosomes = new Chromosome[populationSize];
    }

    public Chromosome[] getChromosomes() {
        return chromosomes;
    }

    public Chromosome getChromosome(int index) {
        return this.chromosomes[index];
    }

    public Chromosome getFittest(int offset) {
        Chromosome fittest = this.chromosomes[0];

        for (int i = 1; i < this.chromosomes.length; i++) {
            if (fittest.getFitness() <= this.getChromosome(i).setFitness()) {
                fittest = this.getChromosome(i);
            }
        }

        return fittest;
    }

    public int size() {
        return this.chromosomes.length;
    }

    public void setChromosome(int offset, Chromosome chromosome) {
        this.chromosomes[offset] = chromosome;
    }

    public void initializePopulation() {
        for (Chromosome chromosome : this.chromosomes) {
            chromosome.generateIndividual();
        }
    }

    public void printPopulation() {
        for (int i = 0; i < this.chromosomes.length; i++) {
            System.out.print("Chromosome " + i + ": ");
            this.chromosomes[i].printChromosome();
        }
    }

}
