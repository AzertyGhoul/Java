package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("ThreadsGUI.fxml"));
		} catch (IOException  e) {
			e.printStackTrace();
		}
		
		Scene scene = new Scene(root, 356, 475); 
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setTitle("LaboratoryWork5-6"); 
		primaryStage.setScene(scene); 
		primaryStage.show(); 
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
