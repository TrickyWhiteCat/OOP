package hust.soict.dsai.aims.test.store;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

import java.util.Collections;
import java.util.List;

public class StoreTest {
    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        Book b1 = new Book("Meow", "Fiction", 99.3,(List.of("Lhyn","Meo")));

        Store store = new Store();
        System.out.println(store.getAllItems());

        System.out.println("\n Adding another media...");
        store.addMedia(dvd3, dvd1, dvd2, b1);
        System.out.println(store.getAllItems());
        System.out.println("\n Sorting the store..");
        Collections.sort(store.getAllItems(), Media.COMPARE_BY_COST_TITLE);
        System.out.println(store.getAllItems());

        System.out.println("\nRemoving another media...");
        store.removeMedia(dvd1);
        System.out.println(store.getAllItems());

    }
}
