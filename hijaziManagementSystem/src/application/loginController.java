package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginController implements Initializable {

	@FXML
	private ComboBox<String> combobox;

	@FXML
	private TextField email;

	@FXML
	private PasswordField password;
	@FXML
	private Label passwordlabel;
	@FXML
	private Button login;
	@FXML
	private Label emaillabel;
	String[] users = { "Admin", "Seller" };
	@FXML
	private Label usertype;

	@FXML

	void login(javafx.event.ActionEvent actionEvent) throws IOException, ParseException {
		System.out.println(combobox.getValue());
		String txt1 = email.getText();
		String txt2 = password.getText();
		if (txt1.isEmpty() || txt2.isEmpty() || (combobox.getValue() + "").equals("null")) {
			Alert alert2 = new Alert(AlertType.ERROR);
			alert2.setTitle("Error");
			alert2.setHeaderText("Operation Failed");
			alert2.setContentText("Missing Fields");
			alert2.showAndWait();
		}

		else {
			int roleFK = combobox.getValue().equals("Admin") ? 1 : 3;
			JSONObject response = CommonFunctions.sendHTTPRequest("http://localhost:8080/loginUser", "GET",
					txt1 + "/" + txt2 + "/" + roleFK, "");
			JSONArray responseData = (JSONArray) response.get("data");
			JSONObject json = (JSONObject) responseData.get(0);
			 
			if (Integer.parseInt(json.get("responseCode") + "") !=  404) {
				try {
					JSONObject user =  (JSONObject) json.get("user");
					UserSingletonInstance singleton = UserSingletonInstance.getInstance();
					
					singleton.setFirstname(user.get("firstname") + "");
					singleton.setLastname(user.get("lastname") + "");
					singleton.setRoleFK(Integer.parseInt(user.get("roleFK") + ""));
					singleton.setId(Integer.parseInt(user.get("id") + ""));
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Success");
					alert.setHeaderText("Operation successful");
					alert.setContentText("You are successfully logged in");

					alert.showAndWait();
					Parent root = FXMLLoader.load(getClass().getResource("landingPage.fxml"));
					Scene scene = new Scene(root);
					Stage primaryStage = new Stage();
					primaryStage.setScene(scene);
					primaryStage.setTitle("Hijazi Management System");
					currentStage cs = currentStage.getInstance();
					cs.getStageView().close();
					cs.setStageView(primaryStage);
					primaryStage.show();

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			else {
				Alert alert2 = new Alert(AlertType.ERROR);
				alert2.setTitle("Error");
				alert2.setHeaderText("Operation Failed");
				alert2.setContentText("User not found");
				alert2.showAndWait();
			}
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		combobox.getItems().addAll(users);

	}

	private boolean isExistingEmail(String emaill) throws IOException, ParseException {
		String txt1 = email.getText();
		String txt2 = password.getText();
		int roleFK = combobox.getValue().equals("Admin") ? 1 : 3;
		JSONObject response = CommonFunctions.sendHTTPRequest("http://localhost:8080/loginUser", "GET",
				txt1 + "/" + txt2 + "/" + roleFK, "");
		JSONArray responseData = (JSONArray) response.get("data");
		for (Object element : responseData) {
			JSONObject new_obj = (JSONObject) element;
			if (new_obj.get("email").equals(emaill)) {
				System.out.println("email exist");

			}
		}

		return false;
	}

}
