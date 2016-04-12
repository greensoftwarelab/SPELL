package sell.input;

import java.util.TreeMap;

public class ComponentParameters {
    private TreeMap<String, String> values;

    public ComponentParameters() {
        values = new TreeMap<>();
    }
    
    public void put(String key, String value) {
        values.put(key, value);
    }

    public TreeMap<String, String> getValues() {
        return values;
    }
}
