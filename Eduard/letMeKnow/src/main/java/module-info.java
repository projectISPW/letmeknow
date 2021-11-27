module com.example.letmeknow {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.letmeknow to javafx.fxml;
    exports com.example.letmeknow;
}