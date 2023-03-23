package Lab01;

import utils.input;

import javax.swing.JOptionPane;

public class Exercise225 {
    public static void main(String[] args) {
        double first = input.getDoubleFromNewPane("Enter the first number");
        double second = input.getDoubleFromNewPane("Enter the second number");
        String[] messege = new String[] {String.format("Sum: %.3f", first + second),
                                         String.format("Difference: %.3f", first - second),
                                         String.format("Product: %.3f", first * second),
                                         String.format("Quotient: %.3f", first / second)};
        JOptionPane.showMessageDialog(null, String.join("\n", messege));
    }
}
