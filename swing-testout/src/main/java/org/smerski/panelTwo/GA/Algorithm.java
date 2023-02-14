package org.smerski.panelTwo.GA;

public class Algorithm {

    public static Population evolvePopulation(Population population, double mutationRate, double crossoverRate) {
        Population newPopulation = new Population(population.size());

        for (int populationIndex = 0; populationIndex < population.size(); populationIndex++) {
            Chromosome chromosome1 = tournamentSelection(population, crossoverRate);
            Chromosome chromosome2 = tournamentSelection(population, crossoverRate);

            Chromosome newChromosome = crossover(chromosome1, chromosome2);

            newPopulation.setChromosome(populationIndex, newChromosome);
        }

        for (int populationIndex = 0; populationIndex < newPopulation.size(); populationIndex++) {
            mutate(newPopulation.getChromosome(populationIndex), mutationRate);
        }

        return newPopulation;
    }

    private static Chromosome crossover(Chromosome chromosome1, Chromosome chromosome2) {
        Chromosome newChromosome = new Chromosome(chromosome1.size());

        for (int geneIndex = 0; geneIndex < chromosome1.size(); geneIndex++) {
            if (Math.random() <= 0.5) {
                newChromosome.setGene(geneIndex, chromosome1.getGene(geneIndex));
            } else {
                newChromosome.setGene(geneIndex, chromosome2.getGene(geneIndex));
            }
        }

        return newChromosome;
    }

    private static void mutate(Chromosome chromosome, double mutationRate) {
        for (int geneIndex = 0; geneIndex < chromosome.size(); geneIndex++) {
            if (Math.random() <= mutationRate) {
                Gene gene = chromosome.getGene(geneIndex);
                gene.mutate();
            }
        }
    }

    private static Chromosome tournamentSelection(Population population, double crossoverRate) {
        Population tournament = new Population(5);
        for (int tournamentIndex = 0; tournamentIndex < 5; tournamentIndex++) {
            int randomIndex = (int) (Math.random() * population.size());
            tournament.setChromosome(tournamentIndex, population.getChromosome(randomIndex));
        }

        return tournament.getFittest(0);
    }


}
