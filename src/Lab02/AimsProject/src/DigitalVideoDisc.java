package Lab02.AimsProject.src;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private double cost;
    private int id;

    public static int nbDigitalVideoDisc = 0;
    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof DigitalVideoDisc)) {
            return false;
        }
        DigitalVideoDisc digitalVideoDisc = (DigitalVideoDisc) o;
        return Objects.equals(title, digitalVideoDisc.title) && Objects.equals(category, digitalVideoDisc.category) && Objects.equals(director, digitalVideoDisc.director) && length == digitalVideoDisc.length && cost == digitalVideoDisc.cost;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, category, director, length, cost);
    }

    
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDirector() {
        return this.director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public HashMap getInformation() {
        HashMap<String, String> info = new HashMap<>();
        info.put("Title", this.title);
        info.put("Category", this.category);
        info.put("Director", this.director);
        info.put("Length", String.valueOf(this.length));
        info.put("Cost", String.valueOf(this.cost));

        return info;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, double cost) {
        this.id = nbDigitalVideoDisc;
        this.nbDigitalVideoDisc++;
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }


    public DigitalVideoDisc(String title) {
        this.id = nbDigitalVideoDisc;
        this.nbDigitalVideoDisc++;
        this.title = title;
    }


    public DigitalVideoDisc(String category, String title, double cost) {
        this.id = nbDigitalVideoDisc;
        this.nbDigitalVideoDisc++;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public DigitalVideoDisc(String director, String category, String title, double cost) {
        this.id = nbDigitalVideoDisc;
        this.nbDigitalVideoDisc++;
        this.director = director;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public DigitalVideoDisc() {
        this.id = nbDigitalVideoDisc;
        this.nbDigitalVideoDisc++;
    }

    public static void main(String[] args) {
        DigitalVideoDisc diskA = new DigitalVideoDisc("Times", "new", "Meow", 15, 5.99);
        //diskA.setCategory("Meow");
        System.out.print(diskA.getInformation());
    }


}
