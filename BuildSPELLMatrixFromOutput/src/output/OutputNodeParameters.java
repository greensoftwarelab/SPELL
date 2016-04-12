package output;

import java.util.TreeMap;

public class OutputNodeParameters {
    private TreeMap<String, String> values;

    public OutputNodeParameters() {
        values = new TreeMap<String, String>();
    }
    
    public void put(String key, String value) {
        values.put(key, value);
    }

    public TreeMap<String, String> getValues() {
        return values;
    }
}
