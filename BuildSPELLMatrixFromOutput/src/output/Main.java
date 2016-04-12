package output;

import genericTree.Node;
import genericTree.Tree;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;

public class Main {

    public static void main(String[] args) throws Exception {
        String input =  "> funcao_A [ m = graph, t = 1, cpu=2.3 ]\n" +
                        "> funcao_E [ m = graph, t = 1, cpu=3.2 ]\n" +
                        "< funcao_E [ m = graph, t = 5, cpu=3.3 ]\n" +
                        "< funcao_A [ m = graph, t = 5, cpu=4.3 ]\n" +
                        "> funcao_A [ m = graph, t = 1, cpu=2.3 ]\n" +
                        "> funcao_E [ m = graph, t = 1, cpu=3.2 ]\n" +
                        "< funcao_E [ m = graph, t = 5, cpu=3.3 ]\n" +
                        "> funcao_E [ m = graph, t = 1, cpu=3.2 ]\n" +
                        "< funcao_E [ m = graph, t = 5, cpu=3.3 ]\n" +
                        "< funcao_A [ m = graph, t = 5, cpu=4.3 ]\n";
        String f = "1";
        String filePath = args.length > 0 ? args[0] : "/home/states/Desktop/repos/green-lab/work/Spell/"+f+".outputspell";
        //OutputLexer lexer = new OutputLexer(new ANTLRStringStream(input));
        OutputLexer lexer = new OutputLexer(new ANTLRInputStream(new FileInputStream(filePath)));
        OutputParser parser = new OutputParser(new CommonTokenStream(lexer),0,12);
        List<Tree<ComponentNode>> multipleTests = parser.output();
        
        OutputWorker outputWorker = new OutputWorker();
        outputWorker.setTests(multipleTests);
        String outputMatrix = outputWorker.generateOutput();
        //Write to file
        PrintWriter writer = new PrintWriter("../"+f+".spell","UTF-8");
        writer.print(outputMatrix);
        writer.close();
        System.out.println(outputMatrix);
        System.out.println(outputWorker.generateComponentNames());
        //outputWorker.prettyPrintTree();
        //outputWorker.getTests().get(1).prettyPrintTree();
        //tree.prettyPrintTree();
    }
    
}
