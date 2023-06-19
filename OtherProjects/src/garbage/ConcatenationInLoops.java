package garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ConcatenationInLoops {
    public static String ConcatWithPlusOperator(String filename) {
        byte[] inputBytes = {0};
        long startTime, endTime;
        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        }
        catch (IOException e) {
            System.out.print(String.format("File %s doesn't exist.", filename));
        }
        startTime = System.currentTimeMillis();
        String outputString = "";
        for (byte b : inputBytes) {
            outputString += (char) b;
        }
        endTime = System.currentTimeMillis();
        System.out.println(String.format("Execution time: %d ms", endTime - startTime));
        return outputString;
    }

    public static String ConcatWithStringBuffer(String filename) {
        byte[] inputBytes = {0};
        long startTime, endTime;
        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        }
        catch (IOException e) {
            System.out.print(String.format("File %s doesn't exist.", filename));
        }
        startTime = System.currentTimeMillis();
        StringBuilder outputStringBuilder = new StringBuilder();
        for (byte b : inputBytes) {
            outputStringBuilder.append((char) b);
        }
        endTime = System.currentTimeMillis();
        System.out.println(String.format("Execution time: %d ms", endTime - startTime));
        return outputStringBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a file path: ");
        String filename = keyboard.nextLine();
        keyboard.close();
        System.out.print("Concatenating using Plus operator...");
        ConcatWithPlusOperator(filename);
        System.out.print("Concatenating using String Builder...");
        ConcatWithStringBuffer(filename);
    }
}
