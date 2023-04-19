package utils;


public class matrixUtils {
    public static double[][] zerosDouble2D(int numRow, int numCol) {
        double[][] res = new double[numRow][numCol];
        for (int i = 0; i < numRow; i++) {
            for (int j = 0; j < numCol; j++) {
                res[i][j] = 0.0;
            }
        }
        return res;
    }

    public static int[][] zerosInt2D(int numRow, int numCol) {
        int[][] res = new int[numRow][numCol];
        for (int i = 0; i < numRow; i++) {
            for (int j = 0; j < numCol; j++) {
                res[i][j] = 0;
            }
        }
        return res;
    }

    public static boolean isMatrix(double[][] mat) {
        int colLength = mat.length;

        // Check for consistency of the length of rows
        int rowLength = mat[0].length;
        for (int rowIdx = 1; rowIdx < colLength; rowIdx++) {
            if (mat[rowIdx].length != rowLength) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEchelon(double[][] mat) {
        if (!isMatrix(mat)) {
            return false;
        }

        int maxCountZeros = 0;
        for (int i = 0; i < mat.length; i++) {
            int countZeros = 0;
            for (int j = 0; j < mat[0].length; j ++) {
                if (mat[i][j] != 0) {
                    break;
                }
                countZeros++;
            }
            if (countZeros <= maxCountZeros) {
                return false;
            }
            maxCountZeros = countZeros;
        }
        return true;
    }

    /**
     * Return the sum of 2 matrices
     * @param matA
     * @param matB
     * @throws IllegalArgumentException if either matrix is invalid or not in the same shape.
     */
    public static double[][] sum(double[][] matA, double[][] matB) {

        // Validation
        if (!isMatrix(matA) || !isMatrix(matB)) throw new IllegalArgumentException("Invalid input!");
        if ((matA.length != matB.length) || (matA[0].length != matB[0].length)) throw new IllegalArgumentException("Shape mismatch!");

        double[][] res = new double[matA.length][matA[0].length]; // An array to store the result
        for (int i = 0; i < matA.length; i++) {
            for (int j = 0; j < matA[0].length; j++) {
                res[i][j] = matA[i][j] + matB[i][j];
            }
        }

        return res;
    }

    /**
     * Substract 2 matrices
     * @param matA
     * @param matB
     * @throws IllegalArgumentException if either matrix is invalid or not in the same shape.
     */
    public static double[][] substrct(double[][] matA, double[][] matB) {

        // Validation
        if (!isMatrix(matA) || !isMatrix(matB)) throw new IllegalArgumentException("Invalid input!");
        if ((matA.length != matB.length) || (matA[0].length != matB[0].length)) throw new IllegalArgumentException("Shape mismatch!");

        double[][] res = new double[matA.length][matA[0].length]; // An array to store the result
        for (int i = 0; i < matA.length; i++) {
            for (int j = 0; j < matA[0].length; j++) {
                res[i][j] = matA[i][j] - matB[i][j];
            }
        }

        return res;
    }

    /**
     * Perform the element-wise multiplication of 2 matrices
     * @param matA
     * @param matB
     * @throws IllegalArgumentException if either matrix is invalid or not in the same shape.
     */
    public static double[][] multiply(double[][] matA, double[][] matB) {

        // Validation
        if (!isMatrix(matA) || !isMatrix(matB)) throw new IllegalArgumentException("Invalid input!");
        if ((matA.length != matB.length) || (matA[0].length != matB[0].length)) throw new IllegalArgumentException("Shape mismatch!");

        double[][] res = new double[matA.length][matA[0].length]; // An array to store the result
        for (int i = 0; i < matA.length; i++) {
            for (int j = 0; j < matA[0].length; j++) {
                res[i][j] = matA[i][j] * matB[i][j];
            }
        }

        return res;
    }

}
