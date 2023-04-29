<%-- 
    Document   : ajouetr_emp
    Created on : 20 avr. 2023, 20:43:34
    Author     : kodar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="dept-save" method="POST">
            Id :<input type="text" name="deptno">
            <br/>
            Nom :<input type="text" name="dname"> 
            <br/> Location : <input type="text" name="loc">
            <br/> Date : <input type="date" name="date">

            <br/> <input type="submit" value="Save">
        </form>
    </body>
</html>
