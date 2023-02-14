package org.smerski.panelTwo.GA;

public class GA {

        public static void main(String[] args) {
            // chromosome is float array of values for function
            int populationSize = 100;
            int chromosomeLength = 3;
            int numberOfGenerations = 20000;
            double mutationRate = 0.0;
            double crossoverRate = 0.75;

            Gene[] solution = new Gene[5];

            int[] xs = new int[]{0, 1, 2, 5, 10};
            double[] ys = new double[]{0, 3, 6, 15, 30};

            for (int i = 0; i < ys.length; i++){
                solution[i] = new Gene(ys[i]);
            }


            Population population = new Population(populationSize, chromosomeLength);
            population.initializePopulation();

            FitnessCalc.setSolution(solution);
            FitnessCalc.setXs(xs);


            for (int i = 0; i < numberOfGenerations; i++) {
                population = Algorithm.evolvePopulation(population, mutationRate, crossoverRate);
            }

            System.out.println("Solution found in generation " + numberOfGenerations);
            System.out.println("Fitness: " + population.getFittest(0).getFitness());
            System.out.println("Genes:");
            population.getFittest(0).printChromosome();
            System.out.println("Solution: ");
            for (Gene gene : solution) {
                System.out.print(gene + " ");
            }
            System.out.println();
            for (int x : xs){
                System.out.println(FitnessCalc.polynomial(population.getFittest(0), x));
            }

        }
}
