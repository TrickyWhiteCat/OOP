package Lab01;

import javax.swing.JOptionPane;

public class Exercise61 {
    public static void main(String[] args) {
        int option = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticket?");
        JOptionPane.showMessageDialog(null, "You have chosen: "+ (option==JOptionPane.YES_OPTION ? "Yes":"No"));
    }
}