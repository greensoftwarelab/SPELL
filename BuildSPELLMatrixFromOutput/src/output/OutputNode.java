package output;

import java.util.Map;
import java.util.TreeMap;

public class OutputNode {
    private String id;
    private String moduleName;
    private double time;
    private double cpu;
    private double ram;
    private double disk;
    private double fans;
    private double gpu;
    
    public OutputNode() {
        moduleName = "";
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getModuleName() {
        return moduleName;
    }
    
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
    
    public double getTime() {
        return time;
    }
    
    public void setTime(long time) {
        this.time = time;
    }
    
    public double getCpu() {
        return cpu;
    }
    
    public double getRam() {
        return ram;
    }
    
    public double getDisk() {
        return disk;
    }
    
    public double getFans() {
        return fans;
    }
    
    public double getGpu() {
        return gpu;
    }
    
    public void setParameters(OutputNodeParameters parameters) {
        
        TreeMap<String, String> params = parameters.getValues();
        for (Map.Entry<String, String> parameter : params.entrySet()) {
            switch(parameter.getKey()) {
                case "m" :
                    moduleName = parameter.getValue();
                    break;
                case "t" :
                    time = Double.parseDouble(parameter.getValue());
                    break;
                case "cpu" :
                    cpu = Double.parseDouble(parameter.getValue());
                    break;
                case "ram" :
                    ram = Double.parseDouble(parameter.getValue());
                    break;
                case "disk" :
                    disk = Double.parseDouble(parameter.getValue());
                    break;
                case "fans" :
                    fans = Double.parseDouble(parameter.getValue());
                    break;
                case "gpu" :
                    gpu = Double.parseDouble(parameter.getValue());
                    break;
                default :
                    break;
            }
        }
    }
}
