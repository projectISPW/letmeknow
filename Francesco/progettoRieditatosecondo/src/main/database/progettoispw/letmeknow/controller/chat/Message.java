package progettoispw.letmeknow.controller.chat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    private LocalDateTime date;
    private String reciver,sender,text;

    public void setDate(String dateSTR) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        date = LocalDateTime.parse(dateSTR, formatter);
    }

    public String getText() {
        return text;
    }
    public String getReciver() {
        return reciver;
    }

    public void setReciver(String reciver) {
        this.reciver = reciver;
    }

    public void setDateSTR(String dateSTR) {
        setDate(dateSTR);
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setText(String text) {
        this.text = text;
    }
    public void getStatus(){
        System.out.printf("this message was sended at .: %s from .: %s to .: %s  this was the text .: %s \n\n",date.toString(),sender,reciver,text);
    }
}
