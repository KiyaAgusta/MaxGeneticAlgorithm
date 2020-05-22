package maxgeneticalgorithm.controller;

import maxgeneticalgorithm.model.*;

public class MaxLogic {
    private static double crossoverRate;
    private static double mutationRate;
    
    public static Population evolvePopulation(Population pop, double crossoverRate, double mutationRate) {
        MaxLogic.crossoverRate = crossoverRate;
        MaxLogic.mutationRate = mutationRate;
        
        Population newPopulation = new Population(pop.populationSize(), false);
        
        for (int i = 0; i < newPopulation.populationSize(); i++) {
            // Select parents
            Individual parent1 = selection(pop);
            Individual parent2 = selection(pop);
            // Crossover parents
            Individual child = crossover(parent1, parent2);
            // Add child to new population
            newPopulation.saveIndividual(i, child);
        }

        for (int i = 1; i < newPopulation.populationSize(); i++)
            mutate(newPopulation.getIndividual(i));

        return newPopulation;
    }

    private static Individual selection(Population pop) {
        int flag = 0;
        double total = 0, random;
        Individual selectedIndividual;
        
        double[] selectionProb = new double[pop.populationSize() + 1];
        double[] randomPoints = new double[pop.populationSize()];
        Population newPopulation = new Population(pop.populationSize(), false);
        
        selectionProb[0] = 0;
        for (int i = 1; i < selectionProb.length; i++) {
            total += pop.getProbability(i - 1);
            selectionProb[i] = total;
        }
        
        for (int i = 0; i < pop.populationSize(); i++)
            randomPoints[i] = Math.random();
        
        for (int i = 0; i < pop.populationSize(); i++) {
            for (int j = 0; j < pop.populationSize(); j++) {
                if (selectionProb[i] < randomPoints[j] && randomPoints[j] < selectionProb[i + 1]) {
                    newPopulation.saveIndividual(flag, pop.getIndividual(i));
                    flag++;
                }
            }
        }
        
        selectedIndividual = newPopulation.getIndividual(0);
        for (int i = 0; i < pop.populationSize(); i++) {
            random = Math.random();
            if (random < crossoverRate)
                selectedIndividual = newPopulation.getIndividual(i);
        }
        
        return selectedIndividual;
    }
    
    public static Individual crossover(Individual parent1, Individual parent2) {
        Individual child = new Individual(false);

        int start = (int) (Math.random() * parent1.getIndividualSize());
        int end = (int) (Math.random() * parent1.getIndividualSize());

        for (int i = 0; i < child.getIndividualSize(); i++) {
            if (start < end && i > start && i < end)
                child.setGene(i, parent1.getGene(i));
            else if (start > end) {
                if (!(i < start && i > end))
                    child.setGene(i, parent1.getGene(i));
            }
        }

        for (int i = 0; i < parent2.getIndividualSize(); i++) {
            for (int j = 0; j < child.getIndividualSize(); j++) {
                if (child.getGene(j) == null) {
                    child.setGene(j, parent2.getGene(i));
                    break;
                }
            }
        }
        
        child.calculateIndividual();
        return child;
    }

    private static void mutate(Individual individual) {
        for(int pos1 = 0; pos1 < individual.getIndividualSize(); pos1++) {
            if(Math.random() < mutationRate) {
                int pos2 = (int) (individual.getIndividualSize() * Math.random());

                int gene1 = individual.getGene(pos1);
                int gene2 = individual.getGene(pos2);

                individual.setGene(pos2, gene1);
                individual.setGene(pos1, gene2);
            }
        }
        
        individual.calculateIndividual();
    }
}
