package sell;

public class ComponentSimilarity {
    private PowerSimilarity powerSimilarity;
    private double cardinalitySimilarity; 
    private double timeSimilarity;

    public ComponentSimilarity() {
    }

    public PowerSimilarity getPowerSimilarity() {
        return powerSimilarity;
    }

    public void setPowerSimilarity(PowerSimilarity powerSimilarity) {
        this.powerSimilarity = powerSimilarity;
    }

    public double getCardinalitySimilarity() {
        return cardinalitySimilarity;
    }

    public void setCardinalitySimilarity(double cardinalitySimilarity) {
        this.cardinalitySimilarity = cardinalitySimilarity;
    }

    public double getTimeSimilarity() {
        return timeSimilarity;
    }

    public void setTimeSimilarity(double timeSimilarity) {
        this.timeSimilarity = timeSimilarity;
    }
}
