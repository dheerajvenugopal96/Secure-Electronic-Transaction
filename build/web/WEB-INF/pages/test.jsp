<%-- 
    Document   : test
    Created on : Mar 18, 2019, 4:01:35 PM
    Author     : Dheeru
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="js/jquery-2.2.3.min.js" type="text/javascript"></script>
    </head>
    <body>
               <div id="content">
                   <c:forEach items="${list}" var="i">
                
                <label>Dual Signature</label>
                <p>${i.dualsignature}</p>
                <input type="hidden"  id="dualsig" value="${i.dualsignature}">
                 <br><button id="decbut">Decrypt Using Private Key</button>
                <c:forEach items="${list2}" var="j">
                    <input type="hidden" id="prk" value="${j.privatekey}">
                </c:forEach>
                    
                    <span id="test">here</span>
                
                    <br><button id="hashbut" style="display: none;">Match HASH-Key</button>
                
            </c:forEach>

    </div>
        
            <script>

        $(document).ready(function(){
        
      
        $("#decbut").click(function(){
            
       
           
            var v=$("#dualsig").val();
            var k=$("#prk").val();
            alert("GVfdhe");
           $.ajax({
               
               type:"GET",
                    url:"dec.html",
                    data:{username:v},
                    async: false,
                    dataType: 'text',
               success(function(response))
               {
                   $("#test").html(response);
               }
           });
           
            
        });
        
        });
        
    </script>

    </body>
</html>
