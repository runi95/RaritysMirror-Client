package javafx.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class StartupModel {
	private BooleanProperty showAdvSettings = new SimpleBooleanProperty(false);
	
	public BooleanProperty getShowAdvSettings() {
		return showAdvSettings;
	}
}
