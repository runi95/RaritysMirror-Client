package javafx;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

public class Resources {
		public static void loadFXML(Node node) {
			try {
				String name = "/javafx/view/" + node.getClass().getSimpleName() + ".fxml";
				FXMLLoader fxmlLoader = new FXMLLoader(Resources.class.getResource(name));

				fxmlLoader.setRoot(node);
				fxmlLoader.setController(node);

				System.out.println("Loading: " + node.getClass().getSimpleName());

				fxmlLoader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
