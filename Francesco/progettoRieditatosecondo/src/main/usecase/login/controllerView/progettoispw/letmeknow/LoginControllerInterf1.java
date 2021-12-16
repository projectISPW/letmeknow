package progettoispw.letmeknow;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import progettoispw.letmeknow.bean.LoginBean;

import java.io.IOException;

public class LoginControllerInterf1 {
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
        }else {
            LoginBean bean=new LoginBean(labUser.getText(),labPassword.getText());
            String log = bean.exitValue();
            switch(log){
                case "usr":{
                    HomepagecontrollerInterf1.userid=labUser.getText();
                    controller.switchTo("homepage/interf1.fxml",event,"Home");
                    HomepagecontrollerInterf1 home=new HomepagecontrollerInterf1();
                    home.displayName("0123456");
                    return;
                }
                case "psy":{
                    controller.switchTo("homepagePsicologist/interf1.fxml",event,"Home");
                    PsicologistHomeController home=new PsicologistHomeController();
                    home.displayName("psicologo");
                }
            }
        }
    }}
