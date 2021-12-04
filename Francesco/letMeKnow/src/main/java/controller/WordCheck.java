package controller;

public class WordCheck {
    static  String add;
    static  String before;
    static  int goAhead;
    static int contAhead;
    static int delta=10;
    public  WordCheck(int val){
        goAhead=30;

    }
    static  String check(String inputText) {

        if (goAhead*3)
    }
    /*
        for (int k = goAhead-delta; k < inputText.length(); k = k+1) {
            //System.out.printf("%c,%d %n",inputText.toCharArray()[k],k);
            //if(inputText.toCharArray()[k]=='\n')k=k-2;
            if ((k%goAhead)==0){
                //System.out.println(k%goAhead);
                add = inputText.substring(k);
                before = inputText.substring(0, k);
                inputText = before + "\n" + add;
                //k++;
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
        contAhead=0;
        for(char c : inputText.toCharArray()){
            System.out.println("prompt : "+contAhead);
            if(c=='\n'){
                contAhead++;
            }
        }
        return contAhead;
    }*/

}
//abcdefghilmnopqrstuvz123456789