package progettoispw.letmeknow;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import progettoispw.letmeknow.Factory;
import progettoispw.letmeknow.PageMenu;
import progettoispw.letmeknow.bean.SliderBean;
import progettoispw.letmeknow.bean.*;

import java.io.IOException;
import java.util.Date;


public class HomepagecontrollerInterf1 {
    private Factory factory=new Factory();
    private PageMenu controller= factory.createPageMenu();
    @FXML
    private ImageView empathySlider;
    @FXML
    private ImageView humorSlider;
    @FXML
    private ImageView positivitySlider;
    @FXML
    private Label personalDescription;
    @FXML
    private Label tag;
    @FXML
    private Label goal;
    @FXML
    private Label date;
    protected static void displayName(TextField username){
        System.out.println("Prompt Username: "+username.getText());
    }
    protected static void displayPassword(PasswordField pw){
        System.out.println("Prompt Password: "+pw.getText());
    }
    public void initialize(){
        SliderBean sliderVal=new SliderBean("123456");
        Integer [] listaValori=sliderVal.exitValue();
        setSlider(empathySlider,listaValori[0]);
        setSlider(humorSlider,listaValori[1]);
        setSlider(positivitySlider,listaValori[2]);
        DescrizionePersonaleBean descrizione=new DescrizionePersonaleBean("123456");
        String text=descrizione.exitValue();
        personalDescription.setText(text);
        ObiettivoPersonaleBean obb=new ObiettivoPersonaleBean("123456");
        goal.setText(obb.exitObiettivo());
        tag.setText(obb.exitTag());
        Date data ;
        data=obb.exitData();
        date.setText(data.toString());
        //date.setText(" "+data.getYear()+"-"+data.getMonth()+"-"+data.getDay());
    }
    public void  setSlider(ImageView image,int val){
        //ho fatto il controllo sintattico nel bean
        String url="photo/val";
        url=url+val+".png";
        //System.out.println(url);
        Image immagine=new Image(getClass().getResourceAsStream(url));
        image.setImage(immagine);
    }

    @FXML
    protected void goToChat(ActionEvent event) throws IOException {
        controller.switchToChat(event);
    }

    @FXML
    protected void goToPersonalForm(ActionEvent event) throws IOException {
        controller.switchToPersonalForm(event);
    }

    @FXML
    protected void editProfile(ActionEvent event) throws IOException {
        controller.switchTo("homepageEdit/interf1.fxml",event,"Edit Profile");
    }
    @FXML
    protected void goToSettings(ActionEvent event) throws IOException {
        controller.switchToSettings(event);
    }
}
