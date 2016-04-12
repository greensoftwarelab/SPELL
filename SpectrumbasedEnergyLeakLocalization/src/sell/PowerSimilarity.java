package sell;

public class PowerSimilarity {
    public double cpu;
    public double memory;
    public double disk;
    public double fans;
    public double gpu;

    public PowerSimilarity() {
        cpu = 0;
        memory = 0;
        disk = 0;
        fans = 0;
        gpu = 0;
    }

    public PowerSimilarity(double cpu) {
        this.cpu = cpu;
    }

    public PowerSimilarity(double cpu, double memory, double disk, double fans, double gpu) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
        this.fans = fans;
        this.gpu = gpu;
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
}
