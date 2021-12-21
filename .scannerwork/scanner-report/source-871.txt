package controller;

import com.example.letmeknow.Factory;
import com.example.letmeknow.Page;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    private Factory factory=new Factory();
    private Page controller= factory.createPage();
    @FXML
    private PasswordField labPassword;
    @FXML
    private TextField labUser;

    @FXML
    protected void switchToSignup(ActionEvent event) throws IOException{
        //controller.switchTo("signup.fxml",event,"Signup");
        controller.goTo("signup",event);
    }
    @FXML
    protected void switchToRecoverPswd(ActionEvent event) throws IOException {
        controller.switchTo("recoverpassword.fxml",event,"recover password");
        //controller.goTo("recover password",event);
    }
    @FXML
    protected void switchToSignUpPsych(ActionEvent event) throws IOException {
        controller.switchTo("signUpPsych.fxml",event,"Signup");
    }
    @FXML
    protected void switchToHome(ActionEvent event) throws IOException {
        if(labUser.getText().equals("") || labPassword.getText().equals(""))
        {
            //Alert Dialog Message per campi email e password vuoti
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Empty Fields!");
            alert.setHeaderText("Empty Email / Password Field");
            alert.setContentText("Please, fill Email and Password Fields. They cannot be empty.");
            if(alert.showAndWait().get()==ButtonType.OK) {
                System.out.println("Prompt: Empty Fields Alert");
                event.consume();
            }
        }else if(labUser.getText().equals("psicologo") ){
            PsicologistHomeController.displayName(labUser);
            PsicologistHomeController.displayPassword(labPassword);
            controller.switchTo("psicologistHome.fxml",event,"Home");
        }else {
            HomePageController.displayName(labUser);
            HomePageController.displayPassword(labPassword);
            controller.switchTo("homepage.fxml",event,"Home");
        }
    }}
