/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentation.visitors;

import instrumentation.visitors.utils.ReturnFlag;
import japa.parser.ASTHelper;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.expr.Expression;
import japa.parser.ast.expr.IntegerLiteralExpr;
import japa.parser.ast.stmt.Statement;
import japa.parser.ast.expr.MethodCallExpr;
import japa.parser.ast.expr.StringLiteralExpr;
import japa.parser.ast.stmt.ExpressionStmt;
import japa.parser.ast.visitor.VoidVisitorAdapter;
import java.util.List;
import instrumentation.visitors.utils.ClassDefs;

/**
 *
 * @author User
 */
public class MethodChangerVisitor extends VoidVisitorAdapter {
    
    
    
    @Override
    public void visit(MethodDeclaration n, Object arg) {
        ClassDefs cDef = (ClassDefs)arg;
        String cName = cDef.getName();
        String retType = n.getType().getClass().getName();
        
        //All the arguments for the function call
        Expression className = new StringLiteralExpr(cName);
        Expression method = new StringLiteralExpr(n.getName());
        Expression flagB = new IntegerLiteralExpr("0");
        Expression flagE = new IntegerLiteralExpr("1");
        
        if(n.getBody() != null){
            if(n.getBody().getStmts() != null){
                List<Statement> x = n.getBody().getStmts();

                MethodCallExpr mcB = new MethodCallExpr();
                mcB.setName("EnergyWrapper.getEnergy");
                ASTHelper.addArgument(mcB, className);
                ASTHelper.addArgument(mcB, method);
                ASTHelper.addArgument(mcB, flagB);
                int insertIn = 0;
				
                x.add(insertIn, new ExpressionStmt(mcB));
                
                MethodCallExpr mcE = new MethodCallExpr();
                mcE.setName("EnergyWrapper.getEnergy");
                ASTHelper.addArgument(mcE, className);
                ASTHelper.addArgument(mcE, method);
                ASTHelper.addArgument(mcE, flagE);

                ReturnFlag hasRet = new ReturnFlag();
                ReturnFlag unReachable = new ReturnFlag();
                new ReturnVisitor().visit(n, hasRet);
                new WhileChangerVisitor().visit(n, unReachable);
                new ForChangerVisitor().visit(n, unReachable);
                
                if(hasRet.hasRet()){
                    new GenericBlockVisitor().visit(n, new ExpressionStmt(mcE));
                }

                MethodDeclaration mt;
                String stm = x.get(x.size()-1).getClass().getName();
                if(stm.contains("ReturnStmt") || stm.contains("ThrowStmt")){
                    x.add((x.size()-1), new ExpressionStmt(mcE));
                }else if(retType.contains("VoidType")){
                    if(!unReachable.hasRet()){
                        x.add(new ExpressionStmt(mcE));
                    }
                }

            }
        }
    }

}
