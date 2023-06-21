package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Book extends Media {
    private List<String> authors = new ArrayList();


    public Book(String title, String category, double cost, List<String> authors) {
        super(title, category, cost);
        this.authors = authors;
    }

    public Book(String title, String category, double cost) {
        super(title, category, cost);
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String author) {
        if (this.authors.contains(author)) {
            return;
        }
        this.authors.add(author);
    }

    public void removeAuthor(String author) {
        this.authors.remove(author); // Automatically check if the author exists and only remove if exists.
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Book book = (Book) o;

        return Objects.equals(authors, book.authors);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (authors != null ? authors.hashCode() : 0);
        return result;
    }
    @Override
    public HashMap<String, String> getDetail() {
        HashMap<String, String> info = super.getDetail();
        info.put("authors", authors.toString());
        return info;
    }

    @Override
    public void play() {

    }
}
