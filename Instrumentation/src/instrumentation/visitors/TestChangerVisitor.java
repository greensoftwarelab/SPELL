/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentation.visitors;

import japa.parser.ASTHelper;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.ModifierSet;
import japa.parser.ast.expr.Expression;
import japa.parser.ast.expr.MethodCallExpr;
import japa.parser.ast.expr.StringLiteralExpr;
import japa.parser.ast.stmt.BlockStmt;
import japa.parser.ast.stmt.ExpressionStmt;
import japa.parser.ast.stmt.Statement;
import japa.parser.ast.visitor.VoidVisitorAdapter;
import java.util.LinkedList;
import java.util.List;
import instrumentation.visitors.utils.ClassDefs;

/**
 *
 * @author User
 */
public class TestChangerVisitor extends VoidVisitorAdapter{
    @Override
    public void visit(MethodDeclaration n, Object arg) {
        /** try catch
        VoidType voidT = new VoidType();
        if(!n.getType().equals(voidT)) return;
        */
        ClassDefs cDef = (ClassDefs)arg;
        Expression className = new StringLiteralExpr(cDef.getDescriptor());
        Expression method = new StringLiteralExpr(n.getName());
        if(n.getBody() == null) n.setBody(new BlockStmt());
        List<Statement> x = n.getBody().getStmts() != null ? n.getBody().getStmts() : new LinkedList<Statement>();
        if(n.getName().equals("suite") && n.getType().getClass().getName().equals("Test")){
            //is a Test Suite
            cDef.setSuite(true);
        }else{
            //is a Test Case / Class test
            //StaticEstimator.startEstimator("<org.sufficientlysecure.keychain.helper>PgpMain", "encryptAndSign");
            if(n.getName().equals("setUp")){
                cDef.setSetUp(true);
                //... <- add the call 'startEstimator();' at the begining
                MethodCallExpr mcS = new MethodCallExpr();
                mcS.setName("StaticEstimator.start");
                
                MethodCallExpr mcConfig = new MethodCallExpr();
                mcConfig.setName("StaticEstimator.config");
                MethodCallExpr getUid = new MethodCallExpr();
                //getUid.setName("SystemInfo.getInstance().getUidForPid");
                getUid.setName("android.os.Process.myUid");
                //MethodCallExpr getPid = new MethodCallExpr();
                //getPid.setName("android.os.Process.myPid");
                MethodCallExpr getContext = new MethodCallExpr();
                if(!cDef.isInstrumented()){
                    getContext.setName("this.getContext");
                }else{
                    getContext.setName("this.getInstrumentation().getTargetContext");
                }
                //ASTHelper.addArgument(getUid, getPid);
                ASTHelper.addArgument(mcConfig, new StringLiteralExpr(cDef.getAppName()));
                ASTHelper.addArgument(mcConfig, getUid);
                ASTHelper.addArgument(mcConfig, getContext);
                
                x.add(0, new ExpressionStmt(mcConfig));
                x.add(1, new ExpressionStmt(mcS));
                n.getBody().setStmts(x);
            }else if(n.getName().equals("tearDown")){
                cDef.setTearDown(true);
                //... <- add the call 'stop();' at the end
                MethodCallExpr mcT = new MethodCallExpr();
                mcT.setName("StaticEstimator.stop");
                
                x.add(0, new ExpressionStmt(mcT));
                n.getBody().setStmts(x);
            }
            /** try catch
            else if(ModifierSet.isPublic(n.getModifiers())){
                List<Statement> allStmt = new ArrayList<Statement>();
                List<Statement> catchStmt = new ArrayList<Statement>();
                catchStmt.add(new ExpressionStmt(new MethodCallExpr(null, "StaticEstimator.stop")));
                ArrayList<CatchClause> catches = new ArrayList<CatchClause>();
                Parameter p = ASTHelper.createParameter(ASTHelper.createReferenceType("Exception", 0), "ex");
                CatchClause clause = new CatchClause(p, new BlockStmt(catchStmt));
                catches.add(clause);
                TryStmt tr = new TryStmt(n.getBody(), catches, null);
                allStmt.add(tr);
                n.setBody(new BlockStmt(allStmt));
            }
            */
            else if(n.getType().toString().equals("void") && n.getName().startsWith("test") && n.getParameters() == null){
                //System.out.println(n.getName());
                //StaticEstimator.setMethod();
                /*
                MethodCallExpr met = new MethodCallExpr();
                met.setName("StaticEstimator.setTest");
                ASTHelper.addArgument(met, new StringLiteralExpr(n.getName()));
                x.add(0,new ExpressionStmt(met));
                */
            }
        }
        //All the arguments for the function call
        
    }
}
