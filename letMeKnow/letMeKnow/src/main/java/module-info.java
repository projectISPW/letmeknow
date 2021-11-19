module com.example.letmeknow {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.letmeknow to javafx.fxml;
    exports com.example.letmeknow;
}