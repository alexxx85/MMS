package com.musicalmanagementsystem.gui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainGui extends Application {


	/*@FXML public TextField nameField;
    @FXML public Button nameSubmitButton;
	@FXML public Text helloBox;*/
	@FXML public Pane addNewTaskPane;
	@FXML public Text testingText;
	boolean hasBeenClicked = false;
	
	public static void main(String[] args) {
		launch(args);
		
	}
	
	public void start(Stage stage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("startPage.fxml")
		);
		loader.setController(this);
		Parent root = (Parent) loader.load();
	    
		Scene scene = new Scene(root, 1000, 800);
		
		addNewTaskPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				if (hasBeenClicked) {
					testingText.setText("");
					hasBeenClicked = false;
				} else {
					testingText.setText("You just clicked!");
					hasBeenClicked = true;
				}
			}
		});
		
		stage.setTitle("Musical Management System");
		stage.setScene(scene);
		stage.show();
		
		
	}

}
