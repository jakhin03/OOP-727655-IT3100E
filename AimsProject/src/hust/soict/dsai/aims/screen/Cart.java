import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media media) {
        if (this.itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            this.itemsOrdered.add(media);
            System.out.println("The media has been added");
        } else {
            System.out.println("The cart is full. Cannot add more media");
        }
    }

    public void removeMedia(Media media) {
        if (this.itemsOrdered.remove(media)) {
            System.out.println("The media has been removed");
        } else {
            System.out.println("The media is not in the cart");
        }
    }

    public float totalCost() {
        float res = 0;
        for (Media media : this.itemsOrdered) {
            res += media.getCost();
        }
        return res;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < this.itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + this.itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }

    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void filterByID(int id) {
        ArrayList<Media> filteredItems = new ArrayList<>();
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                filteredItems.add(media);
            }
        }
        displayFilteredItems(filteredItems);
    }

    public void filterByTitle(String title) {
        ArrayList<Media> filteredItems = new ArrayList<>();
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                filteredItems.add(media);
            }
        }
        displayFilteredItems(filteredItems);
    }

    public void displayFilteredItems(ArrayList<Media> filteredItems) {
        if (filteredItems.isEmpty()) {
            System.out.println("No matching items found.");
        } else {
            System.out.println("Filtered Items:");
            for (int i = 0; i < filteredItems.size(); i++) {
                System.out.println((i + 1) + ". " + filteredItems.get(i).toString());
            }
        }
    }

    public void sortByID() {
        itemsOrdered.sort((m1, m2) -> Integer.compare(m1.getId(), m2.getId()));
        System.out.println("Items in cart sorted by ID.");
        print();
    }

    public void sortByTitle() {
        itemsOrdered.sort((m1, m2) -> m1.getTitle().compareToIgnoreCase(m2.getTitle()));
        System.out.println("Items in cart sorted by Title.");
        print();
    }

    public void sortByCost() {
        itemsOrdered.sort((m1, m2) -> Float.compare(m1.getCost(), m2.getCost()));
        System.out.println("Items in cart sorted by Cost.");
        print();
    }

    public Media search(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public void clear() {
        itemsOrdered.clear();
        System.out.println("The cart is cleared.");
    }
}