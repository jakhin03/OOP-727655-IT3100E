package hust.soict.dsai.aims;

import java.util.*;

public class Aims {
    public static void main(String[] args){
        Cart anOrder = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation","Roger Allers",19.95f);
        anOrder.addDigitalVideoDisc(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction", "George Lucas", 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);
        //print total cost of the items in the cart
        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());
        System.out.println(anOrder.getQtyOrdered());
        anOrder.removeDigitalVideoDisc(dvd3);
        System.out.println(anOrder.getQtyOrdered());
        }
}