/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentation.visitors;

import japa.parser.ASTHelper;
import japa.parser.ast.stmt.BlockStmt;
import japa.parser.ast.stmt.Statement;
import japa.parser.ast.stmt.TryStmt;
import japa.parser.ast.visitor.VoidVisitorAdapter;

/**
 *
 * @author User
 */
class TryChangerVisitor extends VoidVisitorAdapter{

    public TryChangerVisitor(){
    }
    
    @Override
    public void visit(TryStmt n, Object arg) {

        if(n.getTryBlock()!= null){
            ReturnFinder.verify(n.getTryBlock(), (Statement)arg);
        }
        
        if(n.getFinallyBlock() != null){
            ReturnFinder.verify(n.getFinallyBlock(), (Statement)arg);
        }
        
    }
    
}
