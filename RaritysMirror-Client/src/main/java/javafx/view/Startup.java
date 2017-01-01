package javafx.view;

import javafx.Resources;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class Startup extends BorderPane  {
	
	boolean showAdvSettings = false;
	
	@FXML
	TextField ipTextField;
	
	@FXML
	ScrollPane optionsScrollPane;
	
	@FXML
	Hyperlink advancedSettingsHyperlink;
	
	@FXML
	HBox advancedSettingsHBox;

	public Startup() {
		Resources.loadFXML(this);
	}
	
	@FXML
	public void advancedSettingsClicked() {
		if(showAdvSettings) {
			advancedSettingsHBox.setVisible(false);
			advancedSettingsHBox.setMinHeight(0.0);
			advancedSettingsHBox.setMaxHeight(0.0);
			advancedSettingsHyperlink.setText("Advanced Settings ↓");
			showAdvSettings = false;
		}else{
			advancedSettingsHBox.setVisible(true);
			advancedSettingsHBox.setMinHeight(USE_COMPUTED_SIZE);
			advancedSettingsHBox.setMaxHeight(USE_COMPUTED_SIZE);
			advancedSettingsHyperlink.setText("Advanced Settings ↑");
			showAdvSettings = true;
		}
	}
		
}
