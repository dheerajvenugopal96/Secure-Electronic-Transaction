<%-- 
    Document   : logout
    Created on : Dec 6, 2018, 12:07:36 PM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% session.invalidate();
        response.sendRedirect("home.html");%>
    </body>
</html>
