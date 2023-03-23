package utils;

import java.io.PrintStream;

public class output {
    public static void print2DArray(int[][] arr, PrintStream outStream, String delimiter) {
        for (int rowIdx = 0; rowIdx < arr.length; rowIdx++) {
            for (int elemIdx = 0; elemIdx < arr[rowIdx].length; elemIdx++) {
                outStream.printf("%d%s", arr[rowIdx][elemIdx], delimiter);
            }
            outStream.println();
        }
    }

    public static void print2DArray(double[][] arr, PrintStream outStream, String delimiter) {
        for (int rowIdx = 0; rowIdx < arr.length; rowIdx++) {
            for (int elemIdx = 0; elemIdx < arr[rowIdx].length; elemIdx++) {
                outStream.printf("%f%s", arr[rowIdx][elemIdx], delimiter);
            }
            outStream.println();
        }
    }

}
