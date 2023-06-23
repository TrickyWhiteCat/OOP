package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class CompactDisc extends Media implements Playable{
    private String artist = null;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(String title, String category, double cost) {
        super(title, category, cost);
    }

    public CompactDisc(String title, String category, float cost, String artist, ArrayList<Track> tracks) {
        super(title, category, cost);
        this.artist = artist;
        this.tracks = tracks;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (this.tracks.contains(track)) {
            return;
        }
        this.tracks.add(track);
    }

    public void removeTrack(Track track) {
        this.tracks.remove(track);
    }

    public int getLength() {
        int totalLength = 0;
        for (Track track:
             this.tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CompactDisc that = (CompactDisc) o;

        if (!Objects.equals(artist, that.artist)) return false;
        return Objects.equals(tracks, that.tracks);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (artist != null ? artist.hashCode() : 0);
        result = 31 * result + (tracks != null ? tracks.hashCode() : 0);
        return result;
    }

    @Override
    public void play() {
        System.out.printf("Playing Compact Disc %s%n", this.getTitle());
        for (Track track:
             this.tracks) {
            track.play();
        }
    }
    @Override
    public HashMap<String, String> getDetail() {
        HashMap<String, String> info = super.getDetail();
        info.put("artist", artist);
        info.put("tracks", (tracks.size() == 0)  ? null : tracks.toString());
        return info;
    }
}
