package hust.soict.dsai.aims.media;

import java.util.ArrayList;

import hust.soict.dsai.aims.exception.PlayerException;

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

    public CompactDisc(String artist, ArrayList<Track> tracks) {
		super();
		this.artist = artist;
		this.tracks = tracks;
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
    
    public void play() throws PlayerException {
    	if (this.getLength() > 0) {
    		System.out.println("Playing CD: " + this.getTitle());
            System.out.println("CD length: " + this.getLength());
            System.out.println("Tracks:");
    		java.util.Iterator iter = tracks.iterator();
    		Track nextTrack;
    		while (iter.hasNext()) {
    			nextTrack = (Track) iter.next();
    			try {
    				nextTrack.play();
    			}catch (PlayerException e){
    				throw e;
    			}
    		}
    	}
    	else {
    		throw new PlayerException("Error: CD length is non-positive!");
    	}
        
    }
}

