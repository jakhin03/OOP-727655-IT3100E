package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
    
    private List<String> authors = new ArrayList<String>();
    public Book(){
    }
    

    public void addAuthor(String authorName){
        if (authors.contains(authorName)){
            System.out.println("Author is already in the list");
        

        }
        else{
            authors.add(authorName);
            System.out.println("Author added successfully");
        }
    }
    public Book(List<String> authors) {
		super();
		this.authors = authors;
	}


	public void removeAuthor (String authorName){
        if (authors.contains(authorName)){
            authors.remove(authorName);
            System.out.println("Author removed successfully");
        }
        else {
            System.out.println("Author is not in the list");
        }

        
    }
    
}