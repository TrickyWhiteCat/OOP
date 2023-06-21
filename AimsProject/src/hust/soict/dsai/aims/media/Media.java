package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.comparator.MediaComparatorByCostTitle;
import hust.soict.dsai.aims.comparator.MediaComparatorByTitleCost;

import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

public abstract class Media implements Playable {
    private static int numMedia = 0;
    private final int id = numMedia;
    private String title;
    private String category;
    private double cost;
    private final Date addedDate = new Date();

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public Media() {
    }

    public Media(String title) {
        this.title = title;
    }

    public Media(String title, String category, double cost) {
        numMedia++;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public static int getNumMedia() {
        return numMedia;
    }

    public static void setNumMedia(int numMedia) {
        Media.numMedia = numMedia;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Date getAddedDate() {
        return addedDate;
    }
    public HashMap<String, String> getDetail() {
        HashMap<String, String> info = new HashMap<>();
        info.put("Title", this.getTitle());
        info.put("Category", this.getCategory());
        info.put("Cost", String.format("%.3f", this.getCost()));
        return info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Media media = (Media) o;
        if (media.id == this.id) return true;
        return Objects.equals(title, media.title);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + addedDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + getDetail().toString();
    }
}
