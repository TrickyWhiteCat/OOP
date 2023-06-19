package Lab01.JavaBasics.src;


import java.util.Scanner;

public class InputFromKeyboard {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("What's your name?");
        String strName = keyboard.nextLine();
        System.out.println("How old are you?");
        int iAge = keyboard.nextInt();
        System.out.println("How tall are you?");
        double dHeight = keyboard.nextDouble();
        keyboard.close();

        System.out.print(String.format("Mrs/Ms. %s, %d years old. Your height is %.2fcm.", strName, iAge, dHeight));
    }
}
