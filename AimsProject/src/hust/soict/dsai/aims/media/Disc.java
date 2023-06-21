package hust.soict.dsai.aims.media;

import java.util.HashMap;
import java.util.Objects;

public class Disc extends Media{
    private int length;
    private String director;

    public Disc() {
        super();
    }

    public Disc(String title) {
        super(title);
    }

    public Disc(int length, String director) {
        super();
        this.length = length;
        this.director = director;
    }

    public Disc(String title, int length, String director) {
        super(title);
        this.length = length;
        this.director = director;
    }

    public Disc(String title, String category, double cost, int length, String director) {
        super(title, category, cost);
        this.length = length;
        this.director = director;
    }

    public Disc(String title, String category, double cost) {
        super(title, category, cost);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Disc disc = (Disc) o;

        if (length != disc.length) return false;
        return Objects.equals(director, disc.director);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + length;
        result = 31 * result + (director != null ? director.hashCode() : 0);
        return result;
    }

    @Override
    public HashMap<String, String> getDetail() {
        HashMap<String, String> info = super.getDetail();
        info.put("director", director);
        info.put("length", String.valueOf(length));
        return info;
    }

    @Override
    public void play() {
        System.out.println("Playing disk: " + this.getTitle());
        System.out.println("disk length: " + this.getLength());
    }
}
