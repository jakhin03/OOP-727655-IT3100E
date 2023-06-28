package hust.soict.dsai.aims.screen;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;
import javafx.embed.swing.JFXPanel;
import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartScreen extends JFrame{
	private Cart cart;
	
	public static void main(String[] args) {
	        Cart cart = new Cart();
	        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
	        cart.addMedia(dvd1);
	        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
	        cart.addMedia(dvd2);
	        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
	        cart.addMedia(dvd3);
	        new CartScreen(cart);
	    }
	
	public CartScreen(Cart cart) {
		super();
		
		this.cart = cart;
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Cart");
		this.setSize(new Dimension(1024,768));
		this.setVisible(true);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass()
							.getResource("cart.fxml"));
					CartScreenController controller = 
							new CartScreenController(cart);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
			
		
		
	}
}
