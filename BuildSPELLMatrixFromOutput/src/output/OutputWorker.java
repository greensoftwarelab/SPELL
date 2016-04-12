package output;

import genericTree.Tree;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class OutputWorker {
    private static int actualPosition = 0;
    private List<Tree<ComponentNode>> tests;
    private List<ArrayList<ComponentNode>> totalComponentsByTest;
    private TreeMap<String, Integer> componentToPosition;
    
    public OutputWorker() {
        componentToPosition = new TreeMap<>();
    }
    
    public List<Tree<ComponentNode>> getTests() {
        return tests;
    }
    
    public void setTests(List<Tree<ComponentNode>> tests) {
        this.tests = tests;
    }
    
    private void calculateComponentToPositionByTest(ArrayList<ComponentNode> test) {
        for (ComponentNode component : test) {
            Integer position = componentToPosition.get(component.getId());
            if (position == null) {
                componentToPosition.put(component.getId(), actualPosition);
                actualPosition++;
            }
        }
    }
    
    private void calculateTotalComponents() {
        totalComponentsByTest = new ArrayList<>();
        for (Tree<ComponentNode> test : tests) {
            ArrayList<ComponentNode> totalComponents = TreeComponentUtility.getComponentNodesTotal(test);
            
            calculateComponentToPositionByTest(totalComponents);
            totalComponentsByTest.add(totalComponents);
        }
    }
    
    public void prettyPrintTree(){
        List<Tree<ComponentNode>> tree = this.getTests();
        int size = tree.size();
        for(int i=0; i<size; i++){
            tree.get(i).prettyPrintTree();
        }
    }
    
    public String generateComponentNames(){
        StringBuilder output = new StringBuilder();
        String[] comps = new String[componentToPosition.size()];
        for(Map.Entry<String,Integer> entry : componentToPosition.entrySet()){
            comps[entry.getValue()] = entry.getKey();
         }
        output.append(Arrays.toString(comps));
        return output.toString();
    }
    public String generateOutput() {
        calculateTotalComponents();
        ComponentNode[][] matrixToOuput = new ComponentNode[totalComponentsByTest.size()][actualPosition];
        StringBuilder output = new StringBuilder();
        
        for (int i = 0; i < totalComponentsByTest.size(); i++) {
            List<ComponentNode> test = totalComponentsByTest.get(i);
            for (ComponentNode component : test) {
                int column = componentToPosition.get(component.getId());
                matrixToOuput[i][column] = component;
            }
        }
        
        for (ComponentNode[] testLine : matrixToOuput) {
            output.append("[");
            for (ComponentNode component : testLine) {
                boolean used = false;
                
                if (component == null) {
                    output.append(" _ ");
                }
                else {
                    if(!component.getId().equals("paiSpell")){
                        output.append("[");
                        String componentOutput = getOutputFromComponent(component);
                        output.append(componentOutput);
                        output.append(" ]");
                    }
                }
            }
            output.append("]\n");
        }
        return output.toString();
    }
    
    //consumption changed to milliJoules, hence *1000
    private String getOutputFromComponent(ComponentNode component) {
        String output = "";
        boolean used = false;
        if (component.getTime() != 0) {
            output += " t = "+component.getTime();
            used = true;
        }
        else{
            output += " t = 0.0";
            used = true;
        }
        if (component.getNumberOfTimesUsed()!= 0) {
            output += used ? "," : "";
            used = true;
            output += " n = "+component.getNumberOfTimesUsed();
        }
        if (component.getCpu()!= 0) {
            output += used ? "," : "";
            used = true;
            output += " cpu = "+(component.getCpu());
        }
        else{
            output += used ? "," : "";
            used = true;
            output += " cpu = "+(component.getCpu());
        }
        if (component.getDisk()!= 0) {
            output += used ? "," : "";
            used = true;
            output += " disk = "+(component.getDisk());
        }
        if (component.getFans()!= 0) {
            output += used ? "," : "";
            used = true;
            output += " fans = "+(component.getFans());
        }
        if (component.getGpu()!= 0) {
            output += used ? "," : "";
            used = true;
            output += " gpu = "+(component.getGpu());
        }
        if (component.getRam()!= 0) {
            output += used ? "," : "";
            output += " ram = "+(component.getRam());
        }
        
        return output;
    }
}
