package application;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
public class productsController implements Initializable{
    @FXML
    private Button category;
    @FXML
    private ComboBox<String> categoryData;
    @FXML
    private ComboBox<String> companyData;
    @FXML
    private ComboBox<String> supplierData;
    private ObservableList<CategoryModel> data =  FXCollections.observableArrayList();
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
		categoryData();
		companyData() ;
		supplierData();
	}
	public void categoryData() {
		try {
			JSONObject responseAPI = CommonFunctions.sendHTTPRequest("http://localhost:8080/getAllCategories", "GET", "", "");
			JSONArray arr = (JSONArray) responseAPI.get("data");
			 for (Object element : arr) {
	        	  JSONObject new_obj = (JSONObject) element;
				categoryData.getItems().add(new_obj.get("name").toString());
			}


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void companyData() {
		try {
			JSONObject responseAPI = CommonFunctions.sendHTTPRequest("http://localhost:8080/getAllCompanies", "GET", "", "");
			JSONArray arr = (JSONArray) responseAPI.get("data");
			 for (Object element : arr) {
	        	  JSONObject new_obj = (JSONObject) element;
	        	  companyData.getItems().add(new_obj.get("name").toString());
			}



		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void supplierData() {
		try {
			JSONObject responseAPI = CommonFunctions.sendHTTPRequest("http://localhost:8080/getAllSuppliers", "GET", "", "");
			JSONArray arr = (JSONArray) responseAPI.get("data");
			 for (Object element : arr) {
	        	  JSONObject new_obj = (JSONObject) element;
	        	  supplierData.getItems().add(new_obj.get("firstname").toString());
			}



		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
