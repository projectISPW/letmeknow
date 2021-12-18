package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import progettoispw.letmeknow.bean.*;
import progettoispw.letmeknow.controller.HomepageController;


import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import static java.lang.Thread.sleep;

public class homepagecEditcontrollerInterf1 {
    private PageMenu controller=new PageMenu();
    @FXML
    private ImageView empathySlider;
    @FXML
    private ImageView humorSlider;
    @FXML
    private ImageView positivitySlider;
    @FXML
    private TextField personalDescription;
    @FXML
    private TextField tag;
    @FXML
    private TextField goal;
    @FXML
    private TextField date;
    @FXML
    private Text userName;
    private String userid;
    private HomepagecontrollerInterf1 home;
    private UpdateObiettivoPersonaleBean obiettivo;
    private UpdateDescrizionePersonaleBean descrizione;
    public homepagecEditcontrollerInterf1(){
        obiettivo=new UpdateObiettivoPersonaleBean();
        descrizione = new UpdateDescrizionePersonaleBean();
        home =new HomepagecontrollerInterf1();
    }
    public void initialize() throws InterruptedException {
        userid= obiettivo.getUserid();
        userName.setText("User : "+userid);
        SliderBean sliderVal=new SliderBean(userid);
        Integer [] listaValori=sliderVal.exitValue();
        home.setSlider(empathySlider,listaValori[0]);
        home.setSlider(humorSlider,listaValori[1]);
        home.setSlider(positivitySlider,listaValori[2]);
        DescrizionePersonaleBean descrizione=new DescrizionePersonaleBean(userid);//della Homepage
        String text=descrizione.exitValue();
        personalDescription.setPromptText(text);
        ObiettivoPersonaleBean obb=new ObiettivoPersonaleBean(userid);//della homepage
        goal.setPromptText(obb.exitObiettivo());
        tag.setPromptText(obb.exitTag());
        listaValori=obb.exitData();
        date.setPromptText(" "+listaValori[0]+"-"+listaValori[1]+"-"+listaValori[2]);
    }

    @FXML
    public void saveChanges()  {
        obiettivo.entryValue(goal.getText(), tag.getText(),date.getText());
        descrizione.entryValue(personalDescription.getText());
        personalDescription.setText("");
        goal.setText("");
        tag.setText("");
        date.setText("");
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            initialize();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void goToHome(ActionEvent event) throws IOException {
        controller.switchToHome(event);
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
    protected void takeTheForm(ActionEvent event) throws IOException {
        controller.switchTo("formToTake/interf1.fxml",event,"fill the form");
    }
}
