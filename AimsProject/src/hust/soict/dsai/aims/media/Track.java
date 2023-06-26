package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable{
    private String title = "";
    private int length = 0;
    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    public boolean equals(Track track){
        return this.getTitle() == track.getTitle() & this.getLength() == track.getLength();
    }
    public void play() throws PlayerException{
    	if (this.getLength() > 0) {
    		System.out.println("Playing DVD: "+this.getTitle());
            System.out.println("DVD length: "+this.getLength()); 
    	}
    	else {
    		throw new PlayerException("Error: Track length is non-positive!");
    	}
        
    }
    
    
}