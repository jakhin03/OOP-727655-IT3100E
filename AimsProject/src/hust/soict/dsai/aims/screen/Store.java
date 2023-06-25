import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public int getQty() {
        return this.itemsInStore.size();
    }

    public void addMedia(Media media) {
        if (itemsInStore.size() < 10) {
            itemsInStore.add(media);
            System.out.println(media.getClass().getSimpleName() + " " + media.getTitle() + " has been added to the store.");
        } else {
            System.out.println("Cannot add " + media.getClass().getSimpleName() + " " + media.getTitle() + ". The store is full.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println(media.getClass().getSimpleName() + " " + media.getTitle() + " has been removed from the store.");
        } else {
            System.out.println("Cannot remove " + media.getClass().getSimpleName() + " " + media.getTitle() + ". It is not in the store.");
        }
    }

    public void print() {
        System.out.println("***********************STORE***********************");
        System.out.println("Items in Store:");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i).getTitle());
        }
        System.out.println("**************************************************");
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public Media search(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equals(title)) {
                return media;
            }
        }
        return null;
    }
}