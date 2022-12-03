package application;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
public class productsController implements Initializable{
    @FXML
    private Button category;

    @FXML
    void addCategory(javafx.event.ActionEvent actionEvent)throws IOException{
    	try {
    		FXMLLoader root = new FXMLLoader(getClass().getResource("Categories.fxml"));
		    Parent root1=(Parent) root.load();
		    Stage stage=new Stage();
		    stage.setScene(new Scene(root1));
		    stage.setTitle("Categories");
		    stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
