package sell;

public interface OracleVectorConstructionStrategy {
    public ComponentSample[] constructOracleVector(ComponentSample[][] matrix, int numberOfComponents, int numberOfTests);
}
