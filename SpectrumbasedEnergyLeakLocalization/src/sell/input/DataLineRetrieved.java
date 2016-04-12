package sell.input;

import java.util.ArrayList;
import sell.ComponentSample;

public class DataLineRetrieved {
    private ArrayList<ComponentSample> vector;

    public DataLineRetrieved() {
        vector = new ArrayList<>();
    }
    
    public ComponentSample[] getVector() {
        return (ComponentSample[]) vector.toArray(new ComponentSample[vector.size()]);
    }

    public ArrayList<ComponentSample> getVectorArrayList() {
        return vector;
    }

    public void addComponent(ComponentSample component) {
        vector.add(component);
    }
}
