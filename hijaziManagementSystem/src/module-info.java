module hijaziMangSystem {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	requires json.simple;


	opens application to javafx.graphics, javafx.fxml;

	 exports application;

}
