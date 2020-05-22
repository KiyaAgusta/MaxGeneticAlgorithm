package maxgeneticalgorithm.model;

public class Population {
    private final Individual[] individuals;

    public Population(int size, boolean initialize) {
        individuals = new Individual[size];
        
        if (initialize) {
            for (int i = 0; i < populationSize(); i++) {
                Individual individual = new Individual(true);
                saveIndividual(i, individual);
            }
        }
    }
    
    public void saveIndividual(int index, Individual individual) {
        individuals[index] = individual;
    }
    
    public Individual getIndividual(int index) {
        return individuals[index];
    }
    
    public int populationSize() {
        return individuals.length;
    }
    
    public Individual getFittest() {
        Individual fittest = individuals[0];
        
        for (int i = 1; i < populationSize(); i++) {
            if (fittest.getValue() <= getIndividual(i).getValue())
                fittest = getIndividual(i);
        }
        
        return fittest;
    }
    
    public double getTotalFitness() {
        double totalFitness = 0;
        
        for (int i = 0; i < populationSize(); i++)
            totalFitness += individuals[i].getFitness();
        
        return totalFitness;
    }
    
    public double getProbability(int index) {
        double[] probability = new double[populationSize()];
        
        for(int i = 0; i < populationSize(); i++)
            probability[i] = getIndividual(i).getFitness() / getTotalFitness();
        
        return probability[index];
    }
}
