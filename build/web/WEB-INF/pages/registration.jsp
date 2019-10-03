<%-- 
    Document   : registartion.html
    Created on : Dec 4, 2018, 10:41:54 AM
    Author     : acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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

	<!-- web fonts -->
	<link href="//fonts.googleapis.com/css?family=Lato:100,100i,300,300i,400,400i,700,700i,900,900i&amp;subset=latin-ext" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i&amp;subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese"
	    rel="stylesheet">
        <script src="js/jquery-2.2.3.min.js" type="text/javascript"></script>
        <link href="css/stylereg.css" rel="stylesheet" type="text/css"/>
        <style>
            #f2,#f3{
                display:none;
            }
            .rad{
                
                width:35%;
                margin:auto;
                border:2px solid white;
                font-weight: bold;
                color:white;
                background-color:black;
                
            }
            
            input[type="radio"]
            {
                padding-left:20px;
            }
            
            .requirements{
                color: red;

                margin-top: -13px;

                margin-bottom: 10px;
            }
            
            
        </style>
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
							<form class="form-inline" action="#" method="post">
								<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" required>
								<button class="btn my-2 my-sm-0" type="submit">Search</button>
							</form>
						</div>
						<!-- //search -->
						
					</div>
				</div>
			</div>
		</div>
	</div>
        <div style="background-color:gray;">
        <div class="rad">
          
                            Customer <input type="radio" name="r1" id="r1" checked="checked">||||||  Merchant <input type="radio" name="r1" id="r2">

        
        </div>
        <div id="f1">
            <div class="w3-main">
	<!-- Main -->
	<div class="about-bottom main-agile book-form">
		<div class="alert-close"> </div>
		<h2 class="tittle">Customer Register</h2>
                <form action="regcus.html" method="post" onsubmit="return success()">
			<div class="form-date-w3-agileits">
                            <label>Username</label>
                            <div class="usern">
                            <input type="text" name="username" required="" id="username" placeholder="Enter username" onblur="checkusername()">
                            <div class="requirements" id="prnt" style="color:red;"></div>
                            </div>
				<label> Name </label>
				<input type="text" name="name" placeholder="Your Name" required="">
				<label> Email </label>
				<input type="email" name="email" placeholder="Your Email" required="">
                                <label>Address</label>
                                <textarea name="address"></textarea>
                                <label>State</label>
                                <input type="text" name="state">
                                <label>Phone</label>
                                <input type="text" name="phone" placeholder="Enter Phone Number">
				<label> Password </label>
				<input type="password" name="pass" placeholder="Your Password" required="">
				<label> CONFIRM Password </label>
				<input type="password" placeholder="Confirm Password" required="">
			</div>
			<div class="make wow shake">
				  <input type="submit" value="Register">
			</div>
		</form>
	</div>
	<!-- //Main -->
</div>

                
            
            
        </div>
        <div id="f2">
            
                        <div class="w3-main">
	<!-- Main -->
	<div class="about-bottom main-agile book-form">
		<div class="alert-close"> </div>
		<h2 class="tittle">Merchant Register</h2>
                <form action="regmer.html" method="post" onsubmit="return successmerchant()">
			<div class="form-date-w3-agileits">
                            <label>Username</label>
                            <input type="text" name="musername" id="musername" placeholder="Enter username" required="" onblur="checkmerchantusername()">
                            <div class="requirements" id="mprnt"></div>
                            <label> Name </label>
				<input type="text" name="mname" placeholder="Your Name" required="">
				<label> Email </label>
				<input type="email" name="memail" placeholder="Your Email" required="">
                                <label>Address</label>
                                <textarea name="maddress"></textarea>
                                <label>State</label>
                                <input type="text" name="mstate">
                                <label>Phone</label>
                                <input type="text" name="mphone" placeholder="Enter Phone Number">
				<label> Password </label>
				<input type="password" name="mpassword" placeholder="Your Password" required="">
				<label> CONFIRM Password </label>
				<input type="password" placeholder="Confirm Password" required="">
			</div>
			<div class="make wow shake">
				  <input type="submit" value="Register">
			</div>
		</form>
	</div>
	<!-- //Main -->
</div>
            
         
        </div>
        <div id="f3">
                        <div class="w3-main">
	<!-- Main -->
	<div class="about-bottom main-agile book-form">
		<div class="alert-close"> </div>
		
	</div>
	<!-- //Main -->
</div>
            
        </div>
        </div>
        
        <div class="copy-right py-3">
		<div class="container">
			<p class="text-center text-white">Â© 2018 Electro Store. All rights reserved | Design by
				<a href="http://w3layouts.com"> W3layouts.</a>
			</p>
		</div>
	</div>
        <script>
            function checkusername()
            {
                var v=document.getElementById("username").value;
                var result;
                
                if(v=="")
                {
                    document.getElementById("prnt").innerHTML="Please Enter a valid Username";
                    return false;
                }
                
                $.ajax({
                    
                    type:"GET",
                    url:"ajaxusername.html",
                    data:{username:v},
                    async: false,
                    dataType: 'text',
                    success:function(response)
                    {
                        
                        $("#prnt").html(response);
                        result=$.trim(response);
                       
                      
                    }
                });
                
                
                if(result==="Username Available")
                    return true;
                else
                    return false;
                
                
       
                
            }
        
            
            function checkmerchantusername()
            {
                var v=document.getElementById("musername").value;
                var result;
                
                if(v=="")
                {
                    document.getElementById("mprnt").innerHTML="Please Enter a valid Username";
                    return false;
                }
                
                $.ajax({
                    
                    type:"GET",
                    url:"majaxusername.html",
                    data:{username:v},
                    async: false,
                    dataType: 'text',
                    success:function(response)
                    {
                        
                        $("#mprnt").html(response);
                        result=$.trim(response);
                        
                       
                        
                    }
                });
                
                if(result==="Username Available")
                        {
                           return true;
                        }
                        else
                        {
                            return false;
                        }
                
            }
        
            
            function success()
            {
                if(checkusername())
                {
                alert("Successfully Registered");
                return true;
            }
            else
            {
                alert("Please enter valid details");
                return false;
            }
            }
            
            function successmerchant()
            {
                if(checkmerchantusername())
                {
                    alert("Successfully Registered");
                    return true;
                }
                else
                {
                    alert("Please enter valid details");
                    return false;
                }
            }
            
            function successbank()
            {
                alert("Registered Successfully");
                return true;
            }
            
        </script>
        <script>
            $(document).ready(function(){
               
               $("#r1").click(function(){
                   $("#f2,#f3").hide();
                   $("#f1").show();
               });
               $("#r2").click(function(){
                   $("#f1,#f3").hide();
                   $("#f2").show();
               });
               $("#r3").click(function(){
                   $("#f2,#f1").hide();
                   $("#f3").show();
               });
        
        
            });
            </script>
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

    </body>
</html>
