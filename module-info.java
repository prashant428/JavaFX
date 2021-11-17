module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens exercise1 to javafx.fxml;
    exports exercise1;
}