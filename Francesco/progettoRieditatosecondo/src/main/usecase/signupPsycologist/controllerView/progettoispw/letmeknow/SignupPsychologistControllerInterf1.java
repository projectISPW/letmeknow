package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import progettoispw.letmeknow.bean.SignupBean;

import java.util.Optional;

public class SignupPsychologistControllerInterf1 {
    protected SignupBean bean;
    @FXML
    protected TextField email;
    @FXML
    PasswordField pswd;
    @FXML
    PasswordField confirmpswd;
    @FXML
    Label emailCheck;
    @FXML
    Label pswdCheck;
    SignupControllerInterf1 signupController;
    public SignupPsychologistControllerInterf1() {
        bean=new SignupBean();
        signupController=new SignupControllerInterf1();
    }
    public void initialize(){
        signupController.reset();
    }

    @FXML
    protected void goToLogin() {
            Page controller=new Page();
            controller.backTo();
        }

    protected  void save (ActionEvent event) {
       signupController.checkMailPswd(event,true);
    }
}
