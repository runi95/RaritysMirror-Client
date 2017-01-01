package javafx;

import javafx.application.Application;
import javafx.model.StartupModel;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.view.StartupView;

public class Main extends Application {
	public static void main(String[] args) {
		Main.launch(args);
	}

		private static int width, height;
		private Scene scene;
		private static StackPane root = new StackPane();
		
		public static StackPane getRoot() {
			return root;
		}
		
		public int getWidth() {
			return width;
		}
		
		public int getHeight() {
			return height;
		}
		
		@Override
		public void start(Stage primaryStage) throws Exception {
			
			startValues(primaryStage);
			setStartScene(primaryStage);
		}
		
		private void startValues(Stage stage) {
			width = 320;
			height = 150;
			
			stage.setTitle("Rarity's Mirror - Client");
//			stage.getIcons().addAll(new Image("/server/ui/resources/images/ui/icon.png"), new Image("/server/ui/resources/images/ui/icon.icns"));
		}
		
		/*
		private void setListeners() {
			
		}
		*/
		
		private void setFullscreenMode(boolean f, Stage stage) {
			if(f) {
				stage.hide();
				stage.setFullScreen(true);
				stage.initStyle(StageStyle.UNDECORATED);
				stage.show();
			}else{
				stage.hide();
				stage.setFullScreen(false);
				stage.initStyle(StageStyle.DECORATED);
				stage.show();
			}
		}
		
		private void setStartScene(Stage stage) {
			StartupView view = new StartupView();
			view.initModel(new StartupModel());
			
			root.getChildren().add(view);
			
			scene = new Scene(root, width, height);
//			scene.getStylesheets().add("javafx/view/fxml/css/style.css");
			stage.setScene(scene);
			stage.show();
		}
	}
