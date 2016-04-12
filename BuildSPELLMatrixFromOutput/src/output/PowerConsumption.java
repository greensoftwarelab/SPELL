package output;

public class PowerConsumption {
    public double cpu;
    public double memory;
    public double disk;
    public double fans;
    public double graphic;
    public double total;

    public PowerConsumption() {
        cpu = 0;
        memory = 0;
        disk = 0;
        fans = 0;
        graphic = 0;
        total = 0;
    }

    public PowerConsumption(double cpu) {
        this.cpu = cpu;
    }
    
    public double getCpu() {
        return cpu;
    }

    public void setCpu(double cpu) {
        this.cpu = cpu;
    }

    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }

    public double getDisk() {
        return disk;
    }

    public void setDisk(double disk) {
        this.disk = disk;
    }

    public double getFans() {
        return fans;
    }

    public void setFans(double fans) {
        this.fans = fans;
    }

    public double getGraphic() {
        return graphic;
    }

    public void setGraphic(double graphic) {
        this.graphic = graphic;
    }

    public double getTotal() {
        double possibleTotal = cpu+memory+disk+fans+graphic;
        if (possibleTotal > total)
            total = possibleTotal;
        
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "PowerConsumption{" + "cpu=" + cpu + ", memory=" + memory + ", disk=" + disk + ", fans=" + fans + ", graphic=" + graphic + ", total=" + total + '}';
    }
}
