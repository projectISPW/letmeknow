package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.chat.Message;
import progettoispw.letmeknow.controller.chat.Messages;
import progettoispw.letmeknow.controller.utenti.SalvaUtente;

import java.util.Vector;

public class SignupController {
   private SalvaUtente user;
   public SignupController(){
       user=new SalvaUtente();
   }
   public boolean checkMail(String input){
       System.out.println("controllo mail nel controller"+user.checkEmail(input));
       return !user.checkEmail(input);
   }
   public boolean signup(String password,String type,String email,int [] val,String description,String goal){
       return user.registrationUSR(password,email,type,val,description,goal);
   }
}
