package progettoispw.letmeknow;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import progettoispw.letmeknow.bean.SignupBean;


import java.util.Vector;

public class SignupControllerInterf1 {
    private Page controller= new Page();
    @FXML
    TextField email;
    @FXML
    TextField description;
    @FXML
    TextField goal;
    @FXML
    PasswordField pswd;
    @FXML
    PasswordField confirmpswd;
    @FXML
    Slider sl1;
    @FXML
    Slider sl2;
    @FXML
    Slider sl3;
    Slider [] sliders;
    @FXML
    Label lab1;
    @FXML
    Label lab2;
    @FXML
    Label lab3;
    @FXML
    Label emailCheck;
    @FXML
    Label pswdCheck;
    @FXML
    Label desCheck;
    @FXML
    Label slCheck;
    private int indice;
    SignupBean bean;
    public SignupControllerInterf1(){
        bean=new SignupBean();

    }
    public void initialize() {
        Label [] labels = new Label[]{lab1, lab2, lab3};
        sliders=new Slider[]{sl1,sl2,sl3};
        reset();
        for (int i=0;i<3;i++) {
            int finalI = i;
            sliders[i].valueProperty().addListener((observableValue, number, t1) -> {
                System.out.println(finalI);
                labels[finalI].setText("" + (int) sliders[finalI].getValue());
                labels[finalI].setOpacity(1);
            });
        }
    }
    @FXML
    protected void backToLogin() {
        controller.backTo();
    }
    private boolean check(Boolean bool,Label lab){
        if(bool==false)lab.setOpacity(1);
        return bool;
    }
    private void reset(){
        emailCheck.setOpacity(0);
        pswdCheck.setOpacity(0);
        desCheck.setOpacity(0);
        slCheck.setOpacity(0);
    }
    @FXML
    protected void save(ActionEvent event) {
        Boolean bool;
        String[] arr;
        int [] val;
        reset();
        bool=bean.checkEmail(email.getText(),true);
        if(check(bool,emailCheck)==false)return;
        bool=bean.checkPswd(pswd.getText(),confirmpswd.getText());
        if(check(bool,pswdCheck)==false)return;

        bool=bean.checkDescription(description.getText());
        if(check(bool,desCheck)==false)return;

        arr= new String[]{lab1.getText(), lab2.getText(), lab3.getText()};
        val=bean.checkVal(arr);
        bool=true;
        if(val==null)bool=false;
        if(check(bool,slCheck)==false)return;
        bool=bean.signupUSR(pswd.getText(),email.getText(),val, description.getText(), goal.getText());
        if(bool)backToLogin();
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("keep attention ");
            alert.setHeaderText("We weren't be able to retrieve your data, please try  again!");
            alert.setContentText("Please, fill Email and Password Fields. They cannot be empty.");
            if(alert.showAndWait().get()==ButtonType.OK) {
                System.out.println("Prompt: Empty Fields Alert");
                event.consume();
                return;
            }
        }
    }
}
