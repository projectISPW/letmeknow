package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import progettoispw.letmeknow.bean.FormToTakeStatusBean;

import java.io.IOException;

public class formCollectionResultsInterf1 {
    PageMenu controller = new PageMenu();
    FormToTakeStatusBean bean;
    @FXML
    protected void goToSettings(ActionEvent event) throws IOException {
        controller.switchTo("settings/interf1.fxml",event,"Settings");
    }
    @FXML
    protected void goToChat(ActionEvent event) throws IOException {
        controller.switchTo("initialSearchAndChat/interf1.fxml",event,"What do you need ? ");
    }
    @FXML
    protected void goToHome(ActionEvent event) throws IOException {
        controller.switchTo("homepage/interf1.fxml",event,"Home");
    }
    @FXML
    protected void takeTheForm(ActionEvent event) throws IOException {
        controller.switchTo("formToTake/form1interf1.fxml",event,"homepage");
    }
    protected void takeForm1(ActionEvent event ){
        controller.switchTo("formToTake/form1interf1.fxml",event,"form1");
    }
    private void which(int i,ActionEvent event){
        bean=new FormToTakeStatusBean(i);
        String name,title;
        if(bean.getComplete()==6){
            name="formResult/form"+i+"interf1.fxml";
            title="form"+i;
            controller.switchTo(name,event,title);
        }
        else{
            name="formToTake/form"+i+"interf1.fxml";
            title="form"+i;
            controller.switchTo(name,event,title);
        }
    }
    @FXML
    protected void urResult(ActionEvent event) throws IOException {
        Button button=(Button) event.getTarget();
        switch(button.getText()){
            case "FORM 3":{
                which(3,event);
                break;
            }
            case "FORM 1":{
                which(1,event);
                break;
            }
            case "FORM 2":{
                which(2,event);
                break;
            }
        }

    }
}
