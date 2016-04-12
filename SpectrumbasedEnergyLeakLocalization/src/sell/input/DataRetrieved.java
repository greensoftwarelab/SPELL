package sell.input;

import java.util.ArrayList;
import sell.ComponentSample;

public class DataRetrieved {
    private ArrayList<DataLineRetrieved> dataMatrix;
    private ComponentSample[][] matrix;
    private boolean dataExtracted;
    
    public DataRetrieved() {
        dataMatrix = new ArrayList<>();
        dataExtracted = false;
    }

    public DataRetrieved(ArrayList<DataLineRetrieved> dataMatrix) {
        this.dataMatrix = dataMatrix;
        extractDataRetrieved();
    }

    public ArrayList<DataLineRetrieved> getDataMatrix() {
        return dataMatrix;
    }
    
    public ComponentSample[][] getComponentsMatrix() {
        if (!dataExtracted) extractDataRetrieved();
        return matrix;
    }
    
    public void addVector(DataLineRetrieved vector) {
        dataMatrix.add(vector);
    }
    
    private void extractDataRetrieved() {
        int numberOfLines = dataMatrix.size();
        int numberOfColumns = dataMatrix.get(0).getVectorArrayList().size();
        
        if (numberOfColumns > 0){
            matrix = new ComponentSample[numberOfLines][numberOfColumns];
            int actualLine = 0;
            
            for (DataLineRetrieved vector : dataMatrix) {
                matrix[actualLine] = vector.getVector();
                
                actualLine++;
            }
        }
        dataExtracted = true;
    }
}
