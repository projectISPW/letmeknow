//utenteusr never used. should I cancel it with also library?

package progettoispw.letmeknow.controller;

import progettoispw.controller.ClassController;
import progettoispw.letmeknow.controller.form.ResultForm;

public class FormResultController {
    ResultForm form;
    public FormResultController(){
        form= ClassController.getResultForm();
    }
    public int[] getValResponse(){
        return form.getAnswers();
    }
    public int [] getParam () {
        return form.getParam();
    }
    public String getDate () {
        return form.getDate();
    }
}