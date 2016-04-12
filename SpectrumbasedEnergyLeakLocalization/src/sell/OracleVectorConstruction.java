package sell;

public class OracleVectorConstruction implements OracleVectorConstructionStrategy {

    @Override
    public ComponentSample[] constructOracleVector(ComponentSample[][] matrix, int numberOfComponents, int numberOfTests) {
        ComponentSample[] oracleVector = new ComponentSample[numberOfTests];
        
        for (int i = 0; i < matrix.length; i++) {
            double cpuTotal = 0, diskTotal = 0, fansTotal = 0, gpuTotal = 0, dramTotal = 0;
            double timeTotal = 0;
            long cardinalityTotal = 0;
            for (ComponentSample vector : matrix[i]) {
                cpuTotal += vector.getPowerConsumption().getCpu();
                diskTotal += vector.getPowerConsumption().getDisk();
                fansTotal += vector.getPowerConsumption().getFans();
                gpuTotal += vector.getPowerConsumption().getGPU();
                dramTotal += vector.getPowerConsumption().getMemory();
                timeTotal += vector.getTime();
                cardinalityTotal += vector.getNumberOfTimesUsed();
            }
            oracleVector[i] = new ComponentSample();
            
            PowerConsumption powerConsumption = new PowerConsumption(cpuTotal, dramTotal, diskTotal, fansTotal, gpuTotal);
            
            oracleVector[i].setPowerConsumption(powerConsumption);
            oracleVector[i].setTime(timeTotal);
            oracleVector[i].setNumberOfTimesUsed(cardinalityTotal);
        }
        
        return oracleVector;
    }
    
}
