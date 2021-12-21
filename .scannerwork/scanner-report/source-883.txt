package controller;

public class wordCheck {
    //private  String inputText="ciao mi chiamo francesco e questo è il miotesto di input con cui provare a fare un po di parsing";
    static  String add;
    static  String before;
    static  int goAhead=0;
    static int contAhead;
    static int delta=10;
    public wordCheck(int val){
        goAhead=val;
    }
    static  String check(String inputText) {
        for (int k = goAhead-delta; k < inputText.length(); k = k+1) {
            if ((k%goAhead)==0){
                //System.out.println(k%goAhead);
                add = inputText.substring(k);
                before = inputText.substring(0, k);
                inputText = before + "\n" + add;
            } else if(((k%goAhead)>(goAhead-delta)) && inputText.toCharArray()[k]== 32){
                add = inputText.substring(k+1);
                before = inputText.substring(0, k);
                inputText = before + "\n" + add;
                while(k%goAhead>delta && k%goAhead!=0)k++;
                //System.out.println((k%goAhead)+before);
            }
            //System.out.println(inputText);
        }
        return  inputText;
    }
    static Integer contaInvio(String inputText){
        for(char c : inputText.toCharArray()){
            if(c=='\n'){
                contAhead++;
            }
        }
        return contAhead;
    }
}
