package progettoispw.letmeknow;

public class WordCheck {
    static  int goAhead;
    static int contAhead;
    static int delta=10;
    public WordCheck(int val){
        goAhead=30;
    }
    static  String check(String inputText) {
        String add;
        String before;
        for (int k = goAhead-delta,count =goAhead-delta; k < inputText.length(); k = k+1) {
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
        System.out.println(inputText);
        return  inputText;
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
    static Integer highText(String inputText){
        int len=inputText.length();
        float val=len/3000;
        int valInt=(int)val;
        System.out.println(val);
        switch(valInt){
            case 0: return 80+len;
            case 1:return len-450;
            default:return len;
        }
    }

}
//abcdefghilmnopqrstuvz123456789