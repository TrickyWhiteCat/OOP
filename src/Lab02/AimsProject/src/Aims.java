package Lab02.AimsProject.src;

import DigitalVideoDisc;
import Cart;

public class Aims {
    public static void main(String[] args) {
        DigitalVideoDisc disk = new DigitalVideoDisc();
        System.out.print(disk.getInformation().toString());
        Cart c = new Cart();
        c.add(disk, 5);
        System.out.print(c);
    }
}
