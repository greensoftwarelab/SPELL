package sell;

public class Util {
    public static double[] getColumnFromMatrix(double[][] matrix, int columnWanted) {
        double[] column = new double[matrix.length];
        
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][columnWanted];
        }
        return column;
    }
}
