<%-- 
    Document   : listDept
    Created on : 22 mars 2023, 17:01:45
    Author     : kodar
--%>

<%@page import="modele.Dept"%>
<%@page import="java.util.Vector"%>
<%  
    Vector<Dept> list = (Vector<Dept>) request.getAttribute("list");
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>  liste </title>
    </head>
    <body>
        <h3>list Dept</h3>
        nb : <%= list.size() %> <br>
        <% for (Dept d : list) { %>
            <%= d.getDname() %> <br>
        <% } %>
    </body>
</html>
