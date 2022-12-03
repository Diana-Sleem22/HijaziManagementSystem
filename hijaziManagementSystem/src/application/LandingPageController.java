package application;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class LandingPageController implements Initializable {

	   @FXML
	    private Button stock;

	 @FXML
	    private Button Categories;

	    @FXML
	    private Button billing;

	    @FXML
	    private Button company;

	    @FXML
	    private StackPane contentArea;

	    @FXML
	    private Button supplier;
	    @FXML
	    private Button order;

	    @FXML
	    private Button product;

	    @FXML
	    private Label userName;
	    @FXML
	    private Button adduser;

	    @FXML
	    private Button analytics;
	    @FXML
	    private Button backup;

	    @FXML
	    private Button logout;
	    @FXML
		    void BillingPage(javafx.event.ActionEvent actionEvent) throws IOException {
				Parent root = FXMLLoader.load(getClass().getResource("billing.fxml"));
				contentArea.getChildren().removeAll();
				contentArea.getChildren().setAll(root);
				billing.setStyle("-fx-background-color: #ffffff; -fx-text-fill:black;");
				product.setStyle("-fx-background-color:transparent; ");
				company.setStyle("-fx-background-color: transparent; ");
				product.setStyle("-fx-background-color: transparent; ");
				adduser.setStyle("-fx-background-color: transparent; ");
				analytics.setStyle("-fx-background-color: transparent; ");
				order.setStyle("-fx-background-color: transparent; ");
				supplier.setStyle("-fx-background-color: transparent; ");
				stock.setStyle("-fx-background-color: transparent; ");
				backup.setStyle("-fx-background-color: transparent; ");
		    }
		    @FXML
		    void ProductPage(javafx.event.ActionEvent actionEvent)throws IOException {
		    	Parent root = FXMLLoader.load(getClass().getResource("products.fxml"));
				contentArea.getChildren().removeAll();
				contentArea.getChildren().setAll(root);
				product.setStyle("-fx-background-color: #ffffff; -fx-text-fill:black;");
				billing.setStyle("-fx-background-color: transparent; ");
				company.setStyle("-fx-background-color: transparent; ");
				adduser.setStyle("-fx-background-color: transparent; ");
				analytics.setStyle("-fx-background-color: transparent; ");
				order.setStyle("-fx-background-color: transparent; ");
				supplier.setStyle("-fx-background-color: transparent; ");
				stock.setStyle("-fx-background-color: transparent; ");
				backup.setStyle("-fx-background-color: transparent; ");
		    }
		    @FXML
		    void CompanyPage(javafx.event.ActionEvent actionEvent)throws IOException{
		    	Parent root = FXMLLoader.load(getClass().getResource("company.fxml"));
				contentArea.getChildren().removeAll();
				contentArea.getChildren().setAll(root);
				product.setStyle("-fx-background-color: transparent; ");
				billing.setStyle("-fx-background-color: transparent; ");
				company.setStyle("-fx-background-color: #ffffff; -fx-text-fill:black;");
				product.setStyle("-fx-background-color: transparent; ");
				adduser.setStyle("-fx-background-color: transparent; ");
				analytics.setStyle("-fx-background-color: transparent; ");
				order.setStyle("-fx-background-color: transparent; ");
				supplier.setStyle("-fx-background-color: transparent; ");
				stock.setStyle("-fx-background-color: transparent; ");
				backup.setStyle("-fx-background-color: transparent; ");
		    }
		    @FXML
		    void orderPage(javafx.event.ActionEvent actionEvent)throws IOException{
		    	Parent root = FXMLLoader.load(getClass().getResource("order.fxml"));
				contentArea.getChildren().removeAll();
				contentArea.getChildren().setAll(root);
				product.setStyle("-fx-background-color: transparent; ");
				billing.setStyle("-fx-background-color: transparent; ");
				company.setStyle("-fx-background-color: transparent; ");
				adduser.setStyle("-fx-background-color: transparent; ");
				analytics.setStyle("-fx-background-color: transparent; ");
				order.setStyle("-fx-background-color: #ffffff; -fx-text-fill:black;");
				supplier.setStyle("-fx-background-color: transparent; ");
				stock.setStyle("-fx-background-color: transparent; ");
				backup.setStyle("-fx-background-color: transparent; ");
		    }
		    @FXML
		    void SupplierPage(javafx.event.ActionEvent actionEvent)throws IOException{
		    	Parent root = FXMLLoader.load(getClass().getResource("supplier.fxml"));
				contentArea.getChildren().removeAll();
				contentArea.getChildren().setAll(root);
				product.setStyle("-fx-background-color: transparent; ");
				billing.setStyle("-fx-background-color: transparent; ");
				company.setStyle("-fx-background-color: transparent; ");
				product.setStyle("-fx-background-color: transparent; ");
				adduser.setStyle("-fx-background-color: transparent; ");
				analytics.setStyle("-fx-background-color: transparent; ");
				order.setStyle("-fx-background-color: transparent; ");
				supplier.setStyle("-fx-background-color: #ffffff; -fx-text-fill:black; ");
				stock.setStyle("-fx-background-color: transparent; ");
				backup.setStyle("-fx-background-color: transparent; ");
		    }
		    @FXML
		    void stockPage(javafx.event.ActionEvent actionEvent)throws IOException {
		    	Parent root = FXMLLoader.load(getClass().getResource("stock.fxml"));
				contentArea.getChildren().removeAll();
				contentArea.getChildren().setAll(root);
				product.setStyle("-fx-background-color: transparent; ");
				billing.setStyle("-fx-background-color: transparent; ");
				company.setStyle("-fx-background-color: transparent; ");
				product.setStyle("-fx-background-color: transparent; ");
				adduser.setStyle("-fx-background-color: transparent; ");
				analytics.setStyle("-fx-background-color: transparent; ");
				order.setStyle("-fx-background-color: transparent; ");
				supplier.setStyle("-fx-background-color:transparent; ");
				stock.setStyle("-fx-background-color: #ffffff; -fx-text-fill:black;");
				backup.setStyle("-fx-background-color: transparent; ");
		    }
		    @FXML
		    void analyticsPage(javafx.event.ActionEvent actionEvent)throws IOException {
		    	Parent root = FXMLLoader.load(getClass().getResource("analytics.fxml"));
				contentArea.getChildren().removeAll();
				contentArea.getChildren().setAll(root);
				product.setStyle("-fx-background-color: transparent; ");
				billing.setStyle("-fx-background-color: transparent; ");
				company.setStyle("-fx-background-color: transparent; ");
				product.setStyle("-fx-background-color: transparent; ");
				adduser.setStyle("-fx-background-color: transparent; ");
				analytics.setStyle("-fx-background-color: #ffffff; -fx-text-fill:black;");
				order.setStyle("-fx-background-color: transparent; ");
				supplier.setStyle("-fx-background-color:transparent; ");
				stock.setStyle("-fx-background-color: transparent; ");
				backup.setStyle("-fx-background-color: transparent; ");
		    }
		    @FXML
		    void registration(javafx.event.ActionEvent actionEvent)throws IOException {
		    	Parent root = FXMLLoader.load(getClass().getResource("registration.fxml"));
				contentArea.getChildren().removeAll();
				contentArea.getChildren().setAll(root);
				product.setStyle("-fx-background-color: transparent; ");
				billing.setStyle("-fx-background-color: transparent; ");
				company.setStyle("-fx-background-color: transparent; ");
				product.setStyle("-fx-background-color: transparent; ");
				adduser.setStyle("-fx-background-color: #ffffff; -fx-text-fill:black;");
				analytics.setStyle("-fx-background-color: transparent; ");
				order.setStyle("-fx-background-color: transparent; ");
				supplier.setStyle("-fx-background-color:transparent; ");
				stock.setStyle("-fx-background-color: transparent; ");
				backup.setStyle("-fx-background-color: transparent; ");
		    }
		    @FXML
		    void  backup(javafx.event.ActionEvent actionEvent)throws IOException {
		    	
				product.setStyle("-fx-background-color: transparent; ");
				billing.setStyle("-fx-background-color: transparent; ");
				company.setStyle("-fx-background-color: transparent; ");
				product.setStyle("-fx-background-color: transparent; ");
				adduser.setStyle("-fx-background-color:transparent; ");
				backup.setStyle("-fx-background-color: #ffffff; -fx-text-fill:black;");
				analytics.setStyle("-fx-background-color: transparent; ");
				order.setStyle("-fx-background-color: transparent; ");
				supplier.setStyle("-fx-background-color:transparent; ");
				stock.setStyle("-fx-background-color: transparent; ");
		    }
	
			@Override
			public void initialize(URL arg0, ResourceBundle arg1) {
				
				try {
				
					Parent root = FXMLLoader.load(getClass().getResource("billing.fxml"));
					contentArea.getChildren().removeAll();
					contentArea.getChildren().setAll(root);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}		   
			
}
