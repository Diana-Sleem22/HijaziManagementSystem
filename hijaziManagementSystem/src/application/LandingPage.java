package application;

import org.json.simple.JSONObject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class LandingPage extends Application{
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("landingPage.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Hijazi Management System");
			JSONObject json = (JSONObject) primaryStage.getUserData();
//			UserSingletonInstance user = new UserSingletonInstance(json.get("firstname") + "" ,json.get("lastname") + "",json.get("email") + "",json.get("address") + "",json.get("phoneNumber") + "",Integer.parseInt(json.get("roleFK") + "" ));
//			UserSingletonInstance.setUser(user);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
