package sell;

public class JaccardSimilarityCoefficient implements SimilarityFormula {

    @Override
    public double calculateSimilarity(double[] value1, double[] value2) {
        double topValue = 0, bottomValue = 0; 
        
        for (int i = 0; i < value1.length; i++) {
            topValue += Math.min(value1[i], value2[i]);
            bottomValue += Math.max(value1[i], value2[i]);
        }
        
        return topValue/bottomValue;
    }
    
}
