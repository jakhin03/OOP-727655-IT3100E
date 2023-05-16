public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private static int nbDigitalVideoDiscs = 0;
    private int id;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public String getDirector() {
        return director;
    }
    public int getLength() {
        return length;
    }
    public float getCost() {
        return cost;
    }
    public DigitalVideoDisc(String title) {
        this.title = title;
    }
    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost){
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs ++;
        id = nbDigitalVideoDiscs;
    }
    
    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
    }
    public String toString() {
        return "DVD - " + title + " - " + category + " - " + director + " - " + length + ": " + cost + " $";
    }
    public boolean isMatch(String title) {
        return this.title.toLowerCase().contains(title.toLowerCase());
    }
    public int getId(){

        return id;
    }
    public static DigitalVideoDisc searchById(Cart cart, int id) {
        for (DigitalVideoDisc disc : cart.getItemsOrdered()) {
            if (disc.getId() == id) {
                return disc;
            }
        }
        return null;
    }
    
    public static DigitalVideoDisc searchByTitle(Cart cart, String title) {
        for (DigitalVideoDisc disc : cart.getItemsOrdered()) {
            if (disc.isMatch(title)) {
                return disc;
            }
        }
        return null;
    }
    
}







    
