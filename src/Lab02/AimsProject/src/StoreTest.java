package Lab02.AimsProject.src;

public class StoreTest {
    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        Store store = new Store(new DigitalVideoDisc[] {dvd1, dvd2, dvd3});
        System.out.println(store.toString());

        System.out.println("\n Adding another dvd...");
        store.addDVD(dvd3);
        System.out.println(store.toString());

        System.out.println("\nRemoving another drive...");
        store.removeDVD(dvd1);
        System.out.println(store.toString());
        
    }
}
