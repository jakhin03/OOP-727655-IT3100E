package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.*;
import hust.soict.dsai.aims.disc.*;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.*;
import hust.soict.dsai.aims.screen.*;

import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        showMenu();
        scanner.close();
    }

    public static void showMenu() {
        System.out.println("AIMS:");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                viewStore();
                break;
            case 2:
                updateStore();
                break;
            case 3:
                seeCurrentCart();
                break;
            case 0:
                System.out.println("Exiting the program. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                showMenu();
        }
    }

    public static void viewStore() {
        store.print();
        storeMenu();
    }

    public static void storeMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                seeMediaDetails();
                break;
            case 2:
                addMediaToCart();
                break;
            case 3:
                playMedia();
                break;
            case 4:
                seeCurrentCart();
                break;
            case 0:
                showMenu();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                storeMenu();
        }
    }

    public static void seeMediaDetails() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();

        Media media = store.mediaSearch(title);
        if (media != null) {
            System.out.println(media.toString());
            mediaDetailsMenu(media);
        } else {
            System.out.println("Media not found in store.");
            storeMenu();
        }
    }

    public static void mediaDetailsMenu(Media media) {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        if (media instanceof Playable) {
            System.out.println("2. Play");
        }
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1" + (media instanceof Playable ? "-2" : ""));

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                cart.addMedia(media);
                System.out.println("The media has been added to the cart.");
                storeMenu();
                break;
            case 2:
                if (media instanceof Playable) {
                    ((Playable) media).play();
                } else {
                    System.out.println("Invalid choice. Please try again.");
                    mediaDetailsMenu(media);
                }
                break;
            case 0:
                storeMenu();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                mediaDetailsMenu(media);
        }
    }

    public static void addMediaToCart() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();

        Media media = store.mediaSearch(title);
        if (media != null) {
            cart.addMedia(media);
            System.out.println("The media has been added to the cart.");
        } else {
            System.out.println("Media not found in store.");
        }

        storeMenu();
    }

    public static void playMedia() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();

        Media media = store.mediaSearch(title);
        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("Media not found or is not playable.");
        }

        storeMenu();
    }

    public static void seeCurrentCart() {
        cart.print();
        cartMenu();
    }

    public static void cartMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                filterMediasInCart();
                break;
            case 2:
                sortMediasInCart();
                break;
            case 3:
                removeMediaFromCart();
                break;
            case 4:
                playMediaFromCart();
                break;
            case 5:
                placeOrder();
                break;
            case 0:
                storeMenu();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                cartMenu();
        }
    }

    public static void filterMediasInCart() {
        System.out.println("Filter options:");
        System.out.println("--------------------------------");
        System.out.println("1. Filter by ID");
        System.out.println("2. Filter by Title");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                System.out.print("Enter the ID to filter: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                cart.filterByID(id);
                break;
            case 2:
                System.out.print("Enter the title to filter: ");
                String title = scanner.nextLine();
                cart.filterByTitle(title);
                break;
            case 0:
                cartMenu();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                filterMediasInCart();
        }

        cartMenu();
    }

    public static void sortMediasInCart() {
        System.out.println("Sort options:");
        System.out.println("--------------------------------");
        System.out.println("1. Sort by ID");
        System.out.println("2. Sort by Title");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                cart.sortByID();
                break;
            case 2:
                cart.sortByTitle();
                break;
            case 0:
                cartMenu();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                sortMediasInCart();
        }

        cartMenu();
    }

    public static void removeMediaFromCart() {
        System.out.print("Enter the title of the media to remove: ");
        String title = scanner.nextLine();
        
        Media media = cart.search(title);
        if (media != null) {
            cart.removeMedia(media);
            System.out.println("The media has been removed from the cart.");
        } else {
            System.out.println("Media not found in cart.");
        }
    
        cartMenu();
    }
    
    public static void playMediaFromCart() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();

        Media media = cart.search(title);
        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("Media not found or is not playable.");
        }

        cartMenu();
    }
    public static void updateStore(){
        System.out.println("Store updated!");
        cartMenu();
    }

    public static void placeOrder() {
        System.out.println("Thanks for shopping");
        cartMenu();
    }
}
