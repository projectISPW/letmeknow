package progettoispw.letmeknow.controller.search;

public class Sliders {
    private  Integer emp;
    private  Integer pos;
    private Integer hum;
    private  Integer[] coll=new Integer[3];
    private Integer affinity;
    public Sliders (Integer val ){
        affinity=val;
    }
    public void setHum(Integer val){
        hum=val-affinity;
        coll[1]=hum;
    }
    public void setPos(Integer val){
        pos=val-affinity;
        coll[2]=pos;
    }
    public void setEmp(Integer val){
        emp=val-affinity;
        coll[0]=emp;
    }
    public Integer getEmp(){
        return emp;
    }
    public Integer getHum(){
        return hum;
    }
    public Integer getPos(){
        return pos;
    }
    public Integer [] getAll(){
        return coll;
    }

}
