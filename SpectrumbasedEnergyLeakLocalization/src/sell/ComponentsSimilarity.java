package sell;

import java.util.Arrays;

public class ComponentsSimilarity implements ComponentsSimilarityStrategy {
    
    @Override
    public ComponentSimilarity[] calculateComponentsProbability(ComponentSample[][] matrix, int numberOfComponents, int numberOfTests, ComponentSample[] oracleVector, SimilarityFormula similarityFormula) {
        double[][] cpuValues = new double[numberOfTests][numberOfComponents];
        double[][] diskValues = new double[numberOfTests][numberOfComponents];
        double[][] fansValues = new double[numberOfTests][numberOfComponents];
        double[][] gpuValues = new double[numberOfTests][numberOfComponents];
        double[][] memoryValues = new double[numberOfTests][numberOfComponents];
        double[][] timeValues = new double[numberOfTests][numberOfComponents];
        double[][] cardinalityValues = new double[numberOfTests][numberOfComponents];
        
        double[] oracleCPUVector = new double[numberOfTests];
        double[] oracleDiskVector = new double[numberOfTests];
        double[] oracleFansVector = new double[numberOfTests];
        double[] oracleGPUVector = new double[numberOfTests];
        double[] oracleMemoryVector = new double[numberOfTests];
        double[] oracleTimeVector = new double[numberOfTests];
        double[] oracleCardinalityVector = new double[numberOfTests];
        
        ComponentSimilarity[] componentsSimilarity = new ComponentSimilarity[numberOfComponents];
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                PowerConsumption powerConsumption = matrix[i][j].getPowerConsumption();
                cpuValues[i][j] = powerConsumption.getCpu();
                diskValues[i][j] = powerConsumption.getDisk();
                fansValues[i][j] = powerConsumption.getFans();
                gpuValues[i][j] = powerConsumption.getGPU();
                memoryValues[i][j] = powerConsumption.getMemory();
                timeValues[i][j] = matrix[i][j].getTime();
                cardinalityValues[i][j] = matrix[i][j].getNumberOfTimesUsed();
            }
        }
        
        for (int i = 0; i < numberOfTests; i++) {
            PowerConsumption powerConsumption = oracleVector[i].getPowerConsumption();
            oracleCPUVector[i] = powerConsumption.getCpu();
            oracleDiskVector[i] = powerConsumption.getDisk();
            oracleFansVector[i] = powerConsumption.getFans();
            oracleGPUVector[i] = powerConsumption.getGPU();
            oracleMemoryVector[i] = powerConsumption.getMemory();
            oracleTimeVector[i] = oracleVector[i].getTime();
            oracleCardinalityVector[i] = oracleVector[i].getNumberOfTimesUsed();
        }
        
        for (int i = 0; i < numberOfComponents; i++) {
            double cpuSimilarity = similarityFormula.calculateSimilarity(Util.getColumnFromMatrix(cpuValues, i), oracleCPUVector);
            double diskSimilarity = similarityFormula.calculateSimilarity(Util.getColumnFromMatrix(diskValues, i), oracleDiskVector);
            double fansSimilarity = similarityFormula.calculateSimilarity(Util.getColumnFromMatrix(fansValues, i), oracleFansVector);
            double gpuSimilarity = similarityFormula.calculateSimilarity(Util.getColumnFromMatrix(gpuValues, i), oracleGPUVector);
            double dramSimilarity = similarityFormula.calculateSimilarity(Util.getColumnFromMatrix(memoryValues, i), oracleMemoryVector);
            double timeSimilarity = similarityFormula.calculateSimilarity(Util.getColumnFromMatrix(timeValues, i), oracleTimeVector);
            double cardinalitySimilarity = similarityFormula.calculateSimilarity(Util.getColumnFromMatrix(cardinalityValues, i), oracleCardinalityVector);

            componentsSimilarity[i] = new ComponentSimilarity();
            PowerSimilarity powerSimilarity = new PowerSimilarity(cpuSimilarity, dramSimilarity, diskSimilarity, fansSimilarity, gpuSimilarity);
            componentsSimilarity[i].setPowerSimilarity(powerSimilarity);
            componentsSimilarity[i].setTimeSimilarity(timeSimilarity);
            componentsSimilarity[i].setCardinalitySimilarity(cardinalitySimilarity);
        }
        
        return componentsSimilarity;
    }
}
