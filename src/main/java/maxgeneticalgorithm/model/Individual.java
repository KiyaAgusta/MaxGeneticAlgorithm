package maxgeneticalgorithm.model;

import java.util.ArrayList;

public class Individual {
    private final ArrayList<Integer> genes = new ArrayList<Integer>();
    private final int individualSize = 8;
    private double binary, value, fitness = 0;

    public Individual(boolean initialize) {
        generateRandomGenes(initialize);
        
        if (initialize)
            calculateIndividual();
    }
    
    private void generateRandomGenes(boolean initialize) {
        for (int i = 0; i < individualSize; i++) {
            if (initialize)
                genes.add((int) Math.round(Math.random()));
            else
                genes.add(null);
        }
    }
    
    private double calculateBinary() {
        int totalGenes = genes.get(0) * 128 + genes.get(1) * 64 +
                         genes.get(2) * 32  + genes.get(3) * 16 +
                         genes.get(4) * 8   + genes.get(5) * 4  +
                         genes.get(6) * 2   + genes.get(7) * 1;
        
        return (double) totalGenes / 256;
    }
    
    private double calculateValue() {
        return (double) Math.exp(-2 * binary) * Math.sin(3 * binary);
    }

    public double getFitness() {
        if (fitness == 0)
            fitness = 1 / (double) 1 + value;
        
        return fitness;
    }

    public int getIndividualSize() {
        return individualSize;
    }

    public double getBinary() {
        return binary;
    }
    
    public double getValue() {
        return value;
    }
    
    public Integer getGene(int index) {
        return genes.get(index);
    }
    
    public void setGene(int position, int gene) {
        genes.set(position, gene);
        fitness = 0;
    }
    
    public void calculateIndividual() {
        binary = calculateBinary();
        value = calculateValue();
    }
}
