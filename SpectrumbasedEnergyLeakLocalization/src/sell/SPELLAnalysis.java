package sell;

import java.util.Arrays;
import java.util.Comparator;

public class SPELLAnalysis {
    private int numberOfComponents;
    private int numberOfTests;
    private ComponentSample[][] matrix;
    private ComponentSample[] oracleVector;
    private ComponentSimilarity[] similarityComponentVector;
    private ComponentsSimilarityStrategy componentSimilarityStrategy;
    private OracleVectorConstructionStrategy oracleVectorConstructionStrategy;
    private SimilarityFormula similarityFormula;
    private ComponentsGlobalSimilarityStrategy componentsGlobalSimilarityStrategy;
    private double[] componentsGlobalSimilarityVector;
    
    private SPELLAnalysis() {}
    
    public SPELLAnalysis(ComponentsSimilarityStrategy componentSimilarityStrategy, OracleVectorConstructionStrategy oracleVectorConstructionStrategy, ComponentsGlobalSimilarityStrategy componentsGlobalSimilarityStrategy, SimilarityFormula similarityFormula) {
        this.componentSimilarityStrategy = componentSimilarityStrategy;
        this.oracleVectorConstructionStrategy = oracleVectorConstructionStrategy;
        this.componentsGlobalSimilarityStrategy = componentsGlobalSimilarityStrategy;
        this.similarityFormula = similarityFormula;
    }

    public int getNumberOfComponents() {
        return numberOfComponents;
    }

    public int getNumberOfTests() {
        return numberOfTests;
    }

    public ComponentSample[][] getMatrix() {
        return matrix;
    }

    public ComponentSample[] getOracleVector() {
        return oracleVector;
    }

    public ComponentSimilarity[] getSimilarityComponentVector() {
        return similarityComponentVector;
    }

    public ComponentsSimilarityStrategy getComponentSimilarityStrategy() {
        return componentSimilarityStrategy;
    }

    public OracleVectorConstructionStrategy getOracleVectorConstructionStrategy() {
        return oracleVectorConstructionStrategy;
    }

    public ComponentsGlobalSimilarityStrategy getTotalValueComponentSimilarity() {
        return componentsGlobalSimilarityStrategy;
    }

    public double[] getComponentsGlobalSimilarityVector() {
        return componentsGlobalSimilarityVector;
    }

    public void setNumberOfComponents(int numberOfComponents) {
        this.numberOfComponents = numberOfComponents;
    }

    public void setNumberOfTests(int numberOfTests) {
        this.numberOfTests = numberOfTests;
    }

    public void setMatrix(ComponentSample[][] matrix) {
        this.matrix = matrix;
        this.numberOfComponents = matrix[0].length;
        this.numberOfTests = matrix.length;
    }

    public void setComponentSimilarityStrategy(ComponentsSimilarityStrategy componentSimilarityStrategy) {
        this.componentSimilarityStrategy = componentSimilarityStrategy;
    }

    public void setOracleVectorConstructionStrategy(OracleVectorConstructionStrategy oracleVectorConstructionStrategy) {
        this.oracleVectorConstructionStrategy = oracleVectorConstructionStrategy;
    }

    public void setComponentsGlobalSimilarityStrategy(ComponentsGlobalSimilarityStrategy totalValueComponentSimilarity) {
        this.componentsGlobalSimilarityStrategy = totalValueComponentSimilarity;
    }
    
    public void calculateOracle() {
        oracleVector = oracleVectorConstructionStrategy.constructOracleVector(matrix, numberOfComponents, numberOfTests);
    }
    
    public void calculateComponentsSimilarity() {
        similarityComponentVector = componentSimilarityStrategy.calculateComponentsProbability(matrix, numberOfComponents, numberOfTests, oracleVector, similarityFormula);
    }
    
    public ComponentSimilarity[] orderComponentsBy(OrderParameter powerParameter) {
        Comparator<ComponentSimilarity> comparator = (ComponentSimilarity o1, ComponentSimilarity o2) -> {
            int comparatorValue;
            switch (powerParameter) {
                case CPU:
                    comparatorValue = new Double(o1.getPowerSimilarity().getCpu()).compareTo(o2.getPowerSimilarity().getCpu());
                    break;
                case DISK:
                    comparatorValue = new Double(o1.getPowerSimilarity().getDisk()).compareTo(o2.getPowerSimilarity().getDisk());
                    break;
                case FANS:
                    comparatorValue = new Double(o1.getPowerSimilarity().getFans()).compareTo(o2.getPowerSimilarity().getFans());
                    break;
                case MEMORY:
                    comparatorValue = new Double(o1.getPowerSimilarity().getMemory()).compareTo(o2.getPowerSimilarity().getMemory());
                    break;
                case GPU:
                    comparatorValue = new Double(o1.getPowerSimilarity().getGPU()).compareTo(o2.getPowerSimilarity().getGPU());
                    break;
                case TIME:
                    comparatorValue = new Double(o1.getTimeSimilarity()).compareTo(o2.getTimeSimilarity());
                    break;
                    
                default:
                    comparatorValue = new Double(o1.getCardinalitySimilarity()).compareTo(o2.getCardinalitySimilarity());
                    break;
            }
            return comparatorValue;
        };
        
        ComponentSimilarity[] toReturn = new ComponentSimilarity[similarityComponentVector.length];
        System.arraycopy(similarityComponentVector, 0, toReturn, 0, similarityComponentVector.length);
        
        Arrays.sort(toReturn, comparator);
        
        return toReturn;
    }
    
    public void calculateComponentsGlobalSimilarity() {
        componentsGlobalSimilarityVector = componentsGlobalSimilarityStrategy.calculateComponentsGlobalSimilarity(matrix, numberOfComponents, numberOfTests, oracleVector, similarityFormula);
    }
    
    public double[] orderComponentsByGlobalSimilarity() {
        double[] toReturn = new double[componentsGlobalSimilarityVector.length];
        System.arraycopy(componentsGlobalSimilarityVector, 0, toReturn, 0, componentsGlobalSimilarityVector.length);
        
        Arrays.sort(toReturn);
        
        return toReturn;
    }
    
    public void analyzeEnergyValues() {
        calculateOracle();
        calculateComponentsSimilarity();
        calculateComponentsGlobalSimilarity();
    }
}
