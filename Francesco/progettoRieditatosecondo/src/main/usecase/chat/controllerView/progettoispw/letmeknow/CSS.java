package progettoispw.letmeknow;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CSS {
    private  String text;
    private Label label;
    private WordCheck check;
    private Integer htext;
    private Label lastmessage;
    private double hmsg;
    private double ystart;
    private double hspacing;
    private double aumenta;
    public CSS(){
        check=new WordCheck(5,30);
        hmsg=0;
        hspacing=30;
        lastmessage=null;
        ystart=0;
    }
    public void setText(String input){
        text=input;
    }

    public double getAumenta() {
        return aumenta;
    }

    public void general(){
        label =new Label(check.check(text));// prende il testo con gli invio
        label.setFont(Font.font("Gill Sans MT", FontWeight.BOLD,18));
        //label.setMinWidth(200);
        label.setPrefWidth(350);
        label.setMinHeight(60);
        if(lastmessage == null){
            ystart =hspacing;
        }else{
            ystart=lastmessage.getTranslateY()+hmsg+hspacing;
        }
        label.setTranslateY(ystart);
        hmsg= check.highText();
        aumenta=ystart+hmsg+hspacing;
    }
    public Label getMessageRecived(){
        general();
        label.setTextFill(Color.rgb(43,43,43,0.7));
        label.setTranslateX(-5);

        label.setStyle("-fx-padding: 0 0 0 30");
        label.setBackground(new Background(new BackgroundFill(Color.rgb(214,214,214),new CornerRadii(18.0),new Insets(-5.0))));
        lastmessage=label;
        return label;
    }
    public Label getMessageSended(){
        general();
        label.setTextFill(Color.WHITE);
        label.setStyle("-fx-padding: 0 60 0 0");
        label.setTranslateX(100);
        label.setBackground(new Background(new BackgroundFill(Color.rgb(55, 125, 255, 0.69),new CornerRadii(18.0),new Insets(-5.0))));
        lastmessage=label;
        return label;
    }
}
