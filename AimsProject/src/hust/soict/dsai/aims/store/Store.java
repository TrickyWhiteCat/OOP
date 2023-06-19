package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    private DigitalVideoDisc[] itemsInStore;
    private int numItems = 0;
    private String name = null;
    public Store() {
        this.itemsInStore = new DigitalVideoDisc[0];
    }
    public Store(DigitalVideoDisc[] itemsInStore) {
        this.itemsInStore = itemsInStore;
        this.numItems = itemsInStore.length;
    }

    public Store(DigitalVideoDisc[] itemsInStore, String name) {
        this.itemsInStore = itemsInStore;
        this.name = name;
    }

    public void addDVD(DigitalVideoDisc dvd) {
        if (this.itemsInStore.length == numItems) {
            // Make a new list with 1 more capacty.
            DigitalVideoDisc[] newList = new DigitalVideoDisc[this.numItems + 1];
            for (int i = 0; i < this.numItems; i++) {
                newList[i] = this.itemsInStore[i];
            }
            this.itemsInStore = newList;
        this.itemsInStore[this.numItems] = dvd;
        this.numItems += 1;

        }
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        // Find the disk on the store
        for (int i = 0; i < this.numItems; i++) {
            if (this.itemsInStore[i] == null) {
                System.out.println(String.format("The disk %s doesn't exist in the store.", dvd.getDetail()));
                return;
            }
            if (this.itemsInStore[i].equals(dvd)) {
                // Remove the disk by replacing items from `i` by their successors.
                for (int j = i; j < this.numItems - 1; j++) {
                    this.itemsInStore[j] = this.itemsInStore[j+1];
                }
                this.numItems--;        
                System.out.println(String.format("The disc %s was removed.", dvd.getDetail()));
                return;
            }
        }
    }

    public DigitalVideoDisc[] getAllItems() {
        return this.itemsInStore;
    }

    public String toString() {
        String title = String.format("Store %s", this.name);
        String subtitle = String.format("Number of items in the store: %d", this.numItems);
        String[] info = new String[this.numItems + 2];
        info[0] = title;
        info[1] = subtitle;
        for (int i = 0; i < this.numItems; i++) {
            info[i+2] = this.itemsInStore[i].getDetail().toString();
        }
        return String.join("\n", info);
    }
}
