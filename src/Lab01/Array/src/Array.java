package Lab01.Array.src;

import java.util.Arrays;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int length = keyboard.nextInt();
        int[] arr = new int[length];

        for (int idx = 0; idx < length; idx++) {
            arr[idx] = keyboard.nextInt();
        }
        keyboard.close();
        Arrays.sort(arr);
        int sum = 0;
        for (int elem : arr) {
            sum += elem;
        }
        System.out.println(String.format("The sum of the array is %d", sum));
        System.out.println(String.format("The average of the array is %.3f", (double)sum/(double)length));
    }
}
