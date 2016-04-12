/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentation.visitors;

import instrumentation.visitors.utils.ReturnFlag;
import japa.parser.ASTHelper;
import japa.parser.ast.stmt.BlockStmt;
import japa.parser.ast.stmt.Statement;
import japa.parser.ast.stmt.WhileStmt;
import japa.parser.ast.visitor.VoidVisitorAdapter;

/**
 *
 * @author User
 */
class WhileChangerVisitor extends VoidVisitorAdapter{

    @Override
    public void visit(WhileStmt n, Object arg) {
        if(n.getCondition().toString().equals("true")){
            ReturnFlag x = (ReturnFlag)arg;
            x.setRet(true);
        }
    }
    
}
