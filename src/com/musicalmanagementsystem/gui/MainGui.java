package com.musicalmanagementsystem.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainGui extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("startPage.fxml"));
	    
		Scene scene = new Scene(root, 1000, 800);
	    
		stage.setTitle("FXML Welcome");
		stage.setScene(scene);
		stage.show();
	}

}
