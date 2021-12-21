package com.example.letmeknow;
import javafx.event.ActionEvent;

import java.io.IOException;
public  class PageMenu extends Page {
    public void switchToSettings(ActionEvent event)throws IOException {
        this.switchTo("Settings.fxml",event,"Settings");
    }
    public void switchToChat(ActionEvent event)throws IOException{
        this.switchTo("initialSearchAndChat.fxml",event,"Settings");
    }
    public void switchToPersonalForm(ActionEvent event)throws IOException{
        this.switchTo("personalForm.fxml",event,"Your Form");
    }
    public void switchToHome(ActionEvent event)throws IOException{
        this.switchTo("homepage.fxml",event,"Homepage");
    }

}

