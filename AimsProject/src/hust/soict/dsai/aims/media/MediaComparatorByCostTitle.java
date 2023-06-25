package hust.soict.dsai.aims.media;

import java.util.*;

public class MediaComparatorByCostTitle implements Comparator<Media>{
	@Override
	public int compare(Media o1, Media o2) {
		if (o1.getCost() != o2.getCost())
			return Float.compare(o1.getCost(), o2.getCost());
		else{
			return o1.getTitle().compareTo(o2.getTitle());	
		}
}