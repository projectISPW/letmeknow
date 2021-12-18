package progettoispw.letmeknow.controller.form;

import java.util.Vector;
import progettoispw.letmeknow.controller.form.ResultForm1;
public class ListForm {
    private Vector<ResultForm> listaRisultati;
    public void attach(ResultForm form){
        listaRisultati.add(form);
    }
    public String getForm(){
        listaRisultati=new Vector<>();
        attach(new ResultForm1("123456","form1"));
        attach(new ResultForm2("123456","form2"));
        for (ResultForm form : listaRisultati  ) {
            if(form.complete==0){
                return form.fxml;
            }
        }
        return null;
    }
}
