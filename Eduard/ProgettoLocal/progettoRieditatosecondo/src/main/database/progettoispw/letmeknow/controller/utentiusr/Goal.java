package progettoispw.letmeknow.controller.utentiusr;
public class Goal {
    private  String obiettivo;
    private   String tag;
    private  Integer[] data=new Integer[3];
    public void setObiettivo(String string){
        obiettivo=string;
    }
    public void setData(Integer [] arr){
        data=arr;
    }
    public void setStrData(String input){
        System.out.println(input);
        int end=input.indexOf("-");
        data[2]=(Integer.parseInt(input.substring(0,end)));
        int beg=end;
        end=input.indexOf("-",end+1);
        data[1]=(Integer.parseInt(input.substring(beg+1,end)));
        beg=end;
        end=input.length();
        data[0]=(Integer.parseInt(input.substring(beg+1,end)));
    }
    public String getDataStr(){
        //STANDARD PATTERN DD-MM-YYYY
        String convert=String.format("%d-%d-%d",data[2],data[1],data[0]);
        return convert;
    }
    public void setTag(String string){
        tag=string;
    }
    public String getObiettivo(){
        return obiettivo;
    }
    public Integer[] getData(){return data;}
    public String getTag(){
        return tag;
    }
    public void getStatus(){
        System.out.println("il tuo obiettivo personale:"+obiettivo+"\ni tuoi tag:"+tag+"\nla tua scadenza:"+data[0]+"/"+data[1]+"/"+data[2]);
    }
}
