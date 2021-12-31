package progettoispw.letmeknow.controller.form;

public class ResultForm1 extends ResultForm {
    static boolean[] rispostedate;
    static int [] valoripassati;
    static int complete;
    static int i=0;
    public ResultForm1(String inputuserid, String inputform){
        userid="1234567";
        formid="form1";
        fxml="formToTake/interf1.fxml";
        if (userid ==inputuserid && formid ==inputform) {
            System.out.println("i am here ");
            if(i==0){
                valoripassati=new int[]{-1,-1,-1,-1,-1,-1};
                rispostedate=new boolean[]{false,false,false,false,false,false};
                ++i;
                complete=0;
            }
            for(int i=0;i<7;i++){
                if(i==6)System.out.printf("completezza test %d",complete);
                else System.out.printf("nuovo valore in [%d] %s pari a %d \n", i,rispostedate[i] ? "true" : "false",valoripassati[i]);

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
        int changed=0;
        for(int i=0;i<6;i++){
            if(input[i]<=5 && input[i]>=1 && rispostedate[i]){ //
                valoripassati[i]=input[i];
                ++changed;
            }
        }
        complete=changed;
        //System.out.println("aggiornata completezza"+complete+'\n');
    }
    public int getComplete(){
        return complete;
    }

}

