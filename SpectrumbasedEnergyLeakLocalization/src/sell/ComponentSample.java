package sell;

import java.util.Map;
import java.util.TreeMap;
import sell.input.ComponentParameters;

public class ComponentSample {
    private PowerConsumption powerConsumption;
    private long numberOfTimesUsed; 
    private double time;

    public ComponentSample() {
        powerConsumption = new PowerConsumption();
        numberOfTimesUsed = 0;
        time = 0;
    }
    
    public ComponentSample(boolean beenUsed) {
        powerConsumption = new PowerConsumption();
        numberOfTimesUsed = beenUsed ? 1 : 0;
        time = 0;
    }
    
    public ComponentSample(double cpuPowerConsumption, double time) {
        powerConsumption = new PowerConsumption(cpuPowerConsumption);
        this.time = time;
    }
    
    public ComponentSample(ComponentParameters parameters) {
        TreeMap<String, String> params = parameters.getValues();
        boolean beenUsed = params.size() > 0;
        if (beenUsed) {
            powerConsumption = new PowerConsumption();
            numberOfTimesUsed = 1;
            for (Map.Entry<String, String> parameter : params.entrySet()) {
                switch(parameter.getKey()) {
                    case "n" :
                        numberOfTimesUsed = Long.parseLong(parameter.getValue());
                        break;
                    case "t" :
                        time = Double.parseDouble(parameter.getValue());
                        break;
                    case "cpu" :
                        powerConsumption.setCpu(Double.parseDouble(parameter.getValue()));
                        break;
                    case "ram" :
                        powerConsumption.setMemory(Double.parseDouble(parameter.getValue()));
                        break;
                    case "disk" :
                        powerConsumption.setDisk(Double.parseDouble(parameter.getValue()));
                        break;
                    case "fans" :
                        powerConsumption.setFans(Double.parseDouble(parameter.getValue()));
                        break;
                    case "gpu" :
                        powerConsumption.setGPU(Double.parseDouble(parameter.getValue()));
                        break;
                    default :
                        break;
                }
            }
        }  
    } 
    
    public PowerConsumption getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(PowerConsumption powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public long getNumberOfTimesUsed() {
        return numberOfTimesUsed;
    }

    public void setNumberOfTimesUsed(long numberOfTimesUsed) {
        this.numberOfTimesUsed = numberOfTimesUsed;
    }
    
    public boolean hasBeenUsed() {
        return numberOfTimesUsed > 0;
    }

    @Override
    public String toString() {
        return "ComponentSample{" + "powerConsumption=" + powerConsumption + ", numberOfTimesUsed=" + numberOfTimesUsed + ", time=" + time + '}';
    }
    
    public String toStringUsedOrNot() {
        return numberOfTimesUsed > 0 ? "1" : "0";
    }
}
