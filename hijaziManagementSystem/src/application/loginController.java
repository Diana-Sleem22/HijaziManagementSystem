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
    @FXML
    void login(javafx.event.ActionEvent actionEvent)throws IOException, ParseException{
     String txt1=email.getText();
     String txt2=password.getText();
     int roleFK =combobox.getValue().equals("Admin") ? 1 : 3;

	 JSONObject response = CommonFunctions.sendHTTPRequest("http://localhost:8080/loginUser", "GET",txt1 + "/" + txt2 + "/" + roleFK , "");
	 JSONArray responseData = (JSONArray)response.get("data");
     if(!responseData.isEmpty()) {
    	 try {
 			Parent root = FXMLLoader.load(getClass().getResource("landingPage.fxml"));
 			Scene scene = new Scene(root);
 			 Stage primaryStage = new Stage();
 			primaryStage.setScene(scene);
 			primaryStage.setTitle("Hijazi Management System");
// 			primaryStage.setUserData(responseData.get(0));
 			primaryStage.show();
 		} catch(Exception e) {
 			e.printStackTrace();
 		}

     }

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	String [] users= {"Admin","Seller"};
	combobox.getItems().addAll(users);

	}

}
