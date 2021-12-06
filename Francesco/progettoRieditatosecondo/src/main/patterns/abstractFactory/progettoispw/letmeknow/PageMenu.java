package progettoispw.letmeknow;
import javafx.event.ActionEvent;

import java.io.IOException;
public  class PageMenu extends Page {
    public void switchToSettings(ActionEvent event)throws IOException {
        this.switchTo("settings/interf1.fxml",event,"Settings");
    }
    public void switchToChat(ActionEvent event)throws IOException{
        this.switchTo("initialSearchAndChat/interf1.fxml",event,"your result");
    }
    public void switchToPersonalForm(ActionEvent event)throws IOException{
        this.switchTo("formCollectionResults/interf1.fxml",event,"your result");
    }
    public void switchToHome(ActionEvent event)throws IOException{
        this.switchTo("homepage/interf1.fxml",event,"Homepage");
    }

}