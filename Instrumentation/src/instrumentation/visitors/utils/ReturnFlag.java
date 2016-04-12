/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentation.visitors.utils;

/**
 *
 * @author User
 */
public class ReturnFlag {
    private boolean hasRet;

    public ReturnFlag() {
    }

    public boolean hasRet() {
        return hasRet;
    }

    public void setRet(boolean hasRet) {
        this.hasRet = hasRet;
    }
    
    
}
