/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentation.visitors;

import japa.parser.ast.stmt.BlockStmt;
import japa.parser.ast.stmt.CatchClause;
import japa.parser.ast.stmt.Statement;
import japa.parser.ast.visitor.VoidVisitorAdapter;

/**
 *
 * @author User
 */
public class CatchChangerVisitor extends VoidVisitorAdapter {

    @Override
    public void visit(CatchClause n, Object arg) {
        ReturnFinder.verify((BlockStmt)n.getCatchBlock(), (Statement)arg);
    }
    
}
