/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentation.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author User
 */
public class PackageM {
    private String name;
    private List<ClassM> classes;

    public PackageM() {
        this.name = "";
        this.classes = new LinkedList<ClassM>();
    }

    public PackageM(String name) {
        this.name = name;
        this.classes = new LinkedList<ClassM>();
    }

    public PackageM(String name, List<ClassM> classes) {
        this.name = name;
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ClassM> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassM> classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        String res = "<"+name+">\n";
        for(ClassM c : this.classes){
            res += c.toString();
        }
        return res;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PackageM other = (PackageM) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
    
}
