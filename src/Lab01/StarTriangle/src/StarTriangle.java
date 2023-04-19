package Lab01.StarTriangle.src;

import utils.input;
import java.util.Scanner;

public class StarTriangle {

    /**
     * Return a isosceles triangle of {@code}symbol{@code} where the lower row has 2 more elements compared to the upper row.
     * @param height : height of the trangle
     * @param symbol : the symbol to be used
     */
    public static String triangle(int height, String symbol) {
        int maxWidth = 2 * height + 1; // As every lower row has 2 more symbols, the last row will have the most number of symbols which equals to 2 * height + 1
        String res = "";

        // Create the triangle from the top
        for (int rowIdx = 0; rowIdx < height; rowIdx++) {
            int width = 2 * rowIdx + 1; // rowIdx in range [0, height - 1]
            int numSpace = (maxWidth - width) / 2;
            
            // Add spaces to the front
            for (int charIdx = 0; charIdx < numSpace; charIdx++) {
                res += " ";
            }

            // Add the symbols
            for (int charIdx = 0; charIdx < width; charIdx++) {
                res += symbol;
            }

            // Enough symbols has been added. Move to the next row
            res += (rowIdx == height - 1) ? "" : "\n"; // Don't add new line if it's the last line
        }

        return res;
    }
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        int height = input.getIntFromScanner(keyboard, System.out, "Enter the height of the triangle: ");
        System.out.print(triangle(height, "*"));
    }
}
