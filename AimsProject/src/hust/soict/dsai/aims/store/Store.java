package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();
    private int numItems = 0;
    private String name = null;

    public Store() {
    }

    public Store(ArrayList<Media> itemsInStore) {
        this.itemsInStore = itemsInStore;
        this.numItems = itemsInStore.size();
    }

    public Store(ArrayList<Media> itemsInStore, String name) {
        this.itemsInStore = itemsInStore;
        this.numItems = itemsInStore.size();
        this.name = name;
    }

    public void addMedia(Media media) {
        if (this.itemsInStore.contains(media)) {return;}
        this.itemsInStore.add(media);
    }

    public void addMedia(Media ... media) {
        for (Media m:
             media) {
            addMedia(m);
        }
    }

    public void removeMedia(Media media) {
        this.itemsInStore.remove(media);
    }

    public ArrayList<Media> getAllItems() {
        return this.itemsInStore;
    }

    public String toString() {
        String title = String.format("Store %s", this.name);
        String subtitle = String.format("Number of items in the store: %d", this.numItems);
        String[] info = new String[this.numItems + 2];
        info[0] = title;
        info[1] = subtitle;
        for (int i = 0; i < this.numItems; i++) {
            info[i + 2] = this.itemsInStore.get(i).getDetail().toString();
        }
        return String.join("\n", info);
    }
}
