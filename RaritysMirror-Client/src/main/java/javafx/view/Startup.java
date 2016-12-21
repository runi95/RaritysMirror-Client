package javafx.view;

import javafx.Resources;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class Startup extends BorderPane  {
	
	@FXML
	TextField ipTextField;
	
	@FXML
	ScrollPane optionsScrollPane;

	public Startup() {
		Resources.loadFXML(this);
	}
	
	@FXML
	public void optionsOnClick(MouseEvent e) {
		optionsScrollPane.setVisible(true);
	}
		
}
