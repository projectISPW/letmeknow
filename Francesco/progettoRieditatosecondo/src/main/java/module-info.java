module progettoispw.letmeknow {
    requires javafx.controls;
    requires javafx.fxml;


    opens progettoispw.letmeknow to javafx.fxml;
    exports progettoispw.letmeknow;
    //exports progettoispw.letmeknow.photo;
    opens progettoispw.letmeknow.photo to javafx.fxml;

    //exports progettoispw.letmeknow.viewcontroller;
   // opens progettoispw.letmeknow.viewcontroller to javafx.fxml;
    //exports progettoispw.letmeknow;
    //opens progettoispw.letmeknow to javafx.fxml;
}