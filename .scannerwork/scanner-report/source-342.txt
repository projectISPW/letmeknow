package controller;

import com.example.letmeknow.Factory;
import com.example.letmeknow.PageMenu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageController {
    private Factory factory=new Factory();
    private PageMenu controller= factory.createPageMenu();

    @FXML
    private ImageView Sl3;
    @FXML
    private ImageView Sl2;
    @FXML
    private ImageView Sl1;
    protected static void displayName(TextField username){
        System.out.println("Prompt Username: "+username.getText());
    }
    protected static void displayPassword(PasswordField pw){
        System.out.println("Prompt Password: "+pw.getText());
    }
    /*
    @FXML
    protected void  sl(ActionEvent event) throws IOException {
        System.out.println(Sl1.getImage());
        //Sl1.setImage(im1);
        //Sl3.setImage(com.example.letmeknow.Photo.homepage.val0.png);
    }*/
    @FXML
    protected void goToChat(ActionEvent event) throws IOException {
        controller.switchToChat(event);
    }

    @FXML
    protected void goToPersonalForm(ActionEvent event) throws IOException {
        controller.switchToPersonalForm(event);
    }

    @FXML
    protected void editProfile(ActionEvent event) throws IOException {
        controller.switchTo("editProfile.fxml",event,"Edit Profile");
    }
    @FXML
    protected void goToSettings(ActionEvent event) throws IOException {
        controller.switchToSettings(event);
    }
}
