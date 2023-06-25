package hust.soict.dsai.aims.media;

import java.util.*;

public class MediaComparatorByTitleCost implements Comparator<Media>{
	@Override
	public int compare(Media o1, Media o2) {
		int titleComparing = o1.getTitle().compareTo(o2.getTitle());
		if (titleComparing != 0) {
			return titleComparing;
		}
		return Float.compare(o1.getCost(), o2.getCost());
	}
}