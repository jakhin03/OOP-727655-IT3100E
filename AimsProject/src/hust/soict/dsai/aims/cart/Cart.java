public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered;
    
    public int getQtyOrdered() {
        return qtyOrdered;
    }
    
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if (this.qtyOrdered == MAX_NUMBERS_ORDERED){
            System.out.println("The cart is almost full");
        }
        else{
            int i;
            for (i=0;i<MAX_NUMBERS_ORDERED;i++){
                if (this.itemsOrdered[i] == null){
                    this.itemsOrdered[i] = disc;
                    this.qtyOrdered += 1;
                    System.out.println("The disc has been added");
                    break;
                }
            }
        }
    }
    
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        if (this.qtyOrdered == 0){
            System.out.println("Your cart is empty");
        }
        else{
            int i;
            for (i=0;i<MAX_NUMBERS_ORDERED;i++){
                if (this.itemsOrdered[i] != null && this.itemsOrdered[i].equals(disc)){
                    this.itemsOrdered[i] = null;
                    this.qtyOrdered -= 1;
                    System.out.println("The disc has been removed");
                    break;
                }
            }
            if (i == MAX_NUMBERS_ORDERED){
                System.out.println("The disc is not in the cart");
            }
        }
    }
    
    public float totalCost(){
        float res = 0;
        for (int i = 0; i < MAX_NUMBERS_ORDERED; i++){
            if (this.itemsOrdered[i] != null){
                res += this.itemsOrdered[i].getCost();
            }
        }
        return res;
    }
    
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < MAX_NUMBERS_ORDERED; i++) {
            if (this.itemsOrdered[i] != null) {
                System.out.println((i+1) + ". " + this.itemsOrdered[i].toString());
            }
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }
    public DigitalVideoDisc[] getItemsOrdered() {
        return itemsOrdered;
    }
}
