package progettoispw.letmeknow;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {
    private Factory factory=new Factory();
    private PageMenu controller= factory.createPageMenu();
    @FXML
    private ComboBox<String> comb;
    @FXML
    protected void goEditProf(ActionEvent event) throws IOException {
        controller.switchTo("homepageEdit/interf1.fxml", event,"Homepage");
    }

    @FXML
    protected void goToLogin(ActionEvent event) throws IOException {
        controller.goTo("login", event);
    }

    @FXML
    protected void goToHome(ActionEvent event) throws IOException {
        controller.switchToHome(event);

    }
    @FXML
    protected void goToChat(ActionEvent event) throws IOException {
        controller.switchToChat(event);
    }
    @FXML
    protected void switchToRecoverPswd(ActionEvent event) throws IOException {
       controller.goTo("recover password",event);
    }
    @FXML
    protected void goToPersonalForm(ActionEvent event) throws IOException {
        controller.switchToPersonalForm(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb){
        comb.setItems(FXCollections.observableArrayList("Italiano", "Inglese"));
    }}

