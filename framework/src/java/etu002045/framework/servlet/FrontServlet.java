/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package etu002045.framework.servlet;

import etu002045.framework.Mapping;
import etu002045.framework.MethodAnnote;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kodar
 */
public class FrontServlet extends HttpServlet {
    HashMap<String, Mapping> mappingUrl;

    @Override  
    public void init() {
        mappingUrl = new HashMap<>();
        try {
            Vector<MethodAnnote> list = MethodAnnote.getAnnotedMethods("etu002045/framework/modele");
            for ( MethodAnnote m : list) {
                Mapping mp = new Mapping(m.getMethod().getDeclaringClass().getSimpleName(), m.getMethod().getName());
                mappingUrl.put(m.getAnnotation().name(),mp);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
            PrintWriter out = response.getWriter();
            
            
        for (Map.Entry<String, Mapping> map : mappingUrl.entrySet()) {
            String str = map.getKey();
            Mapping val = map.getValue();
            out.println("Url :" +str);
            out.print("Methode name :" +val.getMethodName());            
            out.println(" --> class :" +val.getClassName());
        }

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

