package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cart {
    private final ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    private final FilteredList<Media> filtered = new FilteredList<Media>(itemsOrdered, null);
    private int qtyOrdered = 0;

    public Cart() {
        System.out.println("The cart was created.");
    }

    public ObservableList<Media> getCart() {
        return this.itemsOrdered;
    }

    public FilteredList<Media> getFilteredCart() {return this.filtered;}

    public String cartDetail() {
        List<HashMap<String, String>> mediaInfo = new ArrayList<>();
        int maxChar = 0;
        for (Media media : this.itemsOrdered) {
            if (media == null) continue;
            HashMap<String, String> info = media.getDetail();
            info.put("ClassName", media.getClass().getSimpleName());
            mediaInfo.add(info);
            int countChar = info.get("ClassName").length() + info.get("Title").length() + info.get("Category").length() + info.get("Cost").length();
            // Get the total number of chars
            if (countChar > maxChar) {
                maxChar = countChar;
            }

        }
        String infoDelimiter = " - ";
        String decoSymbol = "*";
        int delimiterTotalLength = 2 * infoDelimiter.length(); // Separate between ClassName and Title, Title and Category
        int reportWidth = maxChar + delimiterTotalLength + 6; // 3 for the index, 2 spaces for ": " and 1 for the currency symbol
        int leftTitle = (reportWidth - 6) / 2; // Minus the length of " CART "
        int rightTitle = reportWidth - leftTitle - 6; // Split into 2 vars to deal with the case where reportWidth is odd.

        // Create the array to contains lines of the report
        String[] report = new String[mediaInfo.size() + 3]; // Plus 3 for the title, total cost and footer

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
        for (int i = 0; i < mediaInfo.size(); i++) {
            HashMap<String, String> info = mediaInfo.get(i);
            String rep = String.format("%d. %s%s%s%s%s: %s$", i, info.get("ClassName"), infoDelimiter, info.get("Title"), infoDelimiter, info.get("Category"), info.get("Cost"));
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
        System.out.printf("The %s was added to the cart.%n", media.toString());
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
