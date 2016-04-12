/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentation.visitors;

import japa.parser.ast.stmt.BlockStmt;
import japa.parser.ast.stmt.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class ReturnFinder {
    
    public static boolean verify(Statement st, Statement mcE){
        boolean res = false;
        List<Statement> list;
        BlockStmt bl = (BlockStmt)st;
        list = bl.getStmts();
        
        int i = 0; ArrayList<Integer> insertIn = new ArrayList<Integer>();
        if(list != null){
            for(Statement s : list){
                String stm = s.getClass().getName();
                if(stm.equals("japa.parser.ast.stmt.ReturnStmt") || stm.equals("japa.parser.ast.stmt.ThrowStmt") || stm.equals("japa.parser.ast.stmt.ContinueStmt")){
                    insertIn.add(i);
                    res = true;
                }
                i++;
            }
        }
        if(res){
            for(Integer j : insertIn){
                list.add(j, mcE);
            }
        }


        return res;
    }
}
