package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;

public class AimsGUI {
    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();
        store.addMedia(new DigitalVideoDisc("Wha", "Hai", 13));
        store.addMedia(new DigitalVideoDisc("Ans", "The", 17));
        store.addMedia(new DigitalVideoDisc("Boo", "Cha", 25.1));
        store.addMedia(new CompactDisc("Ahn", "Thu", 22.1));
        store.addMedia(new DigitalVideoDisc("Anx", "Tkx", 15.4));
        store.addMedia(new Track("Bon", "Cba", 32.1));
        store.addMedia(new Book("Bao", "Tru", 11.2));
        store.addMedia(new DigitalVideoDisc("Zoo", "Wah", 13.7));
        store.addMedia(new DigitalVideoDisc("Phy", "Aus", 21.4));


        System.out.print(store.getAllItems());
        new StoreScreen(store, cart);
    }

}
