package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import progettoispw.letmeknow.bean.*;

public class VisitControllerInterf1 extends HomepagecontrollerInterf1{
    @FXML
    private AnchorPane currentPage;
    public VisitControllerInterf1() {
        bean=new HomepageBean(true);
        userid=bean.getUserID();
    }
    public void initialize(){
        super.initialize();
        if(userid==null)currentPage.getChildren().removeAll(currentPage.getChildren());
    }
    @FXML
    protected void goToSearch(ActionEvent event){
        PageSwitch.switchToSearch(event);
    }
    @FXML
    protected void touchChat(ActionEvent event){
        ISCBean chatBean=new ISCBean(0);
        chatBean.touched(userid);
        PageSwitch.switchTo("chat/interf1.fxml",event,"Chat");
    }
}
