package modele;

import etu002045.framework.ModeleView;
import etu002045.framework.Url;
import java.util.Date;
import java.util.Vector;

public class Dept {
    int deptno;
    String dname;
    String loc;
    Date date;

    public Dept(){}

    public Dept(int deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }

    public int getDeptno(){
            return deptno;
    }
    
    public void setDeptno(int id){
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    @Url(name="dept-all")
    public ModeleView findAll() {      
        Dept d1 = new Dept(1,"ITU1","TANA1");        
        Dept d2 = new Dept(2,"ITU2","TANA2");        
        Dept d3 = new Dept(2,"ITU3","TANA3");        
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
    
    @Url(name="dept-save")
    public ModeleView saveDept(){
                
        ModeleView mv = new ModeleView();
        
        Vector<Dept> list = new Vector();
        list.add(this);
        
        mv.setView("listDept.jsp");
        mv.addItem("list", list);
        
        return mv;
    }
}