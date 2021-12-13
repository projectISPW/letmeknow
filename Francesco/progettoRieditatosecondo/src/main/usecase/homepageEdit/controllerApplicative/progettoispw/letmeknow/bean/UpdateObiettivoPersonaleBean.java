package progettoispw.letmeknow.bean;
import progettoispw.letmeknow.controller.UpdateObiettivoPersonaleController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UpdateObiettivoPersonaleBean {
    private String userid;
    private String newObb;
    private String newTag;
    private String newScadenza;
    SimpleDateFormat dateParser=new SimpleDateFormat("yyyy/MM/dd");
    private Integer [] data={0,0,0};
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
            //data=dateParser.parse(ValueData);
            int end=newScadenza.indexOf("/");
            data[0]=giorno=(Integer.parseInt(newScadenza.substring(0,end)));
            int beg=end;
            end=newScadenza.indexOf("/",end+1);
            data[1]=mese=(Integer.parseInt(newScadenza.substring(beg+1,end)));
            beg=end;
            end=newScadenza.length();
            data[2]=anno=(Integer.parseInt(newScadenza.substring(beg+1,end)));
            //System.out.println("prima iniziailizzazione data "+giorno+"-"+mese+"-"+anno);
            data=checkData(data);
        }
        else{
            data=padre.exitData();
        }
    }

    public Integer[] checkData(Integer [] date){
        if(cal.get(Calendar.YEAR)== date[2]  || data[2]==(cal.get(Calendar.YEAR)+1)){
            if(data[1]>((cal.get(Calendar.MONTH)+6)%12)) {
                System.err.println("errore mensile");
                return createData();
            }
            return date;
        }
        else{
            System.err.println("errore annuale");
            return createData();
        }


    }
    public Integer[] createData(){
        if(cal.get(Calendar.MONTH)<6){
            return (new Integer[] {cal.get(Calendar.DAY_OF_MONTH),cal.get(Calendar.MONTH)+6,cal.get(Calendar.YEAR)});
        }
        else{
            return (new Integer[] {cal.get(Calendar.DAY_OF_MONTH),(cal.get(Calendar.MONTH)+6)%12,cal.get(Calendar.YEAR)+1});
        }
    }
    public void entryValue(String ValueObb,String ValueTag, String ValueData) throws ParseException {
        check(ValueObb,ValueTag,ValueData);

        controller= new UpdateObiettivoPersonaleController(userid,newObb,newTag,data );
    }

}
