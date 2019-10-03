<%-- 
    Document   : payment
    Created on : Dec 14, 2018, 11:47:16 AM
    Author     : acer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            
            form{
                
                border:1px solid black;
                width: auto;
                margin:15%;
                background-color:rgb(8, 121, 201);
            }
            input[type="text"]
            {
                width:90%;
                padding: 3%;
                margin:2%;
                text-align: center;
                font-weight: bold;
                
            }
            input[type="submit"]
            {
                width:96%;
                padding:3%;
                margin:2%;
                font-weight:bold;
            }
            
            body{
                
                background-color: rgb(241, 243, 246);
            }
            
            
        </style>
    </head>
    <body>
        <form action="po.html" method="post" onsubmit="return checkcvv()">
            <c:forEach items="${list}" var="i">
            <input type="hidden" name="cusid" value="${i.id}">
            <input type="text"  name="accnumber" readonly="" value="${i.accountnumber}">
            <input type="text" name="expiry" readonly="" value="${i.expirydate}">
            <input type="text" name="cardname" readonly="" value="${i.cardname}">
            <input type="text" name="cvv" id="cvv" placeholder="Enter CVV">
            <input type="submit" value="PAY">
            </c:forEach>
            
        </form>
        
        <script>
            
            function checkcvv()
            {
                var v=document.getElementById("cvv").value;
                    <c:forEach items="${list}" var="i">
                            
                            var k="${i.cvv}";
                            if(v==k)
                            {
                                alert("order Placed successfully");
                                return true;
                                
                            }
                            else
                            {
                                alert("Invalid cvv");
                                return false;
                            }
                                
                            
                            
                                
                            
                    </c:forEach>
                
                
            }
            
            
            
        </script>
    </body>
</html>
