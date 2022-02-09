package progettoispw.letmeknow.controller;

import progettoispw.controller.ClassController;
import progettoispw.letmeknow.controller.psyuser.PsyUser;

public class FormPsychologistResultController {
    PsyUser user;
    public FormPsychologistResultController(){
        user= ClassController.getUserPsy();
    }
    public float [] getSelected(){
        return user.getSelected();
    }
}
