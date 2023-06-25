package hust.soict.dsai.aims.screen;

import java.io.IOException;

import javax.swing.JFrame;
import javafx.embed.swing.JFXPanel;
import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import hust.soict.dsai.aims.cart.Cart;

public class CartScreen extends JFrame{
	private Cart cart;
	
	public static void main(String[] args) {
	        Cart cart = new Cart();
	        new CartScreen(cart);
	    }
	
	public CartScreen(Cart cart) {
		super();
		
		this.cart = cart;
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Cart");
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
