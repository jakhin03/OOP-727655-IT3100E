package hust.soict.dsai.javafx;

import javafx.fxml.FXML;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.event.*;


public class PainterController {
	
	@FXML private Pane drawingAreaPane;
	@FXML private Pane drawingArea;
	private DrawingTool currentTool = DrawingTool.PEN;
    
	@FXML
	public void drawingAreaMouseDragged(MouseEvent event) {
		int penSize;
		Color penColor;
	    if (currentTool == DrawingTool.PEN) {
	        penSize = 4;
	        penColor = Color.BLACK;
	    } else { // eraser tool selected
	        penSize = 10;
	        penColor = Color.WHITE;
	    }	
		Circle newCircle = new Circle(event.getX(), event.getY(), penSize, penColor);
		drawingAreaPane.getChildren().add(newCircle);

	}
	
	@FXML
	void clearButtonPressed(ActionEvent event) {
		if (drawingAreaPane != null) {
			drawingAreaPane.getChildren().clear();
		}
	}
	
	public enum DrawingTool {
	    PEN,
	    ERASER
	}
	
	@FXML
	private void handleEraserSelected() {
		currentTool = DrawingTool.ERASER;
	}
	
	@FXML
	private void handlePenSelected() {
		currentTool = DrawingTool.PEN;
	}
	
}
