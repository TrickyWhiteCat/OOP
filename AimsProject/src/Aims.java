package Lab02.AimsProject.src;

import DigitalVideoDisc;
import Cart;

public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);
        anOrder.addDigitalVideoDisc(new DigitalVideoDisc("Aladin", "Animation", 18.99f), new DigitalVideoDisc("Aladin", "Animation", 18.99f), new DigitalVideoDisc("Aladin", "Animation", 18.99f), new DigitalVideoDisc("Aladin", "Animation", 18.99f));
        anOrder.printCart();

        System.out.println(String.format("Total Cost is: %.2f", anOrder.totalCost()));

        System.out.println("Removing the 1st disc..");
        anOrder.removeDigitalVideoDisc(dvd1);

        anOrder.printCart();
    }
}