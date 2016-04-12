/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentation.visitors;

import instrumentation.visitors.utils.ReturnFlag;
import japa.parser.ASTHelper;
import japa.parser.ast.stmt.BlockStmt;
import japa.parser.ast.stmt.ForStmt;
import japa.parser.ast.stmt.Statement;
import japa.parser.ast.visitor.VoidVisitorAdapter;

/**
 *
 * @author User
 */
class ForChangerVisitor extends VoidVisitorAdapter{

    @Override
    public void visit(ForStmt n, Object arg) {
        if(n.getCompare().toString().equals("true")){
           ReturnFlag x = (ReturnFlag)arg;
           x.setRet(true);
        }
    }
    
}
