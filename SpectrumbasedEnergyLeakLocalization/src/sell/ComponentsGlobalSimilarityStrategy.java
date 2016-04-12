package sell;

public interface ComponentsGlobalSimilarityStrategy {
    public double[] calculateComponentsGlobalSimilarity(ComponentSample[][] matrix, int numberOfComponents, int numberOfTests, ComponentSample[] oracleVector, SimilarityFormula similarityFormula);
}
