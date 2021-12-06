package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class InitialChatController {
    private Factory factory=new Factory();
    private PageMenu controller= factory.createPageMenu();
    @FXML
    protected void goToHome(ActionEvent event) throws IOException {
        controller.switchToHome(event);
    }
    @FXML
    protected void goToPersonalForm(ActionEvent event) throws IOException {
        controller.switchToPersonalForm(event);
    }
    @FXML
    protected void goToSettings(ActionEvent event) throws IOException {
        controller.switchToSettings(event);
    }
    @FXML
    protected void goToChat(ActionEvent event) throws IOException {
        controller.switchTo("chat.fxml",event,"Chat");
    }
    @FXML
    protected void goToSearch(ActionEvent event) throws IOException {
        controller.switchTo("search.fxml",event,"Search");
    }

}
