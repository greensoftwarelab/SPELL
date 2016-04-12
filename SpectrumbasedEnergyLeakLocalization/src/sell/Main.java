package sell;

import java.io.FileInputStream;
import java.math.BigDecimal;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import sell.input.DataRetrieved;
import sell.input.SemanticsCheck;

public class Main {
    private static final int ROUND_SCALE = 4;

    public static void main(String[] args) throws Exception {
        String input = "[ [ cpu = 37, n = 1, t = 75 ] [ cpu = 61, n = 2, t = 102 ] _ [ cpu = 42, n = 1, t = 34 ] ]\n" +
"[ [ cpu = 38, n = 3, t = 77 ] [ cpu = 50, n = 1, t = 103 ] [ cpu = 34, n = 2, t = 42 ] [ cpu = 44, n = 1, t = 37 ] ]\n" +
"[ [ cpu = 36, n = 1, t = 73 ] [ cpu = 58, n = 1, t = 102 ] [ cpu = 35, n = 1, t = 43 ] _ ]\n" +
"[ [ cpu = 37, n = 3, t = 74 ] [ cpu = 66, n = 2, t = 105 ] _ [ cpu = 61, n = 2, t = 43 ] ]\n" +
"[ [ cpu = 39, n = 2, t = 75 ] [ cpu = 54, n = 3, t = 100 ] [ cpu = 51, n = 4, t = 60 ] [ cpu = 65, n = 2, t = 60 ] ]";
        //MatrixLexer lexer = new MatrixLexer(new ANTLRStringStream(input));
        String filePath = args.length > 0 ? args[0] : "fixed.path.to.file";
        MatrixLexer lexer = new MatrixLexer(new ANTLRInputStream(new FileInputStream(filePath)));
        MatrixParser parser = new MatrixParser(new CommonTokenStream(lexer));
        DataRetrieved data = parser.parse();
        
        SemanticsCheck.checkSemantics(data);
        ComponentSample[][] matrix = data.getComponentsMatrix();
        SPELLAnalysis sPELLAnalysis = new SPELLAnalysis(new ComponentsSimilarity(), new OracleVectorConstruction(), new ComponentsGlobalSimilarity(), new JaccardSimilarityCoefficient());
        sPELLAnalysis.setMatrix(matrix);
        sPELLAnalysis.analyzeEnergyValues();
        
        System.out.println("Oracle");
        printOracleVector(sPELLAnalysis.getOracleVector()); 
        System.out.println("----------");
        System.out.println("Similarity");
        printSimilarityByComponents(sPELLAnalysis.getSimilarityComponentVector());
        System.out.println("----------");
        System.out.println("Global Similarity");
        printGlobalSimilarityByComponents(sPELLAnalysis.getComponentsGlobalSimilarityVector());
    }
    
    private static void printOracleVector(ComponentSample[] oracleVector) {
        for (int i = 0; i < 3; i++) {
            for (ComponentSample component : oracleVector) {
                switch (i) {
                    case 0:
                        System.out.print("("+BigDecimal.valueOf(component.getPowerConsumption().getCpu()).setScale(ROUND_SCALE, BigDecimal.ROUND_HALF_UP)+") ");
                        break;
                    case 1:
                        System.out.print("("+BigDecimal.valueOf(component.getNumberOfTimesUsed()).setScale(ROUND_SCALE, BigDecimal.ROUND_HALF_UP)+") ");
                        break;
                    default:
                        System.out.print("("+BigDecimal.valueOf(component.getTime()).setScale(ROUND_SCALE, BigDecimal.ROUND_HALF_UP)+") ");
                        break;
                }
            }
            System.out.println();
        }
    }
    
    private static void printSimilarityByComponents(ComponentSimilarity[] similarityVector) {
        int cNum = 1;
        for (int i = 0; i < 4; i++) {
            for (ComponentSimilarity componentSimilarity : similarityVector) {
                
                switch (i) {
                    case 0:
                        if(cNum<10)
                            System.out.print("   C"+cNum+"    ");
                        else if(cNum<100)
                            System.out.print("   C"+cNum+"   ");
                        else
                            System.out.print("   C"+cNum+"  ");
                        cNum++;
                        break;
                    case 1:
                        System.out.print("("+BigDecimal.valueOf(componentSimilarity.getPowerSimilarity().getCpu()).setScale(ROUND_SCALE, BigDecimal.ROUND_HALF_UP)+") ");
                        break;
                    case 2:
                        System.out.print("("+BigDecimal.valueOf(componentSimilarity.getCardinalitySimilarity()).setScale(ROUND_SCALE, BigDecimal.ROUND_HALF_UP)+") ");
                        break;
                    default:
                        System.out.print("("+BigDecimal.valueOf(componentSimilarity.getTimeSimilarity()).setScale(ROUND_SCALE, BigDecimal.ROUND_HALF_UP)+") ");
                        break;
                }
            }
            System.out.println();
        }
    }
    
    private static void printGlobalSimilarityByComponents(double[] values) {
        
        int cNum=1;
        for (double value : values) {
            if(cNum<10)
                System.out.print("  C"+cNum+"   ");
            else if(cNum<100)
                System.out.print("  C"+cNum+"  ");
            else
                System.out.print("  C"+cNum+" ");
            cNum++;
                      
        }
        System.out.println();
          for (double value : values) {
            System.out.print(BigDecimal.valueOf(value).setScale(ROUND_SCALE, BigDecimal.ROUND_HALF_UP)+" ");
        }
        System.out.println();
    }
}
