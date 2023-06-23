/**
package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aims {

    public static int showMenu(Scanner inputScanner) {
        while (true) { // Automatically let the user choose again until an appropriate choice is chosen.
            try {
                System.out.println("AIMS: ");
                System.out.println("--------------------------------");
                System.out.println("1. View store");
                System.out.println("2. Update store");
                System.out.println("3. See current cart");
                System.out.println("0. Exit");
                System.out.println("--------------------------------");
                System.out.println("Please choose a number: 0-1-2-3: ");
                System.out.print("> ");
                return Integer.parseInt(inputScanner.nextLine());
            } catch (NumberFormatException e) {
            }
        }
    }

    public static void storeMenu(Scanner inputScanner, Store store, Cart cart) {
        int nextChoice;
        while (true) { // Automatically let the user choose again until an appropriate choice is chosen.
            try {
                System.out.println(showMediaArrayList(store.getAllItems()));
                System.out.println("Options: ");
                System.out.println("--------------------------------");
                System.out.println("1. See a media’s details");
                System.out.println("2. Add a media to cart");
                System.out.println("3. Play a media");
                System.out.println("4. See current cart");
                System.out.println("0. Exit");
                System.out.println("--------------------------------");
                System.out.println("Please choose a number: 0-1-2-3-4");
                System.out.print("> ");
                nextChoice = Integer.parseInt(inputScanner.nextLine());

                int choice;
                switch (nextChoice) {
                    case 0:
                        return;
                    case 1:
                        System.out.print("Enter the index of the media: ");
                        choice = inputScanner.nextInt();
                        System.out.println(store.getAllItems().get(choice).toString());
                        break;
                    case 2:
                        System.out.print("Enter the index of the media: ");
                        choice = inputScanner.nextInt();
                        cart.addMedia(store.getAllItems().get(choice));
                        break;
                    case 3:
                        System.out.print("Enter the index of the media: ");
                        choice = inputScanner.nextInt();
                        store.getAllItems().get(choice).play();
                        break;
                    case 4:
                        cartMenu(inputScanner, cart);
                        break;
                }
            } catch (NumberFormatException e) {
            }
        }
    }

    public static void cartMenu(Scanner inputScanner, Cart cart) {
        int nextChoice;
        while (true) { // Automatically let the user choose again until an appropriate choice is chosen.
            try {
                cart.printCart();
                System.out.println("Options: ");
                System.out.println("--------------------------------");
                System.out.println("1. Filter medias in cart");
                System.out.println("2. Sort medias in cart");
                System.out.println("3. Remove media from cart");
                System.out.println("4. Play a media");
                System.out.println("5. Place order");
                System.out.println("0. Exit");
                System.out.println("--------------------------------");
                System.out.println("Please choose a number: 0-1-2-3-4-5");
                System.out.print("> ");
                nextChoice = Integer.parseInt(inputScanner.nextLine());

                int choice;
                switch (nextChoice) {
                    case 0:
                        return;
                    case 1:
                        System.out.print("Filter by title? (Y/N): ");
                        boolean byTitle = inputScanner.nextLine().equalsIgnoreCase("y");
                        System.out.printf("Enter the %s: ", byTitle ? "title" : "ID");
                        String key = inputScanner.nextLine();
                        ArrayList<Media> filtered = filterByTitleID(cart.getCart(), byTitle, key);
                        System.out.println((filtered.size() == 0) ? "No media found." : showMediaArrayList(filtered));
                        break;
                    case 2:
                        System.out.print("Enter the index of the media: ");
                        choice = inputScanner.nextInt();
                        cart.removeMedia(cart.getCart().get(choice));
                        break;
                    case 3:
                        System.out.print("Enter the index of the media: ");
                        choice = inputScanner.nextInt();
                        cart.getCart().get(choice).play();
                        break;
                    case 4:
                        System.out.println("Your order has been placed.");
                }
            } catch (NumberFormatException e) {
            }
        }
    }

    private static String showMediaArrayList(ArrayList<Media> arr) {
        String[] res = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            res[i] = (String.format("%d. ", i) + arr.get(i).toString());
        }
        return String.join("\n", res);
    }
    public static void addRemoveMedia(Scanner inputScanner, Store store) {
        System.out.print("Do you want to add or remove a media? (add, remove): ");
        boolean toBeAdded = inputScanner.nextLine().equals("add");
        System.out.print("Enter the type (book, compactdisc, dvd, track): ");
        String type = inputScanner.nextLine();
        System.out.print("Enter the title: ");
        String title = inputScanner.nextLine();
        System.out.print("Enter the category: ");
        String category = inputScanner.nextLine();
        System.out.print("Enter the cost: ");
        double cost = inputScanner.nextDouble();

        if (toBeAdded) {
            Media newMedia;
            switch (type) {
                case "book":
                    newMedia = new Book(title, category, cost);
                    break;
                case "compactdisc":
                    newMedia = new CompactDisc(title, category, cost);
                    break;
                case "dvd":
                    newMedia = new DigitalVideoDisc(title, category, cost);
                    break;
                case "track":
                    newMedia = new Track(title, category, cost);
                    break;
                default:
                    throw new IllegalArgumentException(String.format("Argument %s is not accepted.", type));
            }
            store.addMedia(newMedia);
            return;
        }

        // Remove a media
        for (Media m :
                store.getAllItems()) {
            if (m.getCost() == cost
                    && m.getTitle().equals(title) // Remove " and "
                    && m.getCategory().equals(category)) {  // Remove " and "
                store.removeMedia(m);
            }
        }
    }

    public static ArrayList<Media> filterByTitleID(ArrayList<Media> arr, boolean byTitle, String key) {
        ArrayList<Media> filtered = new ArrayList<>();
        for (Media m :
                arr) {
            if (byTitle) {
                if (m.getTitle().equals(key)) {
                    filtered.add(m);
                }
            }
            else {
                if (m.getId() == Integer.parseInt(key)) {
                    filtered.add(m);
                }
            }
        }
        return filtered;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Store store = new Store(new ArrayList<>(List.of(new DigitalVideoDisc("Rando", "Wha", 15))));
        Cart cart = new Cart();
        while (true) {
            int nextChoice = showMenu(keyboard);
            switch (nextChoice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    storeMenu(keyboard, store, cart);
                    break;
                case 2:
                    addRemoveMedia(keyboard, store);
                    break;
                case 3:
                    cartMenu(keyboard, cart);
                default:
                    throw new IllegalStateException("Unexpected value: " + nextChoice);
            }
        }
    }
}**/