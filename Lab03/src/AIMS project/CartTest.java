public class CartTest{
    public static void main (String[] args){
        Cart cart = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);
        cart.print();

        
        int id = 2;
        DigitalVideoDisc discById = DigitalVideoDisc.searchById(cart, id);
        if (discById == null) {
            System.out.println("DVD with ID " + id + " not found.");
        } else {
            System.out.println("DVD with ID " + id + " found: " + discById.getTitle());
        }
        
        
        String title = "LION";
        DigitalVideoDisc discByTitle = DigitalVideoDisc.searchByTitle(cart, title);
        if (discByTitle == null) {
            System.out.println("DVD with title " + title + " not found.");
        } else {
            System.out.println("DVD with title " + title + " found: " + discByTitle.getTitle());
        }
    }

}