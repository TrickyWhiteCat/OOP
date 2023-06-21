package hust.soict.dsai.aims.media;

import java.util.HashMap;
public class Track extends Media implements Playable{
    private int length;

    public Track(String title, String category, double cost) {
        super(title, category, cost);
    }

    public Track(String title, String category, double cost, int length) {
        super(title, category, cost);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Track track = (Track) o;

        return length == track.length;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + length;
        return result;
    }

    @Override
    public HashMap<String, String> getDetail() {
        HashMap<String, String> info = super.getDetail();
        info.put("length", String.valueOf(length));
        return info;
    }
}