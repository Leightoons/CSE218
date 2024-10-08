package view;

import app.*;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.*;

public class GuiController {
	private Stage stage;
	
	public GuiController(Stage stage) {
		this.stage = stage;
	}
	
	public void initializeStage() {
		stage.setTitle("Course Registration App");
		stage.setOnCloseRequest(ae -> DataCenter.saveToFile());
		//stage.show();
	}
	
}
