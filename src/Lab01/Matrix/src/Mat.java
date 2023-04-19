package Lab01.Matrix.src;

import java.util.Scanner;

import utils.*;

public class Mat {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        double[][] matA = input.getDoubleMatrixFromScanner(keyboard, System.out);
        double[][] matB = input.getDoubleMatrixFromScanner(keyboard, System.out);
        output.print2DArray(matrixUtils.sum(matA, matB), System.out, " ");
    }
}
