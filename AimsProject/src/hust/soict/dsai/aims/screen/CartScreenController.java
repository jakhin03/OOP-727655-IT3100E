package hust.soict.dsai.aims.screen;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.collections.transformation.FilteredList;
import javafx.event.*;

import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;

public class CartScreenController {
	private Cart cart;
	
	@FXML private TableView<Media> tblMedia;
	@FXML private TableColumn<Media, String> colMediaTitle;
	@FXML private TableColumn<Media, String> colMediaCategory;
	@FXML private TableColumn<Media, Float> colMediaCost;
    @FXML private Button btnPlay;
    @FXML private Button btnRemove;
    @FXML private TextField tfFilter;
    @FXML private RadioButton radioBtnFilterId;
    @FXML private RadioButton radioBtnFilterTitle;
    @FXML private Label lblTotalCost;
    @FXML private MenuItem menuItemAddBook;
    @FXML private MenuItem menuItemAddCD;
    @FXML private MenuItem menuItemAddDVD;


	
	public CartScreenController(Cart cart) {
		super();
		this.cart = cart;
	}
	
	@FXML
	private void initialize() {
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		tblMedia.setItems(this.cart.getItemsOrdered());
		
		btnPlay.setVisible(false);
		btnRemove.setVisible(false);
		updateTotalCost();
		
		tblMedia.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Media>() {	
					@Override
					public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
						if (newValue != null) {
							updateButtonBar(newValue);
						}
				}
				});
		FilteredList<Media> filteredList = new FilteredList<>(tblMedia.getItems(), p -> true);
	    tblMedia.setItems(filteredList);

	    tfFilter.textProperty().addListener((observable, oldValue, newValue) -> {
	        filteredList.setPredicate(media -> {
	            if (newValue == null || newValue.isEmpty()) {
	                return true;
	            }

	            String lowerCaseFilter = newValue.toLowerCase();
	            if (radioBtnFilterTitle.isSelected()) {
	                return media.getTitle().toLowerCase().contains(lowerCaseFilter);
	            } else {
	                return String.valueOf(media.getId()).contains(lowerCaseFilter);
	            }
	        });
	    });
		
	}
	
	void updateButtonBar(Media media) {
			btnRemove.setVisible(true);
			if(media instanceof Playable) {
				btnPlay.setVisible(true);
			}else {
				btnPlay.setVisible(false);
			}
			updateTotalCost();
			

	}
	
	@FXML
	void addBook(ActionEvent event) {
		try {
	        // Load the AddDVD.fxml file
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddDVD.fxml"));
	        Parent root = loader.load();
	        AddDigitalVideoToStoreScreen controller = loader.getController();
	        
	        // Create a new dialog for the form screen
	        Stage dialog = new Stage();
	        dialog.initModality(Modality.APPLICATION_MODAL);
	        dialog.setTitle("Add DVD");
	        dialog.setScene(new Scene(root));
	        
	        // Show the dialog and wait for the user to close it
	        dialog.showAndWait();
	        
	        // Get the input values from the controller
	        String title = controller.getTitle();
	        String category = controller.getCategory();
	        String director = controller.getDirector();
	        int length = controller.getLength();
	        float cost = controller.getCost();
	        
	        // Validate the input and add the DVD to the cart if valid
	        if (controller.validateInput()) {
	            Book dvd = new Book(title, category, director, cost);
	            cart.addMedia(dvd);
	        } else {
	            // Show an error message if the input is not valid
	            Alert alert = new Alert(AlertType.ERROR);
	            alert.setTitle("Invalid Input");
	            alert.setHeaderText(null);
	            alert.setContentText("Please enter valid values for all fields.");
	            alert.showAndWait();
	            
	            // Clear the input fields
	            controller.clearFields();
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    updateTotalCost();
	}
	
	@FXML
	void addCD(ActionEvent event){
		try {
	        // Load the AddDVD.fxml file
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddDVD.fxml"));
	        Parent root = loader.load();
	        AddDigitalVideoToStoreScreen controller = loader.getController();
	        
	        // Create a new dialog for the form screen
	        Stage dialog = new Stage();
	        dialog.initModality(Modality.APPLICATION_MODAL);
	        dialog.setTitle("Add DVD");
	        dialog.setScene(new Scene(root));
	        
	        // Show the dialog and wait for the user to close it
	        dialog.showAndWait();
	        
	        // Get the input values from the controller
	        String title = controller.getTitle();
	        String category = controller.getCategory();
	        String director = controller.getDirector();
	        int length = controller.getLength();
	        float cost = controller.getCost();
	        
	        // Validate the input and add the DVD to the cart if valid
	        if (controller.validateInput()) {
	            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length,cost);
	            cart.addMedia(dvd);
	        } else {
	            // Show an error message if the input is not valid
	            Alert alert = new Alert(AlertType.ERROR);
	            alert.setTitle("Invalid Input");
	            alert.setHeaderText(null);
	            alert.setContentText("Please enter valid values for all fields.");
	            alert.showAndWait();
	            
	            // Clear the input fields
	            controller.clearFields();
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    updateTotalCost();
	}
	
	@FXML
	void addDVD(ActionEvent event) {
	    try {
	        // Load the AddDVD.fxml file
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddDVD.fxml"));
	        Parent root = loader.load();
	        AddDigitalVideoToStoreScreen controller = loader.getController();
	        
	        // Create a new dialog for the form screen
	        Stage dialog = new Stage();
	        dialog.initModality(Modality.APPLICATION_MODAL);
	        dialog.setTitle("Add DVD");
	        dialog.setScene(new Scene(root));
	        
	        // Show the dialog and wait for the user to close it
	        dialog.showAndWait();
	        
	        // Get the input values from the controller
	        String title = controller.getTitle();
	        String category = controller.getCategory();
	        String director = controller.getDirector();
	        int length = controller.getLength();
	        float cost = controller.getCost();
	        
	        // Validate the input and add the DVD to the cart if valid
	        if (controller.validateInput()) {
	            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length,cost);
	            cart.addMedia(dvd);
	        } else {
	            // Show an error message if the input is not valid
	            Alert alert = new Alert(AlertType.ERROR);
	            alert.setTitle("Invalid Input");
	            alert.setHeaderText(null);
	            alert.setContentText("Please enter valid values for all fields.");
	            alert.showAndWait();
	            
	            // Clear the input fields
	            controller.clearFields();
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    updateTotalCost();
	}
	
	@FXML
	void btnRemovePressed(ActionEvent event) {
		Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
		updateTotalCost();
	}
	
    private void updateTotalCost() {
        float totalCost = 0;
        boolean isCartEmpty = tblMedia.getItems().isEmpty();
        btnPlay.setVisible(!isCartEmpty);
        btnRemove.setVisible(!isCartEmpty);
        for (Media media : tblMedia.getItems()) {
            totalCost += media.getCost();
        }
        lblTotalCost.setText(String.format("%.2f $", totalCost));
    }
}
