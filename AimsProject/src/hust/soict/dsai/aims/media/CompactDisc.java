package hust.soict.dsai.aims.media;

import java.util.ArrayList;

import hust.soict.dsai.aims.disc.*;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks;
    public CompactDisc(String artist) {
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }
    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("The track is already in the CD.");
        } else {
            tracks.add(track);
        }
    }

    public void removeTrack(Track track) {
        if (tracks.remove(track)) {
            System.out.println("The track has been removed from the CD.");
        } else {
            System.out.println("The track was not found in the CD.");
        }
    }

    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());
        System.out.println("Tracks:");
        for (Track track : tracks) {
            track.play();
        }
    }
}

