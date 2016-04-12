package sell;

public class ComponentsGlobalSimilarity implements ComponentsGlobalSimilarityStrategy {
    
    private static final double CPU_FACTOR = 0.34;
    private static final double DRAM_FACTOR = 0.01;
    private static final double FANS_FACTOR = 0.01;
    private static final double DISK_FACTOR = 0.02;
    private static final double GPU_FACTOR = 0.62;

    @Override
    public double[] calculateComponentsGlobalSimilarity(ComponentSample[][] matrix, int numberOfComponents, int numberOfTests, ComponentSample[] oracleVector, SimilarityFormula similarityFormula) {
        double[][] globalValuesMatrix = new double[numberOfTests][numberOfComponents];
        double[] globalValuesOracle = new double[numberOfTests];
        double[] globalValues = new double[numberOfComponents];
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                globalValuesMatrix[i][j] = convertToGlobalValue(matrix[i][j]);
            }
        }
        
        for (int i = 0; i < numberOfTests; i++) {
            globalValuesOracle[i] = 0;
            for (int j = 0; j < globalValuesMatrix[i].length; j++) {
                globalValuesOracle[i] += globalValuesMatrix[i][j];
            }
            //globalValuesOracle[i] = convertToGlobalValue(oracleVector[i]);
        }
        
        for (int j = 0; j < numberOfComponents; j++) {
            globalValues[j] = similarityFormula.calculateSimilarity(Util.getColumnFromMatrix(globalValuesMatrix, j), globalValuesOracle);
        }
        
        return globalValues;
    }
    
    private double convertToGlobalValue(ComponentSample componentSample) {
        double energyValue, timeValue, cardinalityValue;
        
        PowerConsumption powerConsumption = componentSample.getPowerConsumption();
        energyValue = powerConsumption.getCpu() * CPU_FACTOR + powerConsumption.getDisk()*DISK_FACTOR + powerConsumption.getFans()*FANS_FACTOR + powerConsumption.getGPU()*GPU_FACTOR + powerConsumption.getMemory()*DRAM_FACTOR;
        
        timeValue = componentSample.getTime();
        cardinalityValue = componentSample.getNumberOfTimesUsed();
        
        return energyValue * timeValue * cardinalityValue;
    }
    
}
