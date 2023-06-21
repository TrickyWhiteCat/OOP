package hust.soict.dsai.aims.test.disc;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cindrellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cindrellaDVD);
        System.out.println("Jungle dvd's title: " + jungleDVD.getTitle());
        System.out.println("Cinderella dvd's title: " + cindrellaDVD.getTitle());

        changeTitle(jungleDVD, cindrellaDVD.getTitle());
        System.out.println("Jungle dvd's title: " + jungleDVD.getTitle());
    }

    public static void swap(DigitalVideoDisc d1, DigitalVideoDisc d2) {
        String oldCategory = d1.getCategory();
        double oldCost = d1.getCost();
        String oldDirector = d1.getDirector();
        int oldLength = d1.getLength();
        String oldTitle = d1.getTitle();

        d1.setCategory(d2.getCategory());
        d1.setCost(d2.getCost());
        d1.setDirector(d2.getDirector());
        d1.setLength(d2.getLength());
        d1.setTitle(d2.getTitle());

        d2.setCategory(oldCategory);
        d2.setCost(oldCost);
        d2.setDirector(oldDirector);
        d2.setLength(oldLength);
        d2.setTitle(oldTitle);
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
    }
}
