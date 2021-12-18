package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.text.Text;
import progettoispw.letmeknow.bean.beanResultSearch;

import java.io.IOException;

public class ResultSearchControllerInterf1 {
    PageMenu controller=new PageMenu();
    @FXML
    Group g1,g2,g3,g4;
    Group[]group;
    @FXML
    Text uid1, uid2,uid3,uid4;
    Text[] vUid;
    String [] strUid=new String[4];
    @FXML
    Text des1,des2,des3,des4;
    Text [] vDes;
    String [] strDes=new String[4];
    @FXML
    Text goal1,goal2,goal3,goal4;
    Text [] vGoal;
    String [] strGoal=new String[4];
    int nval=4;
    public void initialize(){
        beanResultSearch bean=new beanResultSearch(nval);
        vUid=new  Text[]{uid1,uid2,uid3,uid4};
        vDes=new Text[]{des1,des2,des3,des4};
        vGoal=new Text[]{goal1,goal2,goal3,goal4};
        group=new Group[]{g1,g2,g3,g4};
        outputVal();
    }
    beanResultSearch bean =new beanResultSearch(nval);
    @FXML
    public void outputVal(){
        for(int i=0;i<group.length;i++){
            if (group[i].getOpacity()==0)group[i].setOpacity(1);
        }
        strDes= bean.exitDes();
        strGoal=bean.exitGoal();
        strUid= bean.exitUID();
        for(int i=0;i<nval;i++){
            if(strUid[i]==null || strDes[i]==null) group[i].setOpacity(0);
            vUid[i].setText("Id:"+strUid[i]);
            vDes[i].setText("About me: " +strDes[i]);
            vGoal[i].setText("Working on: "+strGoal[i]);
        }
    }
    @FXML
    protected void goBack(ActionEvent event) throws IOException {
        controller.switchTo("search/interf1.fxml",event,"Search");
    }
    @FXML
    protected void goHomeOtr(ActionEvent event) throws IOException {
        controller.switchTo("homepageOthers/interf1.fxml",event,"Visit");
    }
    @FXML
    protected void goChat(ActionEvent event) throws IOException {
        controller.switchTo("homepageOthers/interf1.fxml",event,"Chat");
    }
    @FXML
    protected void goToPersonalForm(ActionEvent event) throws IOException {
        controller.switchToPersonalForm(event);
    }
    @FXML
    protected void goToHome(ActionEvent event) throws IOException {
        controller.switchToHome(event);
    }

}
/*






visita altro profilo






 */