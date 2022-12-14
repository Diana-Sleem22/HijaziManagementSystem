package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistrationController implements Initializable {

	@FXML
	private CheckBox admin;

	@FXML
	private PasswordField confirmpassword;

	@FXML
	private TextField email;

	@FXML
	private TextField firstname;

	@FXML
	private TextField lastname;

	@FXML
	private PasswordField password;

	@FXML
	private CheckBox seller;
	@FXML
	private Button registerBtn;
	@FXML
	private Label usertype;

	@FXML
	private Label lname;

	@FXML
	private Label mail;

	@FXML
	private Label pass;
	@FXML
	private Label confirmpass;

	@FXML
	private Label fname;
	@FXML
	private Label checkpass;

	public static void main(String[] args) {
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		admin.selectedProperty()
				.addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
					if (new_val) {
						seller.setSelected(false);

					}
				});

		seller.selectedProperty()
				.addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
					if (new_val) {
						admin.setSelected(false);

					}
				});

	}

	@FXML
	void registerUser(ActionEvent event) throws IOException, ParseException {
		if (email.getText().isEmpty()) {
			mail.setText("required");
		}
		if (password.getText().isEmpty()) {
			pass.setText("required");
		}
		if (!password.getText().equals(confirmpassword.getText())) {
			checkpass.setText("passwords are not matched");
		}
		if (confirmpass.getText().isEmpty()) {
			confirmpass.setText("");
		}
		if (firstname.getText().isEmpty()) {
			fname.setText("required");
		}
		if (lastname.getText().isEmpty()) {
			lname.setText("required");
		}
		if (confirmpassword.getText().isEmpty()) {
			confirmpass.setText("required");
		}
		if (!admin.isSelected() && !seller.isSelected()) {
			usertype.setText("user type is required");
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Success");
			alert.setHeaderText("Operation successful");
			alert.setContentText("User Added successfully.");

			alert.showAndWait();

			UserModel user = new UserModel(firstname.getText(), lastname.getText(), email.getText(), "", "",
					password.getText(), admin.isSelected() ? 1 : 3);
			JSONObject response = CommonFunctions.sendHTTPRequest("http://localhost:8080/registerUser", "POST", "",
					user.toString());
			JSONObject responseData = (JSONObject) ((JSONArray) (response.get("data"))).get(0);
			if (Integer.parseInt(responseData.get("responseCode") + "") == 302) {
				Alert alert2 = new Alert(AlertType.ERROR);
				alert2.setTitle("Error");
				alert2.setHeaderText("Operation Failed");
				alert2.setContentText("User Already Found");
				alert2.showAndWait();
			} else {
				firstname.setText("");
				lastname.setText("");
				password.setText("");
				email.setText("");
				confirmpassword.setText("");

				admin.setSelected(false);
				seller.setSelected(false);
			}

		}

	}

}
