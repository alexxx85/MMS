package com.musicalmanagementsystem.gui;

// IMPORTS
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.stage.Stage;

public class MainGui extends Application {

	// FXML OBJECTS	
	@FXML public Pane addNewTaskPane;
	@FXML public Text testingText;
	@FXML public MenuItem fileMenuQuitButton;
	@FXML public Text linkToTaskTab;
	@FXML public TabPane mainTabPane;
	@FXML public Tab tabMainPage;
	@FXML public Tab tabTasks;
	@FXML public Hyperlink linkToDonatePage;
	@FXML public Label donateHeartLabel;
	
	// VARIABLES
	boolean hasBeenClicked = false;
	WebEngine webEngine = new WebEngine();
	Image donateHeartPng = new Image("donateHeart.png");
	
	
	// METHODS
	public static void main(String[] args) {
		launch(args);							// Launching the JavaFX Window
		
	}
	
	public void start(Stage stage) throws Exception {
		
		
		/*
		 * Loading the FXML page for the GUI
		 */
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("startPage.fxml")
		);
		loader.setController(this);
		Parent root = (Parent) loader.load();
	    
		Scene scene = new Scene(root);
		
		// SUBMETHODS
		donateHeartLabel.setBackground(new Background(new BackgroundImage(donateHeartPng, null, null, null, null)));;
		
		// EVENTS FROM GUI
		/*
		 * When the Add New Task Pane is clicked, run this method.
		 */
		addNewTaskPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				if (hasBeenClicked) {				// Checking if it's currently been clicked
					testingText.setText("");
					hasBeenClicked = false;
				} else {
					testingText.setText("You just clicked!");
					hasBeenClicked = true;
				}
			}
		});
		
		/*
		 * Change the tab over to Tasks Tab from Landing Page
		 */
		linkToTaskTab.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				mainTabPane.getSelectionModel().select(tabTasks); // Select the main TabPane, then select the tasks tab
			}
		});
		
		/*
		 * Quit the program
		 */
		fileMenuQuitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				stage.close();
			}
		});
		
		/*
		 * Link to donate page (currently links to Trello
		 * TODO unlink this from trello
		 */
		linkToDonatePage.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				webEngine.load("https://trello.com/b/ct0vhYMj/mms");
			}
		});
		
		/*
		 * Stuff needed to launch the window.
		 */
		stage.setTitle("Musical Management System");
		stage.setScene(scene);
		stage.show();
		
		
	}

}
