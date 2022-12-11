package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class billingController implements Initializable {
	@FXML
    private Button customer;

    @FXML
    private Label value;
	int count=0;
    @FXML
    void decrease(ActionEvent event) {
    
value.setText(Integer.toString(count--));
    }

    @FXML
    void increase(ActionEvent event) {
    	value.setText(Integer.toString(count++));
    }
    @FXML
    void customerPage(javafx.event.ActionEvent actionEvent)throws IOException{
//    	customer.setStyle("-fx-background-color:#c3c7c5; -fx-text-fill:black;");
    	try {
    		FXMLLoader root = new FXMLLoader(getClass().getResource("customers.fxml"));
		    Parent root1=(Parent) root.load();
		    Stage stage=new Stage();
		    stage.setScene(new Scene(root1));
		    stage.setTitle("Customers");
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
