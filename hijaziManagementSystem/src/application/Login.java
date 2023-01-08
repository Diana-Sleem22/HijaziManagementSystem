package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Login extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			currentStage cs = currentStage.getInstance();
			Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
			Scene scene = new Scene(root,643,501);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Login");
			cs.setStageView(primaryStage);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
