package hust.soict.dsai.aims.disc;

import hust.soict.dsai.aims.media.*;
import java.util.*;

public class Disc extends Media{
    private int length;
    private String director;
    
    public int getLength(){
        return length;
    }
    public String getDirector(){
        return director;
    }
    public Disc(){super();}
}