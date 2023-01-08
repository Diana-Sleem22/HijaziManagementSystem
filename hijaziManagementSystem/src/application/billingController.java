package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;

public class billingController implements Initializable {
	ProductModel selectedProduct = null;
	@FXML
	private Text totalPriceLpb;

	@FXML
	private Text totalPriceUsd;
	@FXML
	private Button customer;
	@FXML
	private TableColumn<ProductModel, String> barcode;
	@FXML
	private TableColumn<ProductModel, Integer> totlQt;
	@FXML
	private TableView<ProductModel> billingProductsTable;
	@FXML
	private TableColumn<ProductModel, Integer> quantity;
	@FXML
	private ComboBox<UserModel2> customersCombo;
	List<UserModel2> customers = new ArrayList<>();

	@FXML
	private TableColumn<ProductModel, Integer> unitprice;
	@FXML
	private TableColumn<ProductModel, String> productName;
	@FXML
	private Label value;
	int count = 0;
	@FXML
	private DatePicker orderDate;
	@FXML
	private TextField barcodeValue;
	private ObservableList<ProductModel> data = FXCollections.observableArrayList();

	@FXML
	private Label barcodeError;

	@FXML
	private Label customerError;

	@FXML
	private Label dateError;
	@FXML
	private Label quantityError;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		getAllCustomers();

		productName.setCellValueFactory(new PropertyValueFactory("name"));
		barcode.setCellValueFactory(new PropertyValueFactory("barcode"));
		quantity.setCellValueFactory(new PropertyValueFactory("quantitySelected"));
		unitprice.setCellValueFactory(new PropertyValueFactory("price"));
		totlQt.setCellValueFactory(new PropertyValueFactory("quantity"));

		billingProductsTable.setOnMouseClicked((MouseEvent event) -> {
			if (event.getClickCount() > 1) {
				onEdit();
			}
		});
	}

	void getAllCustomers() {
		try {
			JSONObject responseAPI = CommonFunctions.sendHTTPRequest("http://localhost:8080/getAllCustomers", "GET", "",
					"");
			JSONArray arr = (JSONArray) responseAPI.get("data");
			for (Object element : arr) {
				JSONObject new_obj = (JSONObject) element;
				customersCombo.getItems()
						.add(new UserModel2(new_obj.get("firstname").toString(), new_obj.get("lastname").toString(),
								new_obj.get("phoneNumber").toString(), Integer.parseInt(new_obj.get("id").toString())));
				customers.add(new UserModel2(new_obj.get("firstname").toString(), new_obj.get("lastname").toString(),
						new_obj.get("phoneNumber").toString(), Integer.parseInt(new_obj.get("id").toString())));
			}
			customersCombo.setCellFactory(new Callback<ListView<UserModel2>, ListCell<UserModel2>>() {

				@Override
				public ListCell<UserModel2> call(ListView<UserModel2> p) {

					final ListCell<UserModel2> cell = new ListCell<>() {

						@Override
						protected void updateItem(UserModel2 t, boolean bln) {
							super.updateItem(t, bln);

							if (t != null) {
								setText(t.getFirstname() + " " + t.getLastname());
							} else {
								setText(null);
							}
						}

					};

					return cell;
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

	@FXML
	void decrease(MouseEvent event) {
		if (selectedProduct != null) {
			int initialCount = count;
			int temp = Integer.parseInt(count + "") - 1;
			if (temp > -1) {
				count = temp;
				int index = -1;
				value.setText(Integer.toString(temp));
				ProductModel item = null;

				for (int i = 0; i < data.size(); i++) {
					item = data.get(i);
					if (item.getId() == selectedProduct.getId()) {
						index = i;
						item.setQuantitySelected(temp);
						int totalPrice = Integer.parseInt(totalPriceUsd.getText());
						totalPrice = totalPrice - (initialCount * item.getPrice());
						totalPrice = totalPrice + (temp * item.getPrice());

						totalPriceUsd.setText(totalPrice + "");
						totalPriceLpb.setText((totalPrice * exchangeRateSingletonModel.getInstance().getRate()) + "");
					}
				}
				data.set(index, item);

				billingProductsTable.setItems(data);

			}

		}
	}

	@FXML
	void increase(MouseEvent event) {
		if (selectedProduct != null) {
			int initialCount = count;

			int temp = Integer.parseInt(count + "") + 1;
			if (temp <= selectedProduct.getQuantity()) {
				count = temp;
				int index = -1;
				value.setText(Integer.toString(temp));
				ProductModel item = null;
				for (int i = 0; i < data.size(); i++) {
					item = data.get(i);
					if (item.getId() == selectedProduct.getId()) {
						index = i;
						item.setQuantitySelected(temp);
						int totalPrice = Integer.parseInt(totalPriceUsd.getText());
						totalPrice = totalPrice - (initialCount * item.getPrice());
						totalPrice = totalPrice + (temp * item.getPrice());
						totalPriceUsd.setText(totalPrice + "");
						totalPriceLpb.setText((totalPrice * exchangeRateSingletonModel.getInstance().getRate()) + "");
					}
				}

				data.set(index, item);
				billingProductsTable.setItems(data);

			}

		}
	}

	@FXML
	void customerPage(javafx.event.ActionEvent actionEvent) throws IOException {
//    	customer.setStyle("-fx-background-color:#c3c7c5; -fx-text-fill:black;");
		try {
			FXMLLoader root = new FXMLLoader(getClass().getResource("customers.fxml"));
			Parent root1 = (Parent) root.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			stage.setTitle("Customers");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	void searchProductsByBarCode(MouseEvent event) throws IOException, ParseException {
		if (!barcodeValue.getText().isEmpty()) {
			selectedProduct = null;
			count = 0;
			JSONObject responseAPI = CommonFunctions.sendHTTPRequest("http://localhost:8080/searchProductsByBarCode",
					"GET", barcodeValue.getText(), "");
			JSONArray arr = (JSONArray) responseAPI.get("data");
			if (arr.size() > 0) {
				JSONObject new_obj = (JSONObject) arr.get(0);
				data.add(new ProductModel(Integer.parseInt(new_obj.get("id") + ""), new_obj.get("name").toString(),
						new_obj.get("barcode").toString(), Integer.parseInt(new_obj.get("quantity") + ""),
						Integer.parseInt(new_obj.get("price") + ""), new_obj.get("companyFK") + "",
						new_obj.get("categoryFK") + "", "", 0));

				barcodeValue.setText("");
				billingProductsTable.setItems(data);
			}
		}
	}

	@FXML
	void addProduct(MouseEvent event) {

	}

	@FXML
	void saveOrder(MouseEvent event) throws IOException, ParseException {
		FilteredList<ProductModel> filteredList = new FilteredList<>(data, item -> item.getQuantitySelected() == 0);

		if ((customersCombo.getValue() + "").equals("null") || filteredList.size() != 0
				|| (orderDate.getValue() + "").equals("null")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("Empty Fields or some products have no quantity selected");

			alert.showAndWait();
		} else {
			LocalDate localDate = orderDate.getValue();
			Date sqlDate = Date.valueOf(localDate);
			invoiceModel inv = new invoiceModel(sqlDate, UserSingletonInstance.getInstance().getId(),
					customersCombo.getValue().getId());

			JSONObject response = CommonFunctions.sendHTTPRequest("http://localhost:8080/registerInvoice", "POST", "",
					inv.toString());

			int invoiceAddedID = Integer
					.parseInt(((JSONObject) ((JSONObject) ((JSONArray) (response.get("data"))).get(0)).get("invoice"))
							.get("id").toString());

			order or = new order(invoiceAddedID);
			JSONObject response2 = CommonFunctions.sendHTTPRequest("http://localhost:8080/registerOrder", "POST", "",
					or.toString());

			int orderAddedID = Integer
					.parseInt(((JSONObject) ((JSONObject) ((JSONArray) (response2.get("data"))).get(0)).get("order"))
							.get("id").toString());

			List<orderItems> orderItems = new ArrayList<orderItems>();
			List<ProductModel> productItems = new ArrayList<ProductModel>();

			for (int i = 0; i < data.size(); i++) {
				orderItems ot = new orderItems(data.get(i).getId(), data.get(i).getQuantitySelected(), orderAddedID);
				orderItems.add(ot);
				productItems.add(new ProductModel(data.get(i).getId(), data.get(i).getName(), data.get(i).getBarcode(),
						data.get(i).getQuantity() - data.get(i).getQuantitySelected(), data.get(i).getPrice(),
						data.get(i).getCompanyFK(), data.get(i).getCategoryFK()));
			}
			JSONObject response3 = CommonFunctions.sendHTTPRequest("http://localhost:8080/registerOrderItems", "POST",
					"", orderItems.toString());

			JSONObject response4 = CommonFunctions.sendHTTPRequest("http://localhost:8080/updateProducts", "PUT", "",
					productItems.toString());

			data.clear();
			billingProductsTable.setItems(data);
		}

	}

	void onEdit() {

		selectedProduct = billingProductsTable.getSelectionModel().getSelectedItem();
		count = selectedProduct.getQuantitySelected();
		value.setText(Integer.toString(count));

	}
}
