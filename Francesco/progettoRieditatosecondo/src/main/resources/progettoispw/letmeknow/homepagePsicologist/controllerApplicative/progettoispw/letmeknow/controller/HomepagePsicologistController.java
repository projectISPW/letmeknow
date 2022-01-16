package progettoispw.letmeknow.controller;

import progettoispw.letmeknow.controller.form.FormMeta;
import progettoispw.letmeknow.controller.utentiPsy.Form;
import progettoispw.letmeknow.controller.utentiPsy.UtentePsy;

import java.util.Vector;

public class HomepagePsicologistController implements FormMeta {
    private ControllerClass factory;
    private UtentePsy user;
    private Vector<Form>list;
    private float [][] innerList;
    private int row;
    public HomepagePsicologistController(){
        factory=new ControllerClass();
        user=new UtentePsy(factory.getUserUSR().getUserid());
        innerList=null;
    }
    int index=0;
    public float[] getList(){
        if(index<FORMSID.length){
          return innerList[index++];
        }else {
            return null;
        }
    }
    public void getLists(int month , int year){
        user.collectForms(month,year);
        list=user.getSum();
        int [] answers;
        int formid,counter;
        innerList= new float[FORMSID.length][7];
        for(Form elem:list){
            formid=elem.getFormid();
            counter=user.getCounter(formid);
            innerList[formid-1][0]=counter;
            answers= elem.getAnswers();
            for(int i=1;i<7;i++)innerList[formid-1][i]=(float)answers[i-1]/counter;
        }
    }
}
