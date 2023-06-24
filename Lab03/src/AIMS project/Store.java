public class Store {
    private DigitalVideoDisc[] itemsInStore;
    private int currentIndex;
    
    public Store() {
        itemsInStore = new DigitalVideoDisc[10];
        currentIndex = 0;
    }
    
    public void addDVD(DigitalVideoDisc dvd) {
        if (currentIndex < itemsInStore.length) {
            itemsInStore[currentIndex] = dvd;
            currentIndex++;
            System.out.println("DVD " + dvd.getTitle() + " has been added to the store.");
        } else {
            System.out.println("Cannot add DVD " + dvd.getTitle() + ". The store is full.");
        }
    }
    
    public void removeDVD(DigitalVideoDisc dvd) {
        boolean found = false;
        for (int i = 0; i < currentIndex; i++) {
            if (itemsInStore[i] == dvd) {
                itemsInStore[i] = null;
                found = true;
                currentIndex--;
                System.out.println("DVD " + dvd.getTitle() + " has been removed from the store.");
                break;
            }
        }
        if (!found) {
            System.out.println("Cannot remove DVD " + dvd.getTitle() + ". It is not in the store.");
        }
    }
}
