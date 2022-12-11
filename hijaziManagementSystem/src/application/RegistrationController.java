package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.json.simple.parser.ParseException;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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

    public static void main(String[] args) {}
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	admin.selectedProperty().addListener(
			      (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
			    	  if(new_val) {
			    		  seller.setSelected(false);

			    		}
			      });

    	seller.selectedProperty().addListener(
			      (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
			    	  if(new_val) {
			    		  admin.setSelected(false);

			    		}
			      });

    }



    @FXML
    void registerUser(ActionEvent event) throws IOException, ParseException {
//    	if(!password.getText().equals(confirmpassword.getText())){
//
//    	}
    	UserModel user = new UserModel(firstname.getText(), lastname.getText(), email.getText(), "" , "" , password.getText(), admin.isSelected() ? 1 : 3);
		 CommonFunctions.sendHTTPRequest("http://localhost:8080/registerUser", "POST","" , user.toString());
		 firstname.setText("");
		 lastname.setText("");
		 password.setText("");
		 email.setText("");
		 confirmpassword.setText("");

		 admin.setSelected(false);
		 seller.setSelected(false);




    }
}
