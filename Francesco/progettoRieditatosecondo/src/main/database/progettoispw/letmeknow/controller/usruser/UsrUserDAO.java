package progettoispw.letmeknow.controller.usruser;

import progettoispw.letmeknow.controller.ConnectionDBMS;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsrUserDAO {
    ConnectionDBMS connDB;
    Query query;
    public static final int EMP=5;
    public static final String DESCRIPTION="description";
    public static final String GOAL="goal";
    public static final String TAG="tag";
    public static final String BY="by";
    public static final int ABOUT=14;
    public static final int CALCULATED=15;
    public UsrUserDAO() {
        connDB= new ConnectionDBMS();
        query=new Query();
    }
    public String [] selectUser(String uid){
        Statement stmt=null;
        ResultSet rst=null;
        String [] ret=new String [7];
        try {
            stmt=connDB.connection(stmt);
            rst=query.selectUser(stmt,uid);
            while(rst.next()) {
                for(int i=0;i<7;i++)ret[i]= rst.getString(EMP+i);
            }
            return ret;
        } catch (SQLException e) {
            e.printStackTrace();
            return new String[]{"1","1","1",null,null,null,null};
        }finally{
            connDB.closeRSTSTMT(rst,stmt);
        }
    }
    public boolean setDescription(String userid,String input){
        Statement stmt=null;
        try {
            stmt=connDB.connection(stmt);
            return query.setDB(stmt,userid,DESCRIPTION,input);
        }finally{
            connDB.closeSTMT(stmt);
        }

    }
    public boolean setGoal(String userid,String input){
        Statement stmt=null;
        try {
            stmt=connDB.connection(stmt);
            return query.setDB(stmt,userid,GOAL,input);
        }finally{
            connDB.closeSTMT(stmt);
        }

    }
    public boolean setTag(String userid,String input){
        Statement stmt=null;
        try {
            stmt=connDB.connection(stmt);
            return query.setDB(stmt,userid,TAG,input);
        }finally{
            connDB.closeSTMT(stmt);
        }

    }
    public boolean setData(String userid,String input){
        Statement stmt=null;
        try {
            stmt=connDB.connection(stmt);
            return query.setDB(stmt,userid,BY,input);
        } finally{
            connDB.closeSTMT(stmt);
        }

    }
    private int average(int val,int divisor){
        val=val/divisor;
        if(val>5)return 5;
        else if(val <1 )return 1;
        else return val;
    }
    public boolean getResult(String userid,Integer [] params){
        Statement stmt=null;
        ResultSet rst=null;
        List<Integer> calculated=new ArrayList<>();
        char[] about;
        boolean edited=false;
        boolean check=true;
        Integer []  currentVal=new Integer[3];
        int size=-1;
        try {
            stmt=connDB.connection(stmt);
            rst=query.queryResult(stmt,userid);
            while (rst.next()) {
                if (rst.getString(CALCULATED).equals("1")) {
                    edited = true;
                    about = rst.getString(ABOUT).toCharArray();
                    for (int i = 0; i < about.length; i++) {
                        switch (about[i]) {
                            case '1':
                                currentVal[0] += Integer.parseInt(rst.getString(3 + i));break;
                            case '2': {
                                currentVal[1] += Integer.parseInt(rst.getString(3 + i));
                                break;
                            }
                            case '3': {
                                currentVal[2] += Integer.parseInt(rst.getString(3 + i));
                                break;
                            }
                            default:{
                                return false;
                            }
                        }
                    }
                    calculated.add(Integer.parseInt(rst.getString(1)));
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally{
            connDB.closeRSTSTMT(rst,stmt);
        }
        size=calculated.size()+1;
        check=setCalculated(userid,calculated);
        if(edited && check){
            check=setParams(userid,params,currentVal,size);
        }
        return check;
    }
    private boolean setParams(String userid,Integer [] oldParam,Integer [] newParam,int size){
        Statement stmt=null;
        try{
            for(int i=0;i<3;i++)oldParam[i]=average(oldParam[i]+newParam[i],size+1 );
            stmt=connDB.connection(stmt);
            return query.setParams(stmt,userid,oldParam);
        }finally{
            connDB.closeSTMT(stmt);
        }
    }
    private boolean setCalculated(String userid,List<Integer> calculated){
        Statement stmt=null;
        boolean check=true;
        try{
            stmt=connDB.connection(stmt);
            for(Integer id :calculated)if(check) check=query.setCalculated(stmt,userid,id);
            return check;
        }finally{
            connDB.closeSTMT(stmt);
        }
    }

}