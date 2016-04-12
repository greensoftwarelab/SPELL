/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentation.transform;

import japa.parser.ASTHelper;
import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.ImportDeclaration;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.ModifierSet;
import japa.parser.ast.expr.AnnotationExpr;
import japa.parser.ast.expr.MarkerAnnotationExpr;
import japa.parser.ast.expr.MethodCallExpr;
import japa.parser.ast.expr.NameExpr;
import japa.parser.ast.expr.StringLiteralExpr;
import japa.parser.ast.stmt.BlockStmt;
import japa.parser.ast.stmt.ExpressionStmt;
import japa.parser.ast.stmt.Statement;
import japa.parser.ast.type.ClassOrInterfaceType;
import japa.parser.ast.type.VoidType;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import instrumentation.visitors.utils.ClassDefs;
import instrumentation.util.FileUtils;
import instrumentation.util.PackageM;
import instrumentation.util.XMLParser;
import instrumentation.visitors.MethodChangerVisitor;
import instrumentation.visitors.MethodVisitor;
import instrumentation.visitors.TestChangerVisitor;

/**
 *
 * @author User
 */
public class InstrumentHelper {
    
    private String tName;
    private String project;
    private String transFolder;

    public InstrumentHelper() {
    }

    
    public InstrumentHelper(String tName, String proj) {
        this.tName = tName;
        this.project = proj+"/";
        this.transFolder = project+tName+"/";
        
        
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
        this.transFolder = project+tName+"/";
    }
    
    public void generateTransformedProject() throws Exception{
        File fProject = new File(project);
        File fTransf = new File(transFolder); fTransf.mkdir();
        File[] listOfFiles = fProject.listFiles();
        
        //Copy all the files to the new project folder
        for(File f : listOfFiles){
            //if(f.isDirectory()){
                if(!f.getName().equals(tName)){
                //    FileUtils.copyFolder(f, new File(transFolder+f.getName()));
                //}else if(f.getName().equals("src")){
                    //PASS THE FILES THROUGH THE PARSING AND INSTRUMENTATION TOOL
                    this.instrumentSource(f, new File(transFolder+f.getName()));
                }
            //}else if(f.isFile()){
            //    File aux = new File(transFolder+f.getName());
            //    aux.createNewFile();
            //    FileUtils.copyFile(f, aux);
            //}
        }
		/** ADD FILES */
		/*
		FileUtils.copyFolder(new File("D:\\JWrapper"), new File(transFolder+"JWrapper"));
		File raplRunner = new File(transFolder+"RaplRunner.java");
                raplRunner.createNewFile();
                FileUtils.copyFile(new File("D:\\RaplRunner.java"), raplRunner);
		*/
    }
    
    private void instrumentSource(File src, File dest) throws Exception{
        
    	if(src.isDirectory()){
    		//if directory not exists, create it
    		if(!dest.exists()){
    		   dest.mkdir();
    		}
 
    		//list all the directory contents
    		String files[] = src.list();
 
    		for (String file : files) {
    		   //construct the src and dest file structure
    		   File srcFile = new File(src, file);
    		   File destFile = new File(dest, file);
    		   //recursive transform
    		   instrumentSource(srcFile,destFile);
    		}
 
    	}else{
    		//if file, then transform it
                if(src.getAbsolutePath().endsWith(".java")){
                    String res = "";
                    //if(src.getAbsolutePath().contains(this.tests) || src.getAbsolutePath().replace('\\', '/').contains(this.tests)){
                        //res = transformTest(src.getAbsolutePath());
                    //}else{
                        res = transform(src.getAbsolutePath());
                    //}
                    if(!res.equals("")){
                        dest.createNewFile();
                        FileUtils.writeFile(dest, res);
                    }else{
                        dest.delete();
                    }
                    
                }else{
                    FileUtils.copyFile(src, dest);
                }
    	}
    }
    
    
    
    private String transform(String file) throws Exception {
        // creates an input stream for the file to be parsed
        FileInputStream in = new FileInputStream(file);
        System.out.println("Parsing & Instrumenting "+file);
        CompilationUnit cu;
        try {
            // parse the file
            cu = JavaParser.parse(in);
        } finally {
            in.close();
        }
        //ADD THE IMPORT OF THE STATIC ESTIMATOR
        //JWrapper
        ImportDeclaration imp2 = new ImportDeclaration(ASTHelper.createNameExpr("JWrapper.*"), false, false);
        if(cu.getImports() != null){
            cu.getImports().add(imp2);
        }else{
            cu.setImports(new LinkedList<ImportDeclaration>());
            cu.getImports().add(imp2);
        }
        // visit and print the methods names
        //new MethodVisitor().visit(cu, null);
        String pack = cu.getPackage() == null ? "" : cu.getPackage().getName().toString();
        String cl = cu.getTypes().get(0).getName();
        ClassDefs cDef = new ClassDefs();
        cDef.setName(cl); cDef.setPack(pack);

        // visit and change the methods names and parameters
        String classDec = cu.getTypes().get(0).getClass().getName();
        if(!classDec.contains("ClassOrInterfaceDeclaration")){
            return cu.toString();
        }
        ClassOrInterfaceDeclaration x = (ClassOrInterfaceDeclaration)cu.getTypes().get(0);
		
        if(!x.isInterface()){
            new MethodChangerVisitor().visit(cu, cDef);
        }
        if(cu != null){
            // prints the changed compilation unit
            //System.out.println(cu.toString());
        }
        return cu.toString();
    }
}
