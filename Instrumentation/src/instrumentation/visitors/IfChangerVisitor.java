/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentation.visitors;

import japa.parser.ASTHelper;
import japa.parser.ast.stmt.BlockStmt;
import japa.parser.ast.stmt.IfStmt;
import japa.parser.ast.stmt.Statement;
import japa.parser.ast.visitor.VoidVisitorAdapter;

/**
 *
 * @author User
 */
public class IfChangerVisitor extends VoidVisitorAdapter {

    @Override
    public void visit(IfStmt n, Object arg) {
        /*
        ReturnFinder.verify((BlockStmt)n.getThenStmt(), (Statement)arg);
        ReturnFinder.verify((BlockStmt)n.getElseStmt(), (Statement)arg);
        */
        if(n.getThenStmt() != null){
            if(n.getThenStmt().getClass().getName().contains("BlockStmt")){
                ReturnFinder.verify(n.getThenStmt(), (Statement)arg);
            }else{
                BlockStmt bl = new BlockStmt();
                ASTHelper.addStmt(bl, n.getThenStmt());
                n.setThenStmt(bl);
                ReturnFinder.verify(n.getThenStmt(), (Statement)arg);
            }
            
        }
        
        if(n.getElseStmt() != null){
            if(n.getElseStmt().getClass().getName().contains("BlockStmt")){
                ReturnFinder.verify(n.getElseStmt(), (Statement)arg);
            }else{
                BlockStmt bl = new BlockStmt();
                ASTHelper.addStmt(bl, n.getElseStmt());
                n.setElseStmt(bl);
                ReturnFinder.verify(n.getElseStmt(), (Statement)arg);
            }
            
        }
        
    }
    
}
