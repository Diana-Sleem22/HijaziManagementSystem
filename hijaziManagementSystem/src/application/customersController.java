package application;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
public class customersController implements Initializable{

    @FXML
    private Button add;

    @FXML
    private TextField address;

    @FXML
    private TableColumn<customerModel, String> addressColumn;

    @FXML
    private TableView<customerModel> customerTable;

    @FXML
    private Button delete;

    @FXML
    private TextField firstname;

    @FXML
    private TableColumn<customerModel, String> firstnameColumn;

    @FXML
    private TextField lastname;

    @FXML
    private TableColumn<customerModel, String> lastnameColumn;

    @FXML
    private TableColumn<customerModel,String> phoneNumberColumn;

    @FXML
    private TextField phonenumber;

    @FXML
    private TextField searchTxt;

    @FXML
    private Button update;
    
     customerModel selectedCustomer;
     
     private ObservableList<customerModel> data =  FXCollections.observableArrayList();
    @FXML
    void add(ActionEvent event) throws IOException, ParseException {
    	customerModel sm = new customerModel(firstname.getText(),lastname.getText(),address.getText(),phonenumber.getText());
    	System.out.println(sm.toString());
    	  CommonFunctions.sendHTTPRequest("http://localhost:8080/registerUser", "POST","", sm.toString());
    		data.add( new customerModel(firstname.getText().toString(),lastname.getText().toString(),address.getText().toString(),phonenumber.getText().toString()));
    		customerTable.setItems(data);
    }

    @FXML
    void delete(ActionEvent event) throws IOException, ParseException {
    	customerModel cm = new 	customerModel(firstname.getText(),lastname.getText(),address.getText(),phonenumber.getText(),Integer.parseInt(selectedCustomer.getId()+""));
	    	System.out.println(cm);
			 CommonFunctions.sendHTTPRequest("http://localhost:8080/deleteUser", "DELETE", selectedCustomer.getId()+"" , cm.toString());
			int index = data.indexOf(selectedCustomer);
			data.remove(index);

			customerTable.setItems(data);
    }

    @FXML
    void update(ActionEvent event) throws IOException, ParseException {
    	customerModel cm = new 	customerModel(firstname.getText(),lastname.getText(),address.getText(),phonenumber.getText(),Integer.parseInt(selectedCustomer.getId()+""));
	    	System.out.println(cm);
			 CommonFunctions.sendHTTPRequest("http://localhost:8080/updateUser", "PUT", "", cm.toString());
			int index = data.indexOf(selectedCustomer);
			data.remove(index);
			data.add(index, cm);
			customerTable.setItems(data);

    }
   
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		data.clear();
		firstnameColumn.setCellValueFactory(new PropertyValueFactory("firstname"));
		lastnameColumn.setCellValueFactory(new PropertyValueFactory("lastname"));
		phoneNumberColumn.setCellValueFactory(new PropertyValueFactory("phoneNumber"));
		addressColumn.setCellValueFactory(new PropertyValueFactory("address"));

		searchTxt.textProperty().addListener((observable, oldValue, newValue) -> {
			try {
				searchCustomerByName(newValue);
			} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    });
	try {
		JSONObject responseAPI = CommonFunctions.sendHTTPRequest("http://localhost:8080/getAllCustomers", "GET", "", "");


        JSONArray arr = (JSONArray) responseAPI.get("data");



        for (int i = 0; i < arr.size(); i++) {
        	  JSONObject new_obj = (JSONObject) arr.get(i);


				data.add(new customerModel(new_obj.get("firstname").toString(), new_obj.get("lastname").toString(), new_obj.get("address").toString() ,new_obj.get("phoneNumber").toString(),Integer.parseInt(new_obj.get("id").toString())));
		}
		System.out.print(data);

		customerTable.setItems(data);
		
	      
		customerTable.setOnMouseClicked((MouseEvent event) -> {
		    if (event.getClickCount() > 1) {
		        onEdit();
		    }
		});
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

		
	}
	 public void searchCustomerByName (String text) throws IOException, ParseException {
		 String url = "";
		 if(text.equals("")) {
			 url = "http://localhost:8080/getAllCustomers";
		 }
		 else {
			 url = "http://localhost:8080/searchUser";
		 }
	    	JSONObject responseAPI = CommonFunctions.sendHTTPRequest(url, "GET", text, "");


	        JSONArray arr = (JSONArray) responseAPI.get("data");
	        data.clear();


	        for (int i = 0; i < arr.size(); i++) {
	        	  JSONObject new_obj = (JSONObject) arr.get(i);


	        		data.add(new customerModel(new_obj.get("firstname").toString(), new_obj.get("lastname").toString(), new_obj.get("address").toString() ,new_obj.get("phoneNumber").toString(),Integer.parseInt(new_obj.get("id").toString())));
			}
			System.out.print(data);

			customerTable.setItems(data);
	    }
	 public void onEdit() {
		    // check the table's selected item and get selected item
		    if (customerTable.getSelectionModel().getSelectedItem() != null) {

		        selectedCustomer = customerTable.getSelectionModel().getSelectedItem();
		        firstname.setText(   selectedCustomer.getFirstname());
		        lastname.setText(   selectedCustomer.getLastname());
		        phonenumber.setText(  selectedCustomer.getPhoneNumber());
		        address.setText( selectedCustomer.getAddress());
		    }
		}
}
