/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentation.visitors;

import japa.parser.ast.stmt.BlockStmt;
import japa.parser.ast.stmt.Statement;
import japa.parser.ast.stmt.SwitchEntryStmt;
import japa.parser.ast.visitor.VoidVisitorAdapter;

/**
 *
 * @author User
 */
public class SwitchEntryChangerVisitor extends VoidVisitorAdapter {

    @Override
    public void visit(SwitchEntryStmt n, Object arg) {
        BlockStmt b = new BlockStmt(n.getStmts());
        ReturnFinder.verify(b, (Statement)arg);
    }
    
}
