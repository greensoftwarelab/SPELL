/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentation.visitors;

import instrumentation.visitors.utils.ReturnFlag;
import japa.parser.ast.stmt.ReturnStmt;
import japa.parser.ast.visitor.VoidVisitorAdapter;

/**
 *
 * @author User
 */
public class ReturnVisitor extends VoidVisitorAdapter {

    @Override
    public void visit(ReturnStmt n, Object arg) {
        ReturnFlag x = (ReturnFlag)arg;
        x.setRet(true);
        
    }
    
}
