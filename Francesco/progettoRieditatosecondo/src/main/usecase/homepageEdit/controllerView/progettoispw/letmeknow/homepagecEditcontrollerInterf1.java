package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import progettoispw.letmeknow.bean.*;
import progettoispw.letmeknow.controller.UpdateObiettivoPersonaleController;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import static java.lang.Thread.sleep;

public class homepagecEditcontrollerInterf1 {
    private PageMenu controller= new PageMenu();    
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
    private Button save;

    public void initialize(){
        SliderBean sliderVal=new SliderBean("123456");
        Integer [] listaValori=sliderVal.exitValue();
        setSlider(empathySlider,listaValori[0]);
        setSlider(humorSlider,listaValori[1]);
        setSlider(positivitySlider,listaValori[2]);
        DescrizionePersonaleBean descrizione=new DescrizionePersonaleBean("123456");
        String text=descrizione.exitValue();
        personalDescription.setPromptText(text);
        ObiettivoPersonaleBean obb=new ObiettivoPersonaleBean("123456");
        goal.setPromptText(obb.exitObiettivo());
        tag.setPromptText(obb.exitTag());
        listaValori=obb.exitData();
        //System.out.println("in view "+text);
        date.setPromptText(" "+listaValori[0]+"-"+listaValori[1]+"-"+listaValori[2]);
    }
    public void  setSlider(ImageView image,int val){
        //ho fatto il controllo sintattico nel bean
        String url="photo/val";
        url=url+val+".png";
        //System.out.println(url);
        Image immagine=new Image(getClass().getResourceAsStream(url));
        image.setImage(immagine);
    }
    UpdateObiettivoPersonaleBean obiettivo=new UpdateObiettivoPersonaleBean("123456");
    UpdateDescrizionePersonaleBean descrizione = new UpdateDescrizionePersonaleBean("123456");
    @FXML
    public void saveChanges() throws ParseException {
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
        initialize();
    }
    public void off() {
        descrizione.setOff();
    }
    @FXML
    protected void goToHome(ActionEvent event) throws IOException {
        off();
        controller.switchToHome(event);
    }
    @FXML
    protected void goToChat(ActionEvent event) throws IOException {
        off();
        controller.switchToChat(event);
    }
    @FXML
    protected void goToPersonalForm(ActionEvent event) throws IOException {
        off();
        controller.switchToPersonalForm(event);
    }
    @FXML
    protected void takeTheForm(ActionEvent event) throws IOException {
        off();
        controller.switchTo("formToTake/interf1.fxml",event,"fill the form");
    }
}
