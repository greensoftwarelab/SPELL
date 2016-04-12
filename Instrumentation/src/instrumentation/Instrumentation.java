/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentation;

import instrumentation.transform.InstrumentHelper;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Instrumentation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InstrumentHelper helper = new InstrumentHelper("_INST_", args[0]);
        try {
            helper.generateTransformedProject();
        } catch (Exception ex) {
            Logger.getLogger(Instrumentation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
