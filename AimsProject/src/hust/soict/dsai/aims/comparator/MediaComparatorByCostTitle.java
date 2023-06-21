package hust.soict.dsai.aims.comparator;

import hust.soict.dsai.aims.media.Media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        int costComparisonResult = (int) Math.signum(o1.getCost() - o2.getCost());
        return (costComparisonResult != 0 ? costComparisonResult : o1.getTitle().compareToIgnoreCase(o2.getTitle()));
    }
}
