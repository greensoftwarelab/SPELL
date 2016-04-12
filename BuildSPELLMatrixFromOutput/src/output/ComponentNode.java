package output;

import java.util.Objects;

public class ComponentNode {
    private String id;
    private String moduleName;
    private double time;
    private double cpu;
    private double ram;
    private double disk;
    private double fans;
    private double gpu;
    private long numberOfTimesUsed;

    public ComponentNode() {
        numberOfTimesUsed = 1;
    }
    
    public ComponentNode(OutputNode begin, OutputNode end, int cpuExp, int timeExp) {
        id = begin.getId();
        moduleName = begin.getModuleName();
        if(timeExp!=0){
            double endTime = end.getTime()*Math.pow(10,timeExp);
            double beginTime = begin.getTime()*Math.pow(10,timeExp);
            time = (endTime-beginTime);
        }
        else{
            time = end.getTime()-begin.getTime();
        }
        //System.out.println("End: "+(end.getTime()));
        //System.out.println("Begin: "+(begin.getTime()));
        //System.out.println("Time: "+(time));
        
        if(cpuExp!=0){
            double endCpu = end.getCpu()*Math.pow(10,cpuExp);
            double beginCpu = begin.getCpu()*Math.pow(10,cpuExp);
            cpu = (endCpu-beginCpu);
        
        }
        else    
            cpu = end.getCpu()-begin.getCpu();
        
        ram = end.getRam()-begin.getRam();
        disk = end.getDisk()-begin.getDisk();
        fans = end.getFans()-begin.getFans();
        gpu = end.getGpu()-begin.getGpu();
        numberOfTimesUsed = 1;
        
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
    
    public long getNumberOfTimesUsed() {
        return numberOfTimesUsed;
    }

    public void setNumberOfTimesUsed(long numberOfTimesUsed) {
        this.numberOfTimesUsed = numberOfTimesUsed;
    }
    
    public void incNumberOfTimesUsed() {
        numberOfTimesUsed++;
    }

    public double getCpu() {
        return cpu;
    }

    public void setCpu(double cpu) {
        this.cpu = cpu;
    }

    public double getRam() {
        return ram;
    }

    public void setRam(double ram) {
        this.ram = ram;
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

    public double getGpu() {
        return gpu;
    }

    public void setGpu(double gpu) {
        this.gpu = gpu;
    }
    
    void add(ComponentNode component) {
        time += component.getTime();
        cpu = (cpu+component.getCpu());
        ram = (ram+component.getRam());
        disk = (disk+component.getDisk());
        fans = (fans+component.getFans());
        gpu = (gpu+component.getGpu());
        incNumberOfTimesUsed();
    }

    @Override
    public String toString() {
        return moduleName + "::" + id + " (time = " + time + " energy = " + (cpu+ram+disk+fans+gpu) + " numberOfTimesUsed = " + numberOfTimesUsed + ")";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ComponentNode other = (ComponentNode) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.moduleName, other.moduleName);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.moduleName);
        return hash;
    }
}
