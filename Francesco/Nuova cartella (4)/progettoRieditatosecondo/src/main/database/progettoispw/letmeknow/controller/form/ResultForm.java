package progettoispw.letmeknow.controller.form;

public abstract class ResultForm {
    protected String fxml;
    protected String userid,formid;
    protected int complete;
    public abstract boolean[] getRisposteDate ();
    public abstract int[] getValRisposteDate ();
    public abstract void setRisposte(int [] valori);

}
