module tp5 {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	requires java.sql;
	exports application;
	opens application to javafx.graphics, javafx.fxml;
	
}
