package sell;

public class PowerConsumption {
    private double cpu;
    private double memory;
    private double disk;
    private double fans;
    private double gpu;

    public PowerConsumption() {
        cpu = 0;
        memory = 0;
        disk = 0;
        fans = 0;
        gpu = 0;
    }

    public PowerConsumption(double cpu, double memory, double disk, double fans, double gpu) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
        this.fans = fans;
        this.gpu = gpu;
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

    public double getGPU() {
        return gpu;
    }

    public void setGPU(double gpu) {
        this.gpu = gpu;
    }

    @Override
    public String toString() {
        return "PowerConsumption{" + "cpu=" + cpu + ", memory=" + memory + ", disk=" + disk + ", fans=" + fans + ", gpu=" + gpu + '}';
    }
}
