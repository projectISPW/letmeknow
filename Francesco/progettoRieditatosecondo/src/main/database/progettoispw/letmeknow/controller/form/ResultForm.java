package progettoispw.letmeknow.controller.form;

public class ResultForm {
    private String userid;
    private int formid;
    private FormSQL formData;
    private int[] answers;
    private int complete;
    public ResultForm(String useridinp,int formidinp){
        formData=new FormSQL();
        userid=useridinp;
        formid=formidinp;
        answers= formData.queryResult(userid,formid);
        int indice=0;
        for(int i:answers){
            System.out.println("valore nell array" + i);
            if (i>=1){
                ++complete;
            }
        }
    }
    public boolean setRisposte(int[] input){
        for(int i=0;i<input.length;i++)System.out.println(input[i]);
        return formData.setAnswer(userid,formid,input);
    }
    public int[] getRisposte(){
        return answers;
    }

    public int getComplete() {
        return complete;
    }
}
