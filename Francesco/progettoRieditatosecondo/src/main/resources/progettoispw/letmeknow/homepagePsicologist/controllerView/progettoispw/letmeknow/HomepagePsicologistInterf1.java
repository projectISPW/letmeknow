package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import progettoispw.letmeknow.bean.HomepagePsicologistBean;

public class HomepagePsicologistInterf1 {
    HomepagePsicologistBean bean;
    Page controller=new Page();
    @FXML
    Label count1,count2,count3;
    public HomepagePsicologistInterf1(){
        bean=new HomepagePsicologistBean();
    }
    public void initialize(){
        count1.setText("completed by  :\n"+(int)bean.getForms()[0]+"users");
        count2.setText("completed by  :\n"+(int)bean.getForms()[0]+"users");
        count3.setText("completed by  :\n"+(int)bean.getForms()[0]+"users");
    }

    public void goToResult1(ActionEvent actionEvent) {

    }

    public void goToResult2(ActionEvent actionEvent) {
    }

    public void goToResult3(ActionEvent actionEvent) {
    }
}
