package hust.soict.dsai.aims.comparator;

import hust.soict.dsai.aims.media.Media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        int titleComparisonResult = o1.getTitle().compareToIgnoreCase(o2.getTitle());
        return (titleComparisonResult != 0 ? titleComparisonResult : (int) Math.signum(o1.getCost() - o2.getCost()));
    }
}
