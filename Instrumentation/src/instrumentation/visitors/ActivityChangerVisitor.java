/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentation.visitors;

import japa.parser.ASTHelper;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.expr.MethodCallExpr;
import japa.parser.ast.expr.ThisExpr;
import japa.parser.ast.stmt.ExpressionStmt;
import japa.parser.ast.visitor.VoidVisitorAdapter;
import instrumentation.visitors.utils.ClassDefs;

/**
 *
 * @author User
 */
public class ActivityChangerVisitor extends VoidVisitorAdapter {
    
    @Override
    public void visit(MethodDeclaration n, Object arg) {
        // here you can access the attributes of the method.
        // this method will be called for all methods in this 
        // CompilationUnit, including inner class methods
        
        /** Must not include replications! CHECK LATER!*/
        ClassDefs flags=(ClassDefs)arg;
        String name = n.getName();
        int insertIn = 1;
        if(name.equals("onCreate") && !flags.isLauncher()){
            MethodCallExpr mcStart = new MethodCallExpr();
            mcStart.setName("StaticEstimator.start");
            /*if(flags.isLauncher()){
                MethodCallExpr mcConfig = new MethodCallExpr();
                mcConfig.setName("StaticEstimator.config");
                MethodCallExpr getUid = new MethodCallExpr();
                getUid.setName("SystemInfo.getInstance().getUidForPid");
                MethodCallExpr getPid = new MethodCallExpr();
                getPid.setName("android.os.Process.myPid");
                ASTHelper.addArgument(getUid, getPid);
                ASTHelper.addArgument(mcConfig, new ThisExpr());
                ASTHelper.addArgument(mcConfig, getUid);
                
                n.getBody().getStmts().add(insertIn, new ExpressionStmt(mcConfig));
                insertIn++;
            }*/
            n.getBody().getStmts().add(insertIn, new ExpressionStmt(mcStart));
        }
        if(name.equals("onStop")){
            flags.setStop(true);
            //include 'saveMatrix()' at the begining;
            MethodCallExpr mcStop = new MethodCallExpr();
            mcStop.setName("StaticEstimator.saveMatrix");
            n.getBody().getStmts().add(0, new ExpressionStmt(mcStop));
        }
        
    }
}
