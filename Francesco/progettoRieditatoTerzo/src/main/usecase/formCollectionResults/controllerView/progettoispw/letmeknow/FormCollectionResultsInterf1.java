
package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import progettoispw.letmeknow.bean.FormSetAnswer;
import progettoispw.letmeknow.bean.FormTouchedBean;
import progettoispw.letmeknow.bean.HomepageBean;
import progettoispw.letmeknow.controller.CollectionFormController;

public class FormCollectionResultsInterf1 {
    PageMenu PageSwitch;
    public static final String INTERF="interf1.fxml";
    @FXML
    protected Text idUser;
    public FormCollectionResultsInterf1(){
        PageSwitch =new PageMenu();
    }
    public void initialize(){
        HomepageBean bean=new HomepageBean(false);
        idUser.setText("User"+ bean.getUserID());
    }
    @FXML
    protected void goToSettings(ActionEvent event) {
        PageSwitch.switchToSettings(event);
    }
    protected  void which(int i,ActionEvent event){
        FormTouchedBean bean=new FormTouchedBean();
        bean.setFormTouched(i);
        CollectionFormController controller=new CollectionFormController();
        controller.setTouched(bean);
        String name;
        String title;
        FormSetAnswer formBean=new FormSetAnswer();
        if(formBean.getComplete()==6){
            name="formResult/form"+i+INTERF;
        }
        else{
            name="formToTake/form"+i+INTERF;
        } title="form"+i;
        PageSwitch.switchTo(name,event,title);
    }
    @FXML
    protected void urResult(ActionEvent event) {
        Button button=(Button) event.getTarget();
        switch(button.getText()){
            case "FORMSCODE 3":{
                which(3,event);
                break;
            }
            case "FORMSCODE 1":{
                which(1,event);
                break;
            }
            case "FORMSCODE 2":{
                which(2,event);
                break;
            }
            default:{
                event.consume();
            }
        }

    }
    @FXML
    public void takeForm(ActionEvent event){
        CollectionFormController controller=new CollectionFormController();
        controller.takeForm();
        FormSetAnswer innerBean=new FormSetAnswer();
        int val = innerBean.getFormId();
        if(innerBean.getComplete()<=6){
            PageSwitch.switchTo("formToTake/form"+val+INTERF,event,"form"+val);
        }
        else{
            PageSwitch.switchTo("formResult/form"+val+INTERF,event,"form"+val);
        }
    }
    @FXML
    protected  void goToISC(ActionEvent event){
        PageSwitch.switchToISC(event);
    }
    @FXML
    protected  void goToPersonalForm(ActionEvent event){
        PageSwitch.switchToHome(event);
    }
    @FXML
    protected  void goToHome(ActionEvent event){
        PageSwitch.switchToHome(event);}
}
