package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

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

    public String cartDetail() {
        List<HashMap<String, String>> discsInfo = new ArrayList<>();
        int maxChar = 0;
        for (DigitalVideoDisc disk : this.itemsOrdered) {
            if (disk == null) continue;
            HashMap<String, String> info = disk.getDetail();
            discsInfo.add(info);
            int countChar = 0;
            // Get the total number of chars
            for (String val : info.values()) {
                if (val == null) {
                    continue;
                }
                countChar += val.length();
            }
            if (countChar > maxChar) {
                maxChar = countChar;
            }

        }
        String infoDelimiter = " - ";
        String decoSymbol = "*";
        int reportWidth = maxChar + infoDelimiter.length() * (discsInfo.get(0).size() - 2) + 12; // 3 for the index, 6 for the "DVD - ", 2 spaces for ": " and 1 for the currency symbol
        int leftTitle = (reportWidth - 6) / 2; // Minus the length of " CART "
        int rightTitle = reportWidth - leftTitle - 6; // Split into 2 vars to deal with the case where reportWidth is odd.

        // Create the array to contains lines of the report
        String[] report = new String[discsInfo.size() + 3]; // Plus 3 for the title, total cost and footer

        // The title
        String title = "";
        for (int i=0; i<leftTitle; i++) {
            title += decoSymbol;
        }
        title += " CART ";
        for (int i=0; i<rightTitle; i++) {
            title += decoSymbol;
        }
        report[0] = title;

        // Add discs info to the report
        for (int i = 0; i < discsInfo.size(); i++) {
            HashMap<String, String> info = discsInfo.get(i);
            String rep = String.format("%d. DVD - %s%s%s%s%s%s%s: %s$", i, info.get("Title"), infoDelimiter, info.get("Category"), infoDelimiter, info.get("Director"), infoDelimiter, info.get("Length"), info.get("Cost"));
            report[i+1] = rep;
        }
        report[report.length - 2] = String.format("Total cost: %.3f$", this.totalCost());
        String footer = "";
        for (int i=0; i<reportWidth; i++) {
            footer += decoSymbol;
        }
        report[report.length - 1] = footer;
        return String.join("\n", report);
    }

    public void printCart() {
        System.out.println(this.cartDetail());
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disk) {
        if (this.qtyOrdered == MAX_NUMBER_ORDERED) {
            System.out.println("The cart is full!");
            return;
        }

        this.itemsOrdered[qtyOrdered] = disk;
        this.qtyOrdered += 1;
        System.out.println(String.format("The disc %s was added to the cart.", disk.getDetail()));
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
                System.out.println(String.format("The disk %s doesn't exist in the cart.", disk.getDetail()));
                return;
            }
            if (this.itemsOrdered[i].equals(disk)) {
                // Remove the disk by replacing items from `i` by their successors.
                for (int j = i; j < this.qtyOrdered; j++) {
                    this.itemsOrdered[j] = this.itemsOrdered[j+1];
                }
                this.qtyOrdered --;        
                System.out.println(String.format("The disc %s was removed.", disk.getDetail()));
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
