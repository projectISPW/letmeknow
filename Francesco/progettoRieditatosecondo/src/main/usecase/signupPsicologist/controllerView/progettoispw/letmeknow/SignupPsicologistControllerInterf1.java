package progettoispw.letmeknow;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import progettoispw.letmeknow.bean.SignupBean;

public class SignupPsicologistControllerInterf1 {
    SignupBean bean;
    @FXML
    TextField email;
    @FXML
    PasswordField password,confirmPassword;
    public SignupPsicologistControllerInterf1() {
        bean=new SignupBean();
    }

}
