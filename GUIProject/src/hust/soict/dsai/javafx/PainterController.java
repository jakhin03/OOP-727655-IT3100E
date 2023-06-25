package hust.soict.dsai.javafx;

import javafx.fxml.FXML;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.event.*;


public class PainterController {
	
	@FXML
	private Pane drawingAreaPane;
    
	@FXML
	public void drawingAreaMouseDragged(MouseEvent event) {
		Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
		drawingAreaPane.getChildren().add(newCircle);
	    if (currentTool == DrawingTool.PEN) {
	        newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
	    } else { // eraser tool selected
	        newCircle = new Circle(event.getX(), event.getY(), 4, Color.WHITE);
	    }	
	}
	
	@FXML
	void clearButtonPressed(ActionEvent event) {
		if (drawingAreaPane != null) {
			drawingAreaPane.getChildren().clear();
		}
	}
	
	//add erase feature
	public enum DrawingTool {
	    PEN,
	    ERASER
	}

	private DrawingTool currentTool = DrawingTool.PEN;
	
	@FXML
	private void handleEraserSelected() {
		currentTool = DrawingTool.ERASER;
	}
	
	@FXML
	private void handlePenSelected() {
		currentTool = DrawingTool.PEN;
	}
	
}
