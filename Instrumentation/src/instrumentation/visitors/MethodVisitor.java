/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentation.visitors;

import instrumentation.visitors.utils.ClassDefs;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.visitor.VoidVisitorAdapter;

/**
 *
 * @author User
 */
/**
     * Simple visitor implementation for visiting MethodDeclaration nodes. 
     */
public class MethodVisitor extends VoidVisitorAdapter {

    @Override
    public void visit(MethodDeclaration n, Object arg) {
        ClassDefs cd = (ClassDefs)arg;
        if(n.getName().startsWith("test") && n.getType().toString().contains("void") && n.getParameters() == null){
            cd.setTests(true);
        }
    }
}
