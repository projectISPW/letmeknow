package progettoispw.letmeknow;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {
    private Page controller= new Page();
    @FXML
    private PasswordField labPassword;
    @FXML
    private TextField labUser;

    @FXML
    protected void switchToSignup(ActionEvent event) throws IOException{
        //controller.switchTo("signup.fxml",event,"Signup");
        controller.switchTo("signup/interf1.fxml",event,"Signup");
        //controller.goTo("signup",event);
    }
    @FXML
    protected void switchToRecoverPswd(ActionEvent event) throws IOException {
        controller.switchTo("recoverpassword/interf1.fxml",event,"Recover password");
        //controller.switchTo("recover password",event);
    }
    @FXML
    protected void switchToSignUpPsych(ActionEvent event) throws IOException {
        controller.switchTo("signupPsicologist/interf1.fxml",event,"Signup");
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
            controller.switchTo("psicologistHome/interf1.fxml",event,"Home");
        }else {
            HomepagecontrollerInterf1.displayName(labUser);
            HomepagecontrollerInterf1.displayPassword(labPassword);
            controller.switchTo("homepage/interf1.fxml",event,"Home");
        }
    }}
