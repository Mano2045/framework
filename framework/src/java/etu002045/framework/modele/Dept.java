package etu002045.framework.modele;

import etu002045.framework.Url;

public class Dept {
    int deptno;
    String dname;
    String loc;

    public Dept(){}

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Dept(int id,String n,String loc){
        setDetpno(id);
        setDname(n);
        setLoc(loc);
    }

    public int getDeptno(){
            return deptno;
    }
    
    public void setDetpno(int id){
            deptno = id;
    }
    
    @Url(name="dept-updat")
    public String getDname(){
            return dname;
    }

    
    public void setDname(String n){
            dname = n;
    }
    public void setLoc(String l){
            loc = l;
    }
    
    @Url(name="dept-delete")
    public String getLoc(){
            return loc;
    }
}
