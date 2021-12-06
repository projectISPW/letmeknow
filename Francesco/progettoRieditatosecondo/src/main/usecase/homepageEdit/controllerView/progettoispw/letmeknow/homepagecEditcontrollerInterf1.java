package progettoispw.letmeknow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import progettoispw.letmeknow.bean.DescrizionePersonaleBean;
import progettoispw.letmeknow.bean.ObiettivoPersonaleBean;
import progettoispw.letmeknow.bean.SliderBean;
import progettoispw.letmeknow.bean.UpdateDescrizionePersonaleBean;

import java.io.IOException;

public class homepagecEditcontrollerInterf1 {
    Factory factory =new Factory();
    PageMenu controller= factory.createPageMenu();
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
        text="by :"+listaValori[0]+"/"+listaValori[1]+"/"+listaValori[2];
        date.setPromptText(text);
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
    public void saveChanges(){
        UpdateDescrizionePersonaleBean descrizione=new UpdateDescrizionePersonaleBean("123456");
        descrizione.entryValue(personalDescription.getText());
        DescrizionePersonaleBean descrizione1=new DescrizionePersonaleBean("123456");
        String text=descrizione1.exitValue();
        personalDescription.setPromptText(text);

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
