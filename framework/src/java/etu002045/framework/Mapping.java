package etu002045.framework;

public class Mapping {
    String className;
    String method;

    public Mapping(String className, String method) {
        this.className = className;
        this.method = method;
    }
    
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }    
}
