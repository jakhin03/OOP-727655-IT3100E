package hust.soict.dsai.aims.screen;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AddBookToStoreScreen {

	 @FXML private GridPane gridPane;
	    @FXML private TextField tfTitle;
	    @FXML private TextField tfCategory;
	    @FXML private TextField tfDirector;
	    @FXML private TextField tfLength;
	    @FXML private Label lblError;
		@FXML TextField tfCost;
		@FXML private Button btnSubmit;
		
		private boolean validInput = true;

	    @FXML
	    private void initialize() {
	    	 btnSubmit.setOnAction(event -> {
	    		 Stage stage = (Stage) btnSubmit.getScene().getWindow();
	    		 stage.close();
	    	 });
	    }
	    
	    public void clearFields() {
	        tfTitle.clear();
	        tfCategory.clear();
	        tfDirector.clear();
	        tfLength.clear();
	        tfCost.clear();
	        lblError.setText("");
	    }
	    
	    public boolean validateInput() {
	        return validInput;
	    }
	    
	    public float getCost() {
	    	float cost = 0;
	        try {
	            cost = Float.parseFloat(tfCost.getText());
	        } catch (NumberFormatException e) {
	        	validInput = false;
	            System.out.println("Invalid cost value!");
	        }
	        return cost;
	    }
	    
	    public String getTitle() {
	        return tfTitle.getText();
	    }
	    
	    public String getCategory() {
	        return tfCategory.getText();
	    }
	    
	    public String getDirector() {
	        return tfDirector.getText();
	    }
	    
	    public int getLength() {
	        try {
	            return Integer.parseInt(tfLength.getText());
	        } catch (NumberFormatException e) {
	        	validInput = false;
	        	System.out.println("Invalid DVD length!");
	            return 0;
	        }
	    }

}
