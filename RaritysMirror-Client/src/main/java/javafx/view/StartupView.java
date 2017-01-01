package javafx.view;

import backend.Client;
import backend.ClientInformation;
import javafx.Resources;
import javafx.fxml.FXML;
import javafx.model.StartupModel;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class StartupView extends BorderPane  {
	
	StartupModel model;
	
	@FXML
	TextField nameTextField;
	
	@FXML
	TextField ipTextField;
	
	@FXML
	TextField portTextField;
	
	@FXML
	ScrollPane optionsScrollPane;
	
	@FXML
	Hyperlink advancedSettingsHyperlink;
	
	@FXML
	HBox advancedSettingsHBox;

	public StartupView() {
		Resources.loadFXML(this);
	}
	
	@FXML
	public void advancedSettingsClicked() {
		model.getShowAdvSettings().setValue(!model.getShowAdvSettings().getValue());
	}
	
	@FXML
	public void ConnectButtonClicked() {
		String ip = ipTextField.getText(), strPort = portTextField.getText();
		
		if(ip.equals(""))
			ip = "localhost";
		if(strPort.equals(""))
			strPort = "1995";
		
		int port = Integer.parseInt(strPort);
		
		if(checkIp(ip) && checkPort(port))
			return;
			
		ClientInformation ci = new ClientInformation();
		ci.setName(nameTextField.getText());
		Client.connect(ip, port, ci);
	}
	
	private boolean checkIp(String ip) {
		if(ip.equals("localhost"))
			return true;
		else{
			String[] split = ip.split(".");
			int length = split.length;
			
			if (length != 4)
				return true;
			
			for(int i = 0; i < length; i++) {
				int wordLength = split[i].length();
				if(wordLength > 3)
					return true;
			for(int j = 0; j < wordLength; j++) {
				char c = split[i].charAt(j);
				if(c != 46 && (c < 48 || c > 57))
					return true;
			}}
			
			return false;
		}
	}
	
	private boolean checkPort(int port) {
		if(port < 0)
			return true;
		
		if(port > 65535)
			return true;
		
		return false;
	}
	
	public void initModel(StartupModel model) {
		if (this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }
		
		this.model = model;
		
		model.getShowAdvSettings().addListener((obs, oldSetting, newSetting) -> {
			if(newSetting) {
				advancedSettingsHBox.setVisible(true);
				advancedSettingsHBox.setMinHeight(USE_COMPUTED_SIZE);
				advancedSettingsHBox.setMaxHeight(USE_COMPUTED_SIZE);
				advancedSettingsHyperlink.setText("Advanced Settings ↑");
			}else{
				advancedSettingsHBox.setVisible(false);
				advancedSettingsHBox.setMinHeight(0.0);
				advancedSettingsHBox.setMaxHeight(0.0);
				advancedSettingsHyperlink.setText("Advanced Settings ↓");
			}
				
		});
	}
	
}
