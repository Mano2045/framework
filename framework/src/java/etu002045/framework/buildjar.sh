javac -d . *.java
javac -d . servelet/*.java

jar cvf test-frame.jar etu002045/framework/servlet/FrontServlet.class etu002045/framework/*.class
