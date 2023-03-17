/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package etu002045.framework;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Vector;

/**
 *
 * @author kodar
 */
public class MethodAnnote {
    Method method;
    Url annotationMethode;

    private MethodAnnote(Method m,Url a) {
        annotationMethode = a;
        method = m;
    }

    @SuppressWarnings("UseOfObsoleteCollectionType")
    public static Vector<MethodAnnote> getAnnotedMethods(String path) throws Exception{
        Vector<MethodAnnote> listma = new Vector();       
        ClassLoader classLoder = Thread.currentThread().getContextClassLoader();
        File pkg = new File(classLoder.getResources(path).nextElement().getFile());
        if (pkg.exists()) {
            for (File file : pkg.listFiles()) {
                if (!file.isDirectory()) {
                    if ( file.getName().endsWith(".class") ) {                    
                        String p = path.replace("/",".");
                        Class cl = Class.forName(p+"."+file.getName().replace(".class",""));
                        for ( Method mt : cl.getDeclaredMethods()) {
                            if (mt.isAnnotationPresent(Url.class)) {
                                Url annotation = (Url) mt.getAnnotation(Url.class);
                                MethodAnnote ma = new MethodAnnote(mt,annotation);
                                listma.addElement(ma);
                            }
                        }
                    }
                }	
            }            
        } else{
            throw new Exception("not fond");
        }
        return listma;
    }

    public Url getAnnotation() {
        return annotationMethode;
    }
    public Method getMethod(){
        return method;
    }
}