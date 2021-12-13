package progettoispw.letmeknow.controller.form;

public class ResultForm2 extends ResultForm {
    static boolean[] rispostedate;
    static int [] valoripassati;
    static int i =0;
    public ResultForm2(String inputuserid, String inputform){
        userid="123456";
        formid="form2";
        fxml="formToTake/interf1form2.fxml";
        if (userid == inputuserid && formid ==inputform) {
                if(i==0){
                    valoripassati=new int[]{-1,-1,-1,-1,-1,-1};
                    rispostedate=new boolean[]{false,false,false,false,false,false};
                    ++i;
                }
                for(int i=0;i<6;i++){
                    System.out.printf("nuovo valore in [%d] %s pari a %d \n", i,rispostedate[i] ? "true" : "false",valoripassati[i]);
                }
            }
        }
    public boolean[] getRisposteDate (){
        return rispostedate;
    }
    public int[] getValRisposteDate (){
        return valoripassati;
    }

    public void setRisposte (int [] input){
        for(int i=0;i<6;i++){
            if(input[i]<=5 && input[i]>=1 && rispostedate[i]){ //
                valoripassati[i]=input[i];
                //System.out.printf("nuovo valore in [%d] %s pari a %d \n", i,rispostedate[i] ? "true" : "false",valoripassati[i]);
                //System.out.printf("ricevuta risposta response[%d]=%d\n",i,valoripassati[i]);
            }
        }
    }



}

