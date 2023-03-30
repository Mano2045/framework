jar cvf framework.jar -C framework/build/web/WEB-INF/classes etu002045
mv framework.jar test-framework/build/web/WEB-INF/lib/
jar cvf test.war -C test-framework/build/web . 
mv test.war /opt/apache-tomcat-9.0.71/webapps/ 
