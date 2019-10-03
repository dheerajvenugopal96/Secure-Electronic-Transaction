<%-- 
    Document   : viewproduct
    Created on : Dec 10, 2018, 2:45:09 PM
    Author     : acer
--%>

<%@page import="javax.xml.bind.DatatypeConverter"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.io.File"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8" />
	<meta name="keywords" content="Electro Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design"
	/>
	<script>
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
	<!-- //Meta tag Keywords -->

	<!-- Custom-Files -->
	<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<!-- Bootstrap css -->
	<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
	<!-- Main css -->
	<link rel="stylesheet" href="css/fontawesome-all.css">
	<!-- Font-Awesome-Icons-CSS -->
	<link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all" />
	<!-- pop-up-box -->
	<link href="css/menu.css" rel="stylesheet" type="text/css" media="all" />
	<!-- menu style -->
	<!-- //Custom-Files -->
        <script src="js/jquery-2.2.3.min.js" type="text/javascript"></script>
	<!-- web fonts -->
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<link href="//fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i&amp;subset=latin-ext" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese"
	    rel="stylesheet">
	<!-- //web fonts -->
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="header-bot">
                    <div class="container">
                            <div class="row header-bot_inner_wthreeinfo_header_mid">
                                    <!-- logo -->
                                    <div class="col-md-3 logo_agile">
                                            <h1 class="text-center">
                                                    <a href="index.html" class="font-weight-bold font-italic">
                                                            <img src="images/logo2.png" alt=" " class="img-fluid">Electro Store
                                                    </a>
                                            </h1>
                                    </div>
                                    <!-- //logo -->
                                    <!-- header-bot -->
                                    <div class="col-md-9 header mt-4 mb-md-0 mb-4">
                                            <div class="row">
                                                    <!-- search -->
                                                    <div class="col-10 agileits_search">
                                                            <form class="form-inline" action="#" method="post" style="margin-top: 30px;">
                                                                    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" required>
                                                                    <button class="btn my-2 my-sm-0" type="submit">Search</button>
                                                            </form>
                                                    </div>
                                                    <!-- //search -->
                                                    <!-- cart details -->
                                                    <div class="col-2 top_nav_right text-center mt-sm-0 mt-2">
                                                            <div class="wthreecartaits wthreecartaits2 cart cart box_1">
                                                                    <form action="#" method="post" class="last">
                                                                            <input type="hidden" name="cmd" value="_cart">
                                                                            <input type="hidden" name="display" value="1">
                                                                            <button class="btn w3view-cart" type="submit" name="submit" value="">
                                                                                    <i class="fas fa-cart-arrow-down"></i>
                                                                            </button>
                                                                    </form>
                                                            </div>
                                                    </div>
                                                    <!-- //cart details -->
                                            </div>
                                    </div>
                            </div>
                    </div>
            </div>
        
        <div class="productdetails">
            
            <div class="imagedisplay">
                <c:forEach items="${list}" var="i">
                    <c:set var="j" value="${i.imagepath}" scope="session"></c:set>
                    <%
                                               String img=(String)session.getAttribute("j");
                                               BufferedImage bimage=ImageIO.read(new File(img));
                                               ByteArrayOutputStream baos=new ByteArrayOutputStream();
                                               ImageIO.write(bimage,"png",baos);
                                               baos.flush();
                                               byte[] imageinbytearray=baos.toByteArray();
                                               baos.close();
                                               String b64=DatatypeConverter.printBase64Binary(imageinbytearray);
                                           
                                           
                                           %>
                                           <img src="data:image/png;base64, <%= b64%>" alt="image" style="width:416px;height:416px;">
                </c:forEach>
                
            </div>
            <div class="productspecs">
                
                <c:forEach items="${list}" var="k">
                    <label><b>Category > </b>${k.category}</label>
                    <h3>${k.productName}</h3>
                    <label><b>Price</b></label>
                    <h3><i class="fas fa-rupee-sign"></i> ${k.amount}</h3>
                    <label><b>Specifications</b></label>
                    <h3>${k.description}</h3>
                    <label><b>Seller</b></label>
                    <c:forEach items="${listmer}" var="l">
                        <h3>${l.username}</h3>
                        <label><b>Contact inf.</b></label>
                        <h3>${l.phone}</h3>
                        
                    </c:forEach>
                    
                    
                </c:forEach>
                <c:forEach items="${list}" var="c">
                        <form action="addtocart.html" onsubmit="return checklog()">
                            <input type="hidden" name="customerid" value="<%=session.getAttribute("idd")%>">
                            <input type="hidden" name="productid" value="${c.id}">
                            <input type="hidden" name="merchantid" value="${c.merchantid}">
                            <input type="hidden" name="productname" value="${c.productName}">
                            <input type="hidden" name="imagepath" value="${c.imagepath}">
                            <c:forEach items="${listmer}" var="d">
                            <input type="hidden" name="sellername" value="${d.username}">
                            </c:forEach>
                            <input type="hidden" name="amount" value="${c.amount}">
                        <button type="submit"><i class="fa fa-cart-plus" style="margin-right: 1%;"></i>Add To Cart</button>
                </form>
                        </c:forEach>
            </div>
            

            
            
            
            
        </div>
        
        
       
<!--        <div class="copy-right py-3">
		<div class="container">
			<p class="text-center text-white">Â© 2018 Electro Store. All rights reserved | Design by
				<a href="http://w3layouts.com"> W3layouts.</a>
			</p>
		</div>
	</div>-->

<script>
    
    function checklog()
    {
    <c:set var="log" value="${sessionScope.idd}"></c:set>
    <c:choose>
        <c:when test="${empty log}">
            alert("please login first");
            window.location.href="home.html";
            return false;
        </c:when>
        <c:otherwise>
            alert("item added to cart");
            return true;
        </c:otherwise>
    </c:choose>
    }
    
    
</script>
        
    </body>
</html>
