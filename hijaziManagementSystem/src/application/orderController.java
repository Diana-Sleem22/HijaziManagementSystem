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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class orderController implements Initializable {
	orderInvoice oi = null;

	@FXML
	private TableColumn<?, ?> orderAssignee;

	@FXML
	private TableColumn<?, ?> orderDate;

	@FXML
	private DatePicker orderForDate;

	@FXML
	private TableColumn<?, ?> orderNumber;

	@FXML
	private TableColumn<?, ?> orderOwner;

	@FXML
	private TableView<orderInvoice> ordersTable;
	private ObservableList<orderInvoice> data = FXCollections.observableArrayList();
	orderItemsDetails selectedItem;
	@FXML
	private TextField customerName;

	void getOrdersByCustomerNameOrDate(String newValue) throws IOException, ParseException {
		JSONObject responseAPI;

		responseAPI = CommonFunctions.sendHTTPRequest("http://localhost:8080/getOrdersByCustomerNameOrDate", "GET",
				newValue, "");
		JSONArray arr = (JSONArray) responseAPI.get("data");
		data.clear();
		for (Object element : arr) {
			JSONObject new_obj = (JSONObject) element;

			data.add(new orderInvoice(Integer.parseInt(new_obj.get("id") + ""), "order#" + new_obj.get("id") + "",
					new_obj.get("assigneeName") + "", new_obj.get("customerName") + "", new_obj.get("date") + ""));
		}
		if (ordersTable != null) {
			ordersTable.setItems(data);
		}
	}

	void getOrdersByCustomerName() throws IOException, ParseException {
		JSONObject responseAPI;

		responseAPI = CommonFunctions.sendHTTPRequest("http://localhost:8080/getOrdersByCustomerNameOrDate", "GET",
				customerName.getText(), "");
		JSONArray arr = (JSONArray) responseAPI.get("data");
		data.clear();
		for (Object element : arr) {
			JSONObject new_obj = (JSONObject) element;

			data.add(new orderInvoice(Integer.parseInt(new_obj.get("id") + ""), "order#" + new_obj.get("id") + "",
					new_obj.get("assigneeName") + "", new_obj.get("customerName") + "", new_obj.get("date") + ""));
		}
		if (ordersTable != null) {
			ordersTable.setItems(data);
		}
	}

	void getAllOrders() throws IOException, ParseException {
		JSONObject responseAPI;

		responseAPI = CommonFunctions.sendHTTPRequest("http://localhost:8080/getOrders", "GET", "", "");
		JSONArray arr = (JSONArray) responseAPI.get("data");

		for (Object element : arr) {
			JSONObject new_obj = (JSONObject) element;

			data.add(new orderInvoice(Integer.parseInt(new_obj.get("id") + ""), "order#" + new_obj.get("id") + "",
					new_obj.get("assigneeName") + "", new_obj.get("customerName") + "", new_obj.get("date") + ""));
		}
		if (ordersTable != null) {
			ordersTable.setItems(data);
		}
	}

	public void onEdit() throws IOException, ParseException {
		// check the table's selected item and get selected item
		if (ordersTable.getSelectionModel().getSelectedItem() != null) {

			try {
				TableView<orderItemsDetails> orderItemsTable = new TableView<orderItemsDetails>();
				TableColumn<orderItemsDetails, Integer> QuantityColumn = new TableColumn<>("Product Quantity");

				TableColumn<orderItemsDetails, Integer> priceColumn = new TableColumn<>("Product Price");

				TableColumn<orderItemsDetails, String> productNameColumn = new TableColumn<>("Product Name");

				TableColumn<orderItemsDetails, Integer> totalPriceColumn = new TableColumn<>("Total Price USD");

				
				productNameColumn.setCellValueFactory(new PropertyValueFactory("name"));
				QuantityColumn.setCellValueFactory(new PropertyValueFactory("quantity"));
				priceColumn.setCellValueFactory(new PropertyValueFactory("price"));
				totalPriceColumn.setCellValueFactory(new PropertyValueFactory("totalPriceUsd"));
				
				productNameColumn.setStyle("-fx-background-color:  white");
				QuantityColumn.setStyle("-fx-background-color:  white");
				priceColumn.setStyle("-fx-background-color: white");
				totalPriceColumn.setStyle("-fx-background-color: white");
				
				Stage stage = new Stage();
				orderItemsTable.getColumns().add(productNameColumn);
				orderItemsTable.getColumns().add(QuantityColumn);
				orderItemsTable.getColumns().add(priceColumn);
				orderItemsTable.getColumns().add(totalPriceColumn);
				 Pane pane = new Pane();
			        
			        // Create a label
			        Label label = new Label();
			        label.setText("Hello World");
			        
			        // Add the label to the pane
			        pane.getChildren().add(label);
				Scene s = new Scene(orderItemsTable,370, 200);
				stage.setResizable(false);
				stage.setScene(s);
              
				stage.setTitle("Customers");
				int id = ordersTable.getSelectionModel().getSelectedItem().getOrderID();
				JSONObject responseAPI;

				responseAPI = CommonFunctions.sendHTTPRequest("http://localhost:8080/getOrderItems", "GET", id + "",
						"");
				JSONArray arr = (JSONArray) responseAPI.get("data");
				ObservableList<orderItemsDetails> orderItems = FXCollections.observableArrayList();

				for (Object element : arr) {
					JSONObject new_obj = (JSONObject) element;

					orderItems.add(new orderItemsDetails(Integer.parseInt(new_obj.get("quantity") + ""),
							Integer.parseInt(new_obj.get("price") + ""), new_obj.get("name") + ""));

				}
				orderItemsTable.setItems(orderItems);
				stage.show();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		try {

			getAllOrders();

			orderForDate.setOnAction(event -> {
				try {
					getOrdersByCustomerNameOrDate(orderForDate.getValue().toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			});
			customerName.setOnKeyReleased(event -> {
				try {
					getOrdersByCustomerName();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			});
			// TODO Auto-generated method stub
			if (orderNumber != null) {
				orderNumber.setCellValueFactory(new PropertyValueFactory("orderName"));
			}
			if (orderAssignee != null) {
				orderAssignee.setCellValueFactory(new PropertyValueFactory("assigneeName"));
			}
			if (orderOwner != null) {
				orderOwner.setCellValueFactory(new PropertyValueFactory("customerName"));
			}
			if (orderDate != null) {
				orderDate.setCellValueFactory(new PropertyValueFactory("date"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (ordersTable != null) {
			ordersTable.setOnMouseClicked((MouseEvent event) -> {
				if (event.getClickCount() > 1) {
					try {
						onEdit();
					} catch (IOException | ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
	}

}
