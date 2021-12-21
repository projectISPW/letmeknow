package progettoispw.letmeknow.controller.chat;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Messages extends MessagesMeta {
    private String userid;
    private MessagesSQL messageData;
    private ResultSet rst;
    private Vector<Message> lastmessages;
    private Vector<Message> messages;
    private Vector<String>users;
    private String touched;
    public Messages(String who)  {
        try {
            userid=who;
            messageData=new MessagesSQL();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Vector<Message> getLast(){
        getUSR();
        lastmessages =new Vector<>();
        for(String user:users){
           chat(user);
           attachL(messages.lastElement());
       }
       return lastmessages;
    }
    public Message getLast(String usr){
        lastmessages =new Vector<>();
        chat(usr);
        return (messages.lastElement());
    }

    public Vector<String> getUsers() {
       return users;
    }

    public void attach(Message msg){
       messages.add(msg);
    }
    public void attachL(Message msg){
        lastmessages.add(msg);
    }
    public void attach(String usr){
        if (users.contains(usr)==false) {
            users.add(usr);
            //System.out.println(users);
        }
    }
    public void getUSR(){
        try {
            rst=messageData.getSR(userid);
            users=new Vector<>();
            while (rst.next()) {
                attach(rst.getString(TO));
                attach(rst.getString(FROM));
            }
            users.remove(users.firstElement());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Vector<Message> chat(String user2){
        try {
            rst=messageData.getSRchat(userid,user2);
            messages=new Vector<>();
            while (rst.next()) {
                Message message=new Message();
                message.setDateSTR(rst.getString(DATETIME));
                message.setText(rst.getString(TEXT));
                message.setSender(rst.getString(FROM));
                message.setReciver(rst.getString(TO));
                //message.getStatus();
                attach(message);
            }
            return messages;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void newMessage(String text,String to)  {
        try{messageData.newMessage(userid,to,text);}
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void setTouched(String touched) {
        this.touched = touched;
    }

    public String getTouched() {
        return "0000000";
    }
}
