/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etu002045.framework.servlet;

import etu002045.framework.DateEditor;
import etu002045.framework.Mapping;
import etu002045.framework.MethodAnnote;
import etu002045.framework.ModeleView;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ITU
 */
public class FrontServlet extends HttpServlet {
    HashMap<String, Mapping> mappingUrl;

    @Override  
    public void init() {
        mappingUrl = new HashMap<>();
        try {
            Vector<MethodAnnote> list = MethodAnnote.getAnnotedMethods(this.getInitParameter("package-modele"));
            for ( MethodAnnote m : list) {
                Mapping mp = new Mapping(m.getMethod().getDeclaringClass().getName(), m.getMethod().getName());
                mappingUrl.put(m.getAnnotation().name(),mp);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        PrintWriter out = response.getWriter();
          
        String url = request.getRequestURI();
       
        try {  
            url = url.split("/")[2];

            if (mappingUrl.containsKey(url)) {
                Mapping mapping = mappingUrl.get(url);
                Class cl = Class.forName(mapping.getClassName());
                Object obj = cl.getConstructor().newInstance();
                
            //--Sprint7
                Field[] attributs = cl.getDeclaredFields();
                for (int i = 0; i < attributs.length; i++) {
                    String param = request.getParameter(attributs[i].getName());
                    if(param!=null){
                        String setter = "set"+attributs[i].getName().substring(0, 1).toUpperCase()+ attributs[i].getName().substring(1);
                        //out.println(setter+"("+request.getParameter(attributs[i].getName())+")");
                        
                        //cast 
                        Class<?> clA = attributs[i].getType();
                        PropertyEditor editor = PropertyEditorManager.findEditor(clA);
                        PropertyEditorManager.registerEditor(Date.class, DateEditor.class);
                        editor.setAsText(param);
                        
                        //set
                        cl.getMethod(setter,clA).invoke(obj,editor.getValue());
                    }
                }    
            //--end
            
                Object model = cl.getMethod(mapping.getMethodName()).invoke(obj);
                if (model.getClass() == ModeleView.class) {
                    ModeleView mv = (ModeleView) model;
                    
                    for (Map.Entry<String, Object> data : mv.getData().entrySet()) {
                        request.setAttribute(data.getKey(), data.getValue());
                    }
                    
                    RequestDispatcher dispat = request.getRequestDispatcher(mv.getView()); 
                    dispat.forward(request,response);
                } else {
                    throw new Exception("ataovy ModeleView");
                }
                
            } else {
                throw new Exception("Url Not Found");
            }
        } catch (Exception e) {
            out.print(e.getMessage());
//            RequestDispatcher dispat = request.getRequestDispatcher("listDept.jsp"); 
//            dispat.forward(request,response);
        }
  
//        for (Map.Entry<String, Mapping> map : mappingUrl.entrySet()) {
//            String str = map.getKey();
//            Mapping val = map.getValue();
//            out.print( "[Url :" +str);
//            out.print("] [Methode name :" +val.getMethodName());            
//            out.println("] [class :" +val.getClassName()+"]");
//        }    
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}