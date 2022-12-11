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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
public class supplierController implements Initializable{
	  @FXML
	    private TextField firstname;

	    @FXML
	    private TableColumn<SupplierModel, String> firstnameColumn;

	    @FXML
	    private TextField lastname;

	    @FXML
	    private TableColumn<SupplierModel, String> lastnameColumn;

	    @FXML
	    private TextField phoneNumber;

	    @FXML
	    private TableColumn<SupplierModel, String> phonenumberColumn;

	    @FXML
	    private TextField searchtxt;
	   SupplierModel selectedSupplier;
	    @FXML
	    private TableView<SupplierModel> supplierTable;
	    private ObservableList<SupplierModel> data =  FXCollections.observableArrayList();
	    @FXML
	    void addSupplier(ActionEvent event) throws IOException, ParseException{
	    	SupplierModel sm = new SupplierModel(firstname.getText(),lastname.getText(),phoneNumber.getText());
	    	System.out.println(sm.toString());
	    	  CommonFunctions.sendHTTPRequest("http://localhost:8080/registerUser", "POST","", sm.toString());
	    		data.add( new SupplierModel(firstname.getText().toString(),lastname.getText().toString(),phoneNumber.getText().toString()));
	    		supplierTable.setItems(data);
	    }

	    @FXML
	    void deleteSupplier(ActionEvent event) throws IOException, ParseException {
	     SupplierModel cm = new SupplierModel(firstname.getText(),lastname.getText(),phoneNumber.getText(),Integer.parseInt(selectedSupplier.getId()+""));
	    	System.out.println(cm);
			 CommonFunctions.sendHTTPRequest("http://localhost:8080/deleteUser", "DELETE", selectedSupplier.getId()+"" , cm.toString());
			int index = data.indexOf(selectedSupplier);
			data.remove(index);

			supplierTable.setItems(data);
	    }

	    @FXML
	    void updateSupplier(ActionEvent event) throws IOException, ParseException {
	    	  SupplierModel cm = new SupplierModel(firstname.getText(),lastname.getText(),phoneNumber.getText(),Integer.parseInt(selectedSupplier.getId()+""));
	    	System.out.println(cm);
			 CommonFunctions.sendHTTPRequest("http://localhost:8080/updateUser", "PUT", "", cm.toString());
			int index = data.indexOf(selectedSupplier);
			data.remove(index);
			data.add(index, cm);
			supplierTable.setItems(data);

	    }
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			data.clear();
			firstnameColumn.setCellValueFactory(new PropertyValueFactory("firstname"));
			lastnameColumn.setCellValueFactory(new PropertyValueFactory("lastname"));
			phonenumberColumn.setCellValueFactory(new PropertyValueFactory("phoneNumber"));
		try {
			JSONObject responseAPI = CommonFunctions.sendHTTPRequest("http://localhost:8080/getAllSuppliers", "GET", "", "");


	        JSONArray arr = (JSONArray) responseAPI.get("data");



	        for (int i = 0; i < arr.size(); i++) {
	        	  JSONObject new_obj = (JSONObject) arr.get(i);


					data.add(new SupplierModel(new_obj.get("firstname").toString(), new_obj.get("lastname").toString(),  new_obj.get("phoneNumber").toString(),Integer.parseInt(new_obj.get("id").toString())));
			}
			System.out.print(data);

			supplierTable.setItems(data);
			supplierTable.setOnMouseClicked((MouseEvent event) -> {
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
		 public void searchCompanyByName (String text) throws IOException, ParseException {
			 String url = "";
//			 if(text.equals("")) {
//				 url = "http://localhost:8080/getAllSuppliers";
//			 }
//			 else {
//				 url = "http://localhost:8080/searchCompanies";
//			 }
			 url = "http://localhost:8080/getAllSuppliers";
		    	JSONObject responseAPI = CommonFunctions.sendHTTPRequest(url, "GET", text, "");


		        JSONArray arr = (JSONArray) responseAPI.get("data");
		        data.clear();


		        for (int i = 0; i < arr.size(); i++) {
		        	  JSONObject new_obj = (JSONObject) arr.get(i);


					data.add(new SupplierModel(new_obj.get("firstname").toString(), new_obj.get("lastname").toString(),  new_obj.get("phoneNumber").toString(),Integer.parseInt(new_obj.get("id").toString())));
				}
				System.out.print(data);

				supplierTable.setItems(data);
		    }
		public void onEdit() {
		    // check the table's selected item and get selected item
		    if (supplierTable.getSelectionModel().getSelectedItem() != null) {

		        selectedSupplier = supplierTable.getSelectionModel().getSelectedItem();
		        firstname.setText( selectedSupplier.getFirstname());
		        lastname.setText( selectedSupplier.getLastname());
		         phoneNumber.setText(selectedSupplier.getPhoneNumber());
		    }
		}

}
