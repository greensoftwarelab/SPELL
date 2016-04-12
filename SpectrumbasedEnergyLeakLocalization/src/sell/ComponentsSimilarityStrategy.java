package sell;

public interface ComponentsSimilarityStrategy {
    public ComponentSimilarity[] calculateComponentsProbability(ComponentSample[][] matrix, int numberOfComponents, int numberOfTests, ComponentSample[] oracleVector, SimilarityFormula similarityFormula);
}
