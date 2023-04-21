/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etu002045.framework;

import java.util.HashMap;

/**
 *
 * @author kodar
 */
public class ModeleView {
    String view;
    HashMap<String, Object> data = new HashMap<>();;

    public HashMap<String, Object> getData() {
        return data;
    }

//    public void setData(HashMap<String, Object> data) {
//        this.data = data;
//    }
    
    public void addItem(String key,Object value){
        data.put(key,value);
    }
    
    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }
}