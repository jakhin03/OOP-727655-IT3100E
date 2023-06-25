package hust.soict.dsai.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Painter extends Application{
	
	@Override
	public void start(Stage stage) throws Exception{
		Parent root = FXMLLoader.load(getClass()
				.getResource("Painter.fxml"));
		
		Scene scene = new Scene(root);
		stage.setTitle("Painter");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
