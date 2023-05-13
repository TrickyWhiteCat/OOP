package Lab02.AimsProject.src;

import java.util.HashMap;
import java.util.Map;

import Lab02.AimsProject.src.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBER_ORDERED = 20;
    private Map<DigitalVideoDisc, Integer> discs;

    public DigitalVideoDisc[] getCart() {
        return discs;
    }

    public Cart() {
        this.discs = new HashMap<>(MAX_NUMBER_ORDERED);
    }

    public void add(DigitalVideoDisc disk, int quantity) {
        // If the disk isn't in the cart
        if (discs.containsKey(disk)) {
            discs.put(disk, quantity);
        }
        else {
            System.out.print("Fue");
            discs.replace(disk, discs.get(disk) + 1);
        }
        
    }

}
