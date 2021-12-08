package progettoispw.letmeknow.bean;


import progettoispw.letmeknow.controller.ObiettivoPersonaleController;
import progettoispw.letmeknow.controller.UpdateObiettivoPersonaleController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UpdateObiettivoPersonaleBean {
    private String userid;
    private String newObb;
    private String newTag;
    private String newScadenza;
    SimpleDateFormat dateParser=new SimpleDateFormat("yyyy/MM/dd");
    private Date data;
    private int anno;
    private int mese;
    private int giorno;
    private Calendar cal=Calendar.getInstance();
    private ObiettivoPersonaleBean padre=new ObiettivoPersonaleBean("123456");
    private UpdateObiettivoPersonaleController controller;
    public UpdateObiettivoPersonaleBean(String user) {
        userid=user;
    }
    public void check(String ValueObb,String ValueTag, String ValueData) throws ParseException {
        if(ValueObb!="")newObb=ValueObb;
        else {
            newObb =padre.exitObiettivo();
        }
        if(ValueTag!=""){
            if(ValueTag.toCharArray()[0]!='#'){
                System.err.println("error occurred on the tag");
                newTag=padre.exitTag();
            }else{
                newTag=ValueTag;
            }
        }else{
            newTag=padre.exitTag();
        }
        if(ValueData!=""){
            newScadenza=ValueData;
            data=dateParser.parse(ValueData);

        }
        else{
            data=padre.exitData();
        }
    }

    public Date checkData(Date data){
        if(cal.YEAR == data.getYear()  || data.getYear()==(cal.YEAR+1)){
            return data;
        }
        else{
            System.err.println(" NEL UPDATE Non puoi tornare indietro nel tempo attento all Anno  ");
            return createData();
        }


    }
    public Date createData(){
        if(Calendar.MONTH<6){
            return (new Date( (cal.YEAR),cal.MONTH+6,cal.DAY_OF_MONTH));
        }
        else{
            return (new Date((cal.YEAR) +1,(cal.MONTH+6)%12,cal.DAY_OF_MONTH));
        }
    }
    public void entryValue(String ValueObb,String ValueTag, String ValueData) throws ParseException {
        check(ValueObb,ValueTag,ValueData);
        checkData(data);
        controller= new UpdateObiettivoPersonaleController(userid,newObb,newTag,data );
    }

}
