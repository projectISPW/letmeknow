package progettoispw.letmeknow.bean;

import progettoispw.letmeknow.controller.SignupController;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class SignupBean {
    SignupController controller;
    public SignupBean(){
        controller=new SignupController();
    }
    public boolean checkEmail(String email , boolean checkpresence){
            try {
                InternetAddress emailAddr = new InternetAddress(email);
                emailAddr.validate();
                if(!checkpresence)return true;
                return controller.checkMail(email);
            } catch (AddressException e) {
               // e.printStackTrace();
                return false;
            }
    }


    public boolean checkPswd(String str1,String str2){
        if(str1.equals("")||str1.equals(" "))return false;
        else if(str1.length()>20)return false;
        return str1.equals(str2);
    }
    public boolean checkDescription(String description){
        return description.contains("#");
    }
    public int[] checkVal(String [] val) {
        System.out.println(val[0]+val[1]+val[2]);
        int[] returnArr = new int[3];
        int i;
        for (i = 0; i < val.length; i++){
            returnArr[i] = Integer.parseInt(val[i]);
            if (returnArr[i] < 1 || returnArr[i] >5 ) return null;
        }
        return returnArr;
    }
    public boolean signupUSR(String password,String email,int [] val,String description,String goal){
        return controller.signup(password,"usr",email,val,description,goal);
    }
    public boolean signupPSY(String password,String email){
        return controller.signup(password,"psy",email);
    }
}
