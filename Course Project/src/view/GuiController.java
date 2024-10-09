package view;

import app.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class GuiController {
	public final String CSS_MAIN = getClass().getResource("main.css").toExternalForm();
	
	private Stage stage;
	
	public GuiController(Stage stage) {
		this.stage = stage;
	}
	
	public void initializeStage() {
		stage.setTitle("Course Registration App");
		
		Pane root = new Pane();
		Scene scene = new Scene(root, 640, 480);
		scene.getStylesheets().add(CSS_MAIN);
		root.getStyleClass().add("global");
		
		Label title = new Label("BAZINGA");
		title.getStyleClass().add("title_text");
		
		root.getChildren().add(title);
		
		stage.setScene(scene);
		stage.show();
	}
	
}
