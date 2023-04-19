package utils;

import java.io.PrintStream;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class input {

    public static int getIntFromNewPane(String prompt) {
        try {
            return Integer.parseInt(JOptionPane.showInputDialog(prompt));
        }
        catch (NumberFormatException e) {
            String tryAgainMsg = "Wrong input. Please try again.\n";
            if (prompt.contains(tryAgainMsg)) {
                return getIntFromNewPane(prompt);
            }
            return getIntFromNewPane(String.format("%s%s", tryAgainMsg, prompt));
        }
    }

    public static double getDoubleFromNewPane(String prompt) {
        try {
            return Double.parseDouble(JOptionPane.showInputDialog(prompt));
        }
        catch (NumberFormatException e) {
            String tryAgainMsg = "Wrong input. Please try again.\n";
            if (prompt.contains(tryAgainMsg)) {
                return getDoubleFromNewPane(prompt);
            }
            return getDoubleFromNewPane(String.format("%s%s", tryAgainMsg, prompt));
        }
    }

    public static int getIntFromScanner(Scanner scan, PrintStream out, String prompt) {
        out.print(prompt);
        try {
            int res = Integer.parseInt(scan.nextLine());
            return res;
        }
        catch (NumberFormatException e) {
            String tryAgainMsg = "Wrong input. Please try again.\n";
            if (prompt.contains(tryAgainMsg)) {
                return getIntFromScanner(scan, out, prompt);
            }
            return getIntFromScanner(scan, out, String.format("%s%s", tryAgainMsg, prompt));
        }
    }

    public static double getDoubleFromScanner(Scanner scan, PrintStream out, String prompt) {
        out.print(prompt);
        try {
            double res = Double.parseDouble(scan.nextLine());
            return res;
        }
        catch (NumberFormatException e) {
            String tryAgainMsg = "Wrong input. Please try again.\n";
            if (prompt.contains(tryAgainMsg)) {
                return getDoubleFromScanner(scan, out, prompt);
            }
            return getDoubleFromScanner(scan, out, String.format("%s%s", tryAgainMsg, prompt));
        }
    }

    public static double[][] getDoubleMatrixFromScanner(Scanner scan, PrintStream out) {
        System.out.print("Enter the number of rows: ");
        int numRows = scan.nextInt();
        System.out.print("Enter the number of columns: ");
        int numCols = scan.nextInt();

        double[][] mat = new double[numRows][numCols];

        for (int rowIdx = 0; rowIdx < numRows; rowIdx++) {
            for (int colIdx = 0; colIdx < numCols; colIdx++) {
                mat[rowIdx][colIdx] = scan.nextDouble();
            }
        }

        return mat;
    }

    public static int[][] getIntMatrixFromScanner(Scanner scan, PrintStream out) {
        System.out.print("Enter the number of rows: ");
        int numRows = scan.nextInt();
        System.out.print("Enter the number of columns: ");
        int numCols = scan.nextInt();

        int[][] mat = new int[numRows][numCols];

        for (int rowIdx = 0; rowIdx < numRows; rowIdx++) {
            for (int colIdx = 0; colIdx < numCols; colIdx++) {
                mat[rowIdx][colIdx] = scan.nextInt();
            }
        }

        return mat;
    }

}
