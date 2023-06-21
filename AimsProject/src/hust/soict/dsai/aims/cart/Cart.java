package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cart {
    private final ArrayList<Media> itemsOrdered = new ArrayList<>();
    private int qtyOrdered = 0;

    public Cart() {
        System.out.println("The cart was created.");
    }

    public ArrayList<Media> getCart() {
        return this.itemsOrdered;
    }

    public String cartDetail() {
        List<HashMap<String, String>> discsInfo = new ArrayList<>();
        int maxChar = 0;
        for (Media media : this.itemsOrdered) {
            if (media == null) continue;
            HashMap<String, String> info = media.getDetail();
            discsInfo.add(info);
            int countChar = 0;
            // Get the total number of chars
            for (String val : info.values()) {
                if (val == null) {
                    countChar += 4; // The length of "null"
                }
                else {
                    countChar += val.length();
                }
            }
            if (countChar > maxChar) {
                maxChar = countChar;
            }

        }
        String infoDelimiter = " - ";
        String decoSymbol = "*";
        int delimiterTotalLength = (discsInfo.size() == 0) ? 0 : (discsInfo.get(0).size() - 2);
        int reportWidth = maxChar + infoDelimiter.length() * delimiterTotalLength + 12; // 3 for the index, 6 for the "DVD - ", 2 spaces for ": " and 1 for the currency symbol
        int leftTitle = (reportWidth - 6) / 2; // Minus the length of " CART "
        int rightTitle = reportWidth - leftTitle - 6; // Split into 2 vars to deal with the case where reportWidth is odd.

        // Create the array to contains lines of the report
        String[] report = new String[discsInfo.size() + 3]; // Plus 3 for the title, total cost and footer

        // The title
        String title = "";
        for (int i = 0; i < leftTitle; i++) {
            title += decoSymbol;
        }
        title += " CART ";
        for (int i = 0; i < rightTitle; i++) {
            title += decoSymbol;
        }
        report[0] = title;

        // Add discs info to the report
        for (int i = 0; i < discsInfo.size(); i++) {
            HashMap<String, String> info = discsInfo.get(i);
            String rep = String.format("%d. DVD - %s%s%s%s%s%s%s: %s$", i, info.get("Title"), infoDelimiter, info.get("Category"), infoDelimiter, info.get("Director"), infoDelimiter, info.get("Length"), info.get("Cost"));
            report[i + 1] = rep;
        }
        report[report.length - 2] = String.format("Total cost: %.3f$", this.totalCost());
        StringBuilder footer = new StringBuilder();
        for (int i = 0; i < reportWidth; i++) {
            footer.append(decoSymbol);
        }
        report[report.length - 1] = footer.toString();
        return String.join("\n", report);
    }

    public void printCart() {
        System.out.println(this.cartDetail());
    }

    public void addMedia(Media media) {

        if (this.itemsOrdered.contains(media)) {return;}

        this.itemsOrdered.add(media);
        this.qtyOrdered += 1;
        System.out.printf("The disc %s was added to the cart.%n", media.getDetail());
    }

    public void addMedia(Media media1, Media media2) {
        this.addMedia(media1);
        this.addMedia(media2);
    }

    public void addMedia(Media... mediaList) {
        for (Media media : mediaList) {
            this.addMedia(media);
        }
    }

    public void removeMedia(Media media) {
        // Find the media on the cart
        this.itemsOrdered.remove(media);
        this.qtyOrdered--;
    }

    public double totalCost() {
        double total = 0;
        for (Media d : this.itemsOrdered) {
            if (d == null) {
                continue;
            }
            total += d.getCost();
        }
        return total;
    }
}
