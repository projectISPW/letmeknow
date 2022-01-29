package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.utentipsy.Form;
import progettoispw.letmeknow.controller.utentipsy.UtentePsy;

import java.util.ArrayList;
import java.util.List;

public class HomepagePsychologistController {
    private UtentePsy user;
    private List<Form> list;
    private float [][] innerList;
    private int index;
    static final Integer [] FORMSID={1,2,3};
    public HomepagePsychologistController(){
        user= ControllerClass.getUserPsy();
        innerList=null;
    }
    public float[] getList(){
        if(index<FORMSID.length){
            return innerList[index++];
        }else {
            index=0;
            return null;
        }
    }
    public void getLists(int month , int year){
        index=0;
        user.collectForms(month,year);
        list=(ArrayList<Form>) user.getSum();
        int [] answers;
        int formid,counter;
        innerList= new float[FORMSID.length][7];
        for(Form elem:list){
            formid=elem.getFormid();
            counter=user.getCounter(formid);
            System.err.println("form id"+formid+"completed by "+counter);
            innerList[formid-1][0]=counter;
            answers= elem.getAnswers();
            for(int i=1;i<7;i++){
                innerList[formid-1][i]=(float)answers[i-1]/counter;
            }
        }

    }
    public void setSelected(int selectedInp){
        user.setSelected(innerList[selectedInp-1]);
    }
    public boolean setFeed(String input){
        return user.suggestQuestion(input);
    }
}
