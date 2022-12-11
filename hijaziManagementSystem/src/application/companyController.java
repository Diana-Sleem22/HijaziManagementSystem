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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class companyController implements Initializable {
	CompanyModel selectedCompany;
	  @FXML
	    private Button addCompanyBtn;

	    @FXML
	    private TextField companyNameInput;

	    @FXML
	    private TextField companyPhoneInput;
	    @FXML
	    private TableColumn<CompanyModel, String> companyNameColumn;
	    @FXML
	    private TableColumn<CompanyModel,String> companyPhoneColumn;
	    @FXML
	    private TableView<CompanyModel>companyTable;
	    private ObservableList<CompanyModel> data =  FXCollections.observableArrayList();
	    @FXML
	    private TextField searchtxt;

	    @FXML
	    void registerCompany(ActionEvent event) throws IOException, ParseException {
			CompanyModel cm = new CompanyModel(companyNameInput.getText(), companyPhoneInput.getText());
	    	System.out.println(cm.toString());
	     CommonFunctions.sendHTTPRequest("http://localhost:8080/registerCompany", "POST","", cm.toString());
	    	data.add( new CompanyModel(companyNameInput.getText().toString(), companyPhoneInput.getText().toString()));
			companyTable.setItems(data);
			companyNameInput.setText("");
			companyPhoneInput.setText("");
	    }
	    @FXML
	    void updateCompany(ActionEvent event) throws IOException, ParseException {
	    	CompanyModel cm = new CompanyModel(companyNameInput.getText(),companyPhoneInput.getText() ,Integer.parseInt(selectedCompany.getId()+""));
	    	System.out.println(cm);
			 CommonFunctions.sendHTTPRequest("http://localhost:8080/updateCompany", "PUT", "", cm.toString());
			int index = data.indexOf(selectedCompany);
			data.remove(index);
			data.add(index, cm);
			companyTable.setItems(data);


	    }




	    @FXML
	    void deleteCompany(ActionEvent event) throws IOException, ParseException {
	    	CompanyModel cm = new CompanyModel(companyNameInput.getText(),companyPhoneInput.getText() ,Integer.parseInt(selectedCompany.getId()+""));
	    	System.out.println(cm);
			 CommonFunctions.sendHTTPRequest("http://localhost:8080/deleteCompany", "DELETE",selectedCompany.getId()+"" , cm.toString());
			int index = data.indexOf(selectedCompany);
			data.remove(index);

			companyTable.setItems(data);

	    }

	    @FXML
	    void searchCompany(KeyEvent event) throws IOException, ParseException {


	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			data.clear();
			companyNameColumn.setCellValueFactory(new PropertyValueFactory("name"));
			companyPhoneColumn.setCellValueFactory(new PropertyValueFactory("phone"));
			searchtxt.textProperty().addListener((observable, oldValue, newValue) -> {
				try {
					searchCompanyByName(newValue);
				} catch (IOException | ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    });
			try {
				JSONObject responseAPI = CommonFunctions.sendHTTPRequest("http://localhost:8080/getAllCompanies", "GET", "", "");


		        JSONArray arr = (JSONArray) responseAPI.get("data");



		        for (int i = 0; i < arr.size(); i++) {
		        	  JSONObject new_obj = (JSONObject) arr.get(i);


					data.add(new CompanyModel(new_obj.get("name").toString(), new_obj.get("phone").toString(), Integer.parseInt(new_obj.get("id").toString())));
				}
				System.out.print(data);

				companyTable.setItems(data);
				companyTable.setOnMouseClicked((MouseEvent event) -> {
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
			 if(text.equals("")) {
				 url = "http://localhost:8080/getAllCompanies";
			 }
			 else {
				 url = "http://localhost:8080/searchCompanies";
			 }
		    	JSONObject responseAPI = CommonFunctions.sendHTTPRequest(url, "GET", text, "");


		        JSONArray arr = (JSONArray) responseAPI.get("data");
		        data.clear();


		        for (int i = 0; i < arr.size(); i++) {
		        	  JSONObject new_obj = (JSONObject) arr.get(i);


					data.add(new CompanyModel(new_obj.get("name").toString(), new_obj.get("phone").toString(), Integer.parseInt(new_obj.get("id").toString())));
				}
				System.out.print(data);

				companyTable.setItems(data);
		    }
		public void onEdit() {
		    // check the table's selected item and get selected item
		    if (companyTable.getSelectionModel().getSelectedItem() != null) {

		        selectedCompany = companyTable.getSelectionModel().getSelectedItem();
		       companyNameInput.setText(selectedCompany.getName());
		       companyPhoneInput.setText(selectedCompany.getPhone());
		    }
		}

}
