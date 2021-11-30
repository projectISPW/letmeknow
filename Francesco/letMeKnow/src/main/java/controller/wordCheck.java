package controller;

public class wordCheck {
    //private  String inputText="ciao mi chiamo francesco e questo è il miotesto di input con cui provare a fare un po di parsing";
    static  String add;
    static  String before;
    static  int goAhead=0;
    static int contAhead;
    public wordCheck(int val){
        goAhead=val;
    }
    static  String check(String inputText) {
        for (int k = goAhead; k < inputText.length(); k = k + goAhead) {
            add = inputText.substring(k);
            before = inputText.substring(0, k);
            inputText = before + "\n" + add;
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
