package Lab02.AimsProject.src;

import java.util.HashMap;
import java.util.Map;

import Lab02.AimsProject.src.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBER_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered;
    private int qtyOrdered;

    public Cart() {
        this.itemsOrdered = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
        this.qtyOrdered = 0;
        System.out.println("The cart was created.");
    }

    public DigitalVideoDisc[] getCart() {
        return this.itemsOrdered;
    }

    public void printCart() {
        System.out.println(String.format("The cart currently contains %d discs: ", this.qtyOrdered));
        for (DigitalVideoDisc d: this.itemsOrdered) {
            if (d == null) {
                break;
            }
            System.out.println(d.getInformation());
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disk) {
        if (this.qtyOrdered == MAX_NUMBER_ORDERED) {
            System.out.println("The cart is full!");
            return;
        }

        this.itemsOrdered[qtyOrdered] = disk;
        this.qtyOrdered += 1;
        System.out.println(String.format("The disc %s was added to the cart.", disk.getInformation()));
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disk1, DigitalVideoDisc disk2) {
        this.addDigitalVideoDisc(disk1);
        this.addDigitalVideoDisc(disk2);
    }

    public void addDigitalVideoDisc(DigitalVideoDisc ... dvdList) {
        for (DigitalVideoDisc disk : dvdList) {
            this.addDigitalVideoDisc(disk);
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disk) {
        // Find the disk on the cart
        for (int i = 0; i < this.qtyOrdered; i++) {
            if (this.itemsOrdered[i] == null) {
                System.out.println(String.format("The disk %s doesn't exist in the cart.", disk.getInformation()));
                return;
            }
            if (this.itemsOrdered[i].equals(disk)) {
                // Remove the disk by replacing items from `i` by their successors.
                for (int j = i; j < this.qtyOrdered; j++) {
                    this.itemsOrdered[j] = this.itemsOrdered[j+1];
                }
                this.qtyOrdered --;        
                System.out.println(String.format("The disc %s was removed.", disk.getInformation()));
                return;
            }
        }
    }

    public double totalCost() {
        double total = 0;
        for (DigitalVideoDisc d: this.itemsOrdered) {
            if (d == null) {
                break;
            }
            total +=d.getCost();
        }
        return total;
    }

}
