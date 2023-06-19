package Lab01;

import java.util.Arrays;
import java.util.Scanner;

import utils.*;

public class Exercise226 {
    /**
     * Solve the equation a*x+b=0
     * @param a The coefficient.
     * @param b The constant.
     * @return A string representing the result of the equation.
     */
    public static String solveOneVarLinearEqn(double a, double b) {
        if (a == 0) {
            if (b == 0) { // 0*x + 0 = 0
                return "The equation has infinitely many solutions.";
            }
            return "The equation has no solution."; // 0*x + b = 0 (b!=0)
        }
        return String.format("The solution is %.3f", -b/a);
    }


    /**
     * Reduce an augmented matrix of the echelon form.
     * @param mat The input matrix.
     * @return The echelon matrix.
     * @throws IllegalArgumentException if the length of rows are not the same.
     */
    private static double[][] GaussJordan(double[][] mat) {
        // Check if `mat` is a vector instead of a matrix
        // If `mat` is a vector, we can just return it.
        if (mat.length == 1) { 
            return mat;
        }

        int colLength = mat.length;
        int rowLength = mat[0].length;

        matrixUtils.isMatrix(mat);// Check if the input is valid.

        // Find the row that has the least leading zeros elements
        int idxLeastZeros = 0; // The index of the aforementioned row
        int idxNonZeroElem = 0;
        int mostZeros = rowLength;
        for (int rowIdx = 0; rowIdx < mat.length; rowIdx++) {
            int countZeros = 0;
            for (int elemIdx = 0; elemIdx < rowLength; elemIdx++) {
                if (mat[rowIdx][elemIdx] == 0.0) {
                    countZeros++;
                    continue;
                }
                idxNonZeroElem = elemIdx;
                break;
            }
            if (countZeros == 0) { // There is a row without any zeros. It can be chosen as the pivot.
                idxLeastZeros = rowIdx;
                break;
            }
            if (countZeros < mostZeros) {
                idxLeastZeros = rowIdx;
                mostZeros = countZeros;
            }
        }

        // Choose the least leading zeros row as the pivot and substract others by it multiplies with a factor to makes a column full of zeros
        // Create a new matrix to contain the result of substractions
        double[][] sub = matrixUtils.zerosDouble2D(colLength - 1, rowLength); // Remove the pivot and the 0 column
        int newRowIdx = 0; // The row index of the new matrix
        for (int rowIdx = 0; rowIdx < colLength; rowIdx++) {
            if (rowIdx == idxLeastZeros) {
                continue;
            }

            double scalingFactor = mat[idxLeastZeros][idxNonZeroElem] / mat[rowIdx][idxNonZeroElem];
            
            // Perform the substractions and save the result to the new matrix
            for (int elemIdx = 0; elemIdx < rowLength; elemIdx++) {
                sub[newRowIdx][elemIdx] = mat[idxLeastZeros][elemIdx] - mat[rowIdx][elemIdx] * scalingFactor;
            }
            newRowIdx++;
        }

        // Perform Gaussian on the `res` matrix and merge its result and the pivot into a new matrix
        double[][] res = new double[colLength][rowLength];
        // Add the pivot to the top
        for (int elemIdx = 0; elemIdx < rowLength; elemIdx++) {
            res[0][elemIdx] = mat[idxLeastZeros][elemIdx];
        }

        double[][] reduced = GaussJordan(sub);
        for (int rowIdx = 1; rowIdx < colLength; rowIdx++) {
            for (int elemIdx = 0; elemIdx < rowLength; elemIdx++) {
                res[rowIdx][elemIdx] = reduced[rowIdx - 1][elemIdx];
            }
        }

        return res;
    }
    
    
    /**
     * Solve the system of N linear equations represented by {@code}Ax + b = 0{@code} where {@code}A{@code}} is a matrix (2D array) and {@code}b{@code} is a vector (1D array) by using gauss-jordan elimination.
     * @param A The matrix of coefficients.
     * @param b The vector of constants.
     * @return A string representing the solution of the system.
     * @throws IllegalArgumentException
     */
    public static String solveNVarsLinearEqn(double[][] A, double[] b) {
        int numEqns = A.length;
        if (b.length != numEqns) {
            throw new IllegalArgumentException(String.format("Too many values in `b` (%d) comparing to A (%d)", b.length, numEqns));
        }

        if (!matrixUtils.isMatrix(A)) {
            throw new IllegalArgumentException("`A` is not a valid matrix.");
        }

        int numVars = A[0].length;
        
        if (numVars > numEqns) {
            return "The system has infinitely many solutions.";
        }

        if (numEqns > numVars) {
            throw new IllegalArgumentException(String.format("There are more equations (%d) than variables (%d)", numEqns, numVars));
        }
        
        // Merge A and b into an augmented matrix
        double[][] aug = new double[numEqns][numVars + 1];

        // Copy A
        for (int i = 0; i < numEqns; i++) {
            for (int j = 0; j < numVars; j++) {
                aug[i][j] = A[i][j];
            }
        }

        // Copy b
        for (int i = 0; i < numEqns; i++) {
            aug[i][numVars] = b[i];
        }

        if (!matrixUtils.isEchelon(aug)) {
            aug = GaussJordan(aug);
        }
        double[] solution = new double[numVars];

        // Solve from the bottom up.
        for (int rowIdx = numEqns-1; rowIdx >= 0; rowIdx--) {

            // Find the first non zeros coefficient
            int firstNonZerosParam = numVars;
            for (int elemIdx = 0; elemIdx < numVars + 1; elemIdx++) {
                if (aug[rowIdx][elemIdx] != 0)  {
                    firstNonZerosParam = elemIdx;
                    break;
                }
            }
            if ((firstNonZerosParam == numVars) || (firstNonZerosParam < rowIdx)) { // The last row is full of zeros --> Infinitely many solutions. The 2nd condition means that we shouldn't have more variables than the number of equations.
                return "The system has infinitely many solutions.";
            }
            if (firstNonZerosParam == numVars) { // The last row is full of zeros except for the last element which is b[-1] --> No solution
                return "The system has no solution.";
            }

            // There should be a unique solution if the code below is reached.
            double sumKnownVars = 0; // The sum of known variables

            for (int knownVarIdx = firstNonZerosParam; knownVarIdx < numVars; knownVarIdx++) {
                sumKnownVars += solution[knownVarIdx] * aug[rowIdx][knownVarIdx];
            }

            solution[rowIdx] = -(aug[rowIdx][numVars] + sumKnownVars) / aug[rowIdx][rowIdx];
        }

        return String.format("The solution is %s", Arrays.toString(solution));
    }

    /**
     * Solve the system of 2 linear equations represented by {@code}Ax + b = 0{@code} where {@code}A{@code}} is a matrix (2D array) and {@code}b{@code} is a vector (1D array) by using gauss-jordan elimination.
     * @param A The matrix of coefficients.
     * @param b The vector of constants.
     * @return A string representing the solution of the system.
     * @throws IllegalArgumentException
     */
    public static String solve2VarsLinearEqn(double[][] A, double[] b)  {
        return solveNVarsLinearEqn(A, b);
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int numEqns = input.getIntFromScanner(keyboard, System.out, "Enter the number of equations: ");  
        int numVars = input.getIntFromScanner(keyboard, System.out,"Enter the number of variables: ");
        
        double[][] A = new double[numEqns][numVars];
        double[] b = new double[numEqns];

        for (int i = 0; i < numEqns; i++) {
            for (int j = 0; j < numVars; j++) {
                A[i][j] = input.getDoubleFromScanner(keyboard, System.out, String.format("Enter A_%d%d: ", i + 1, j + 1));
            }
        }

        for (int i = 0; i < numEqns; i++) {
            b[i] = input.getDoubleFromScanner(keyboard, System.out, String.format("Enter b_%d: ", i + 1));
        }

        System.out.print(solveNVarsLinearEqn(A, b));
    }
}