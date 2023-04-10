package modele;

import etu002045.framework.ModeleView;
import etu002045.framework.Url;
import java.util.Vector;

public class Dept {
    int deptno;
    String dname;
    String loc;

    public Dept(){}

    public Dept(int deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }


    public int getDeptno(){
            return deptno;
    }
    
    public void setDetpno(int id){
            deptno = id;
    }
    
    public String getDname(){
            return dname;
    }

    public void setDname(String n){
            dname = n;
    }
    public void setLoc(String l){
            loc = l;
    }
    
    public String getLoc(){
            return loc;
    }
    
    @Url(name="dept-all")
    public ModeleView findAll() {      
        Dept d1 = new Dept(1,"ITU1","TANA");        
        Dept d2 = new Dept(2,"ITU2","TANA");        
        Dept d3 = new Dept(2,"ITU3","TANA");        
        Dept d4 = new Dept(2,"ITU","TANA");        

        Vector<Dept> list = new Vector();
        list.add(d1);
        list.add(d2);
        list.add(d3);
        list.add(d4);
        
        ModeleView mv = new ModeleView();
        
        mv.setView("listDept.jsp");
        mv.addItem("list", list);
        
        return mv;
    }
}