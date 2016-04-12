/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentation.visitors;

import japa.parser.ast.stmt.BlockStmt;
import japa.parser.ast.stmt.Statement;
import japa.parser.ast.stmt.SynchronizedStmt;
import japa.parser.ast.visitor.VoidVisitorAdapter;

/**
 *
 * @author User
 */
public class SynchChangerVisitor extends VoidVisitorAdapter {

    @Override
    public void visit(SynchronizedStmt n, Object arg) {
        ReturnFinder.verify((BlockStmt)n.getBlock(), (Statement)arg);
    }
    
}
