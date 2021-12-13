package progettoispw.letmeknow;

public class WordCheck {
    static  int goAhead;
    static int contAhead;
    static int delta;
    public WordCheck(int deltaInput,int goAheadInput){
        delta=deltaInput;
        goAhead=goAheadInput;
    }
    public WordCheck(){
        delta=goAhead=-1;
    }
    public static  String check(String inputText) {
        String add;
        String before;
        for (int k = goAhead-delta,count =goAhead-delta; k < inputText.length(); k = k+1) {
            if(inputText.toCharArray()[k]=='\n'){
                count=0;
                //System.out.println("gia andato a capo");
            }
            if (count==goAhead){
                add = inputText.substring(k);
                before = inputText.substring(0, k);
                inputText = before + "\n" + add;
                count =0;
            } else if(((count%goAhead)>(goAhead-delta)) && inputText.toCharArray()[k]== 32){
                add = inputText.substring(k+1);
                before = inputText.substring(0, k);
                inputText = before + "\n" + add;
                count=0;
            }else{
                count++;
            }
        }
        //System.out.println(inputText);
        return  inputText;
    }
    public static String check1(String inputText,String immetti){
        String add;
        String before;
        int count=-1;
        int start=inputText.indexOf('#');
        int k=0;
        for(char c : inputText.toCharArray()){
            if(c=='#' && k!=start)
            {
                    add = inputText.substring(k);
                    before = inputText.substring(0, k);
                    //System.out.println(add+","+before);
                    inputText = before + immetti + add;
                    ++k;

            }++k;
        }
        return inputText;
    }
    static Integer contaInvio(String inputText){

        contAhead=1;
        for(char c : inputText.toCharArray()){
            if(c=='\n'){
                contAhead++;
            }
        }
        return contAhead;
    }
    static double highText(String inputText) {
        int linee= contaInvio(inputText);
        System.out.println(linee);
        if(linee>4){
            return linee* 21;
        }
        return 60;
    }
    public static boolean checkString(String inputText){
        if(inputText.length()>goAhead*3){
            return false ;
        }return true;
    }


}
//abcdefghilmnopqrstuvz123456789