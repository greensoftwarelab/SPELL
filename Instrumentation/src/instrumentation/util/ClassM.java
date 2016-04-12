/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentation.util;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author User
 */
public class ClassM {
    private String name;
    private List<String> methods;

    public ClassM() {
       this.name = "";
       this.methods = new LinkedList<String>();
    }

    public ClassM(String name, List<String> methods) {
        this.name = name;
        this.methods = methods;
    }

    public ClassM(String name) {
        this.name = name;
        this.methods = new LinkedList<String>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getMethods() {
        return methods;
    }

    public void setMethods(List<String> methods) {
        this.methods = methods;
    }

    @Override
    public String toString() {
        String res = "(Class)"+name+"\n";
        for(String s : this.methods){
            res+=s+";";
        }
        res = res.substring(0, res.length()-1);
        res+="\n";
        return res;
    }
    
    
}
