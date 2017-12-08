import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextArea;

//class defnition for go game
public class Go extends Application {
	// overridden init method
	public void init() {
		
		sp_mainlayout = new StackPane();
		customControl = new CustomControl();
		vbox= new VBox();
		mb_menubar = new MenuBar();
		menu_about = new Menu("About");
		menu_rules = new Menu("Rules");
		menu_help = new Menu("Help");
		mb_menubar.getMenus().addAll(menu_about, menu_rules, menu_help);
		
		menu_info = new MenuItem("Info");
		menu_about.getItems().add(menu_info);
		
		menu_therules=new MenuItem("The Rules");
		menu_rules.getItems().add(menu_therules);
		
		sp_mainlayout.getChildren().addAll(customControl,vbox);
		vbox.getChildren().add(mb_menubar);
		
		// Listener to the more menuItem to create a new window
		menu_info.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {
						// create a hbox and textArea, set a size and the text, prevent
						// the textArea from editable and add it to the hbox
						HBox info_hb = new HBox();
						TextArea about_textArea = new TextArea();
						about_textArea.setPrefWidth(350);
						about_textArea.setPrefHeight(250);
						about_textArea.setText(
								"Go is an abstract strategy board game for two players,\n in which the aim is to surround more territory than the \n opponent.");
						about_textArea.setEditable(false);
						info_hb.getChildren().add(about_textArea);

						// set a title on the window, set a scene, size, and show the
						// window
						Stage aboutStage = new Stage();
						aboutStage.setTitle("Info");
						aboutStage.setScene(new Scene(info_hb, 350, 150));
						aboutStage.show();
					}
				});
		// Listener to the more menuItem to create a new window
				menu_therules.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent e) {
								// create a hbox and textArea, set a size and the text, prevent
								// the textArea from editable and add it to the hbox
								HBox about_hb = new HBox();
								TextArea about_textArea = new TextArea();
								about_textArea.setPrefWidth(350);
								about_textArea.setPrefHeight(250);
								about_textArea.setText(
										"A game of Go starts with an empty board. Each player has \n "
										+"an effectively unlimited supply of pieces (called stones), \n"
										+"one taking the black stones, the other taking white. The \n"
										+"main object of the game is to use your stones to form  \n"
										+"territories by surrounding vacant areas of the board. It \n "
										+"is also possible to capture your opponent's stones by  \n"
										+"completely surrounding them. The player with more area \n"
										+ "wins.");
								about_textArea.setEditable(false);
								about_hb.getChildren().add(about_textArea);

								// set a title on the window, set a scene, size, and show the
								// window
								Stage aboutStage = new Stage();
								aboutStage.setTitle("The Rules");
								aboutStage.setScene(new Scene(about_hb, 350, 150));
								aboutStage.show();
							}
						});
		
	}
	
	
	
	// overridden start method
	public void start(Stage primaryStage) {
		
		primaryStage.setTitle("Go game");
		primaryStage.setScene(new Scene(sp_mainlayout,800,800));
		primaryStage.show();

	}
	
	// overridden stop method
	public void stop() {
		
	}
	
	// entry point into our program for launching our javafx applicaton
	public static void main(String[] args) {
		launch(args);

	}
	
	// private fields for a stack pane and a go control
	private StackPane sp_mainlayout;
	private VBox vbox;
	
	private CustomControl customControl;
	private MenuBar mb_menubar;
	private Menu menu_about,menu_rules, menu_help;
	private MenuItem menu_info, menu_therules;
}




