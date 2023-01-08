package application;

import org.json.simple.JSONArray;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
public class LandingPage extends Application{
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("landingPage.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Hijazi Management System");



			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void printUser(JSONArray user) {
		System.out.println("user " + user);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
