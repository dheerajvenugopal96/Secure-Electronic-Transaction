<%-- 
    Document   : customer
    Created on : Dec 6, 2018, 2:44:24 PM
    Author     : acer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Modernize an Admin Panel Category Bootstrap Responsive Web Template | Home :: w3layouts</title>
    <!-- Meta Tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8">
    <meta name="keywords" content="Modernize Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola web design" />
    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
    <!-- //Meta Tags -->

    <!-- Style-sheets -->
    <!-- Bootstrap Css -->
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
    <!-- Bootstrap Css -->
    <!-- Bars Css -->
    <link rel="stylesheet" href="css/bar.css">
    <!--// Bars Css -->
    <!-- Calender Css -->
    <link rel="stylesheet" type="text/css" href="css/pignose.calender.css" />
    <!--// Calender Css -->
    <!-- Common Css -->
    <link href="css/stylead.css" rel="stylesheet" type="text/css" media="all" />
    <!--// Common Css -->
    <!-- Nav Css -->
    <link rel="stylesheet" href="css/style4.css">
    <!--// Nav Css -->
    <!-- Fontawesome Css -->
    <link href="css/fontawesome-all.css" rel="stylesheet">
    <!--// Fontawesome Css -->
    <!--// Style-sheets -->

    <!--web-fonts-->
    <link href="//fonts.googleapis.com/css?family=Poiret+One" rel="stylesheet">
    <link href="//fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
    <!--//web-fonts-->
      <style>
        table,tr{
            
            border:1px solid black;
            border-collapse: collapse;
            
           
        }
        table{
            
            width:100%;
        }
        
        tr,th{
            
            height:50px;
            text-align:center;
            font-weight: bold;
        }
        
        th
        {
            background-color: #0879c9;
            color:white;
            text-align:center;
        }
        
        label{
            
            width: 100%;
            font-weight: bold;
        }
        
        input[type="text"]
        {
            margin-top: 1%;
            margin-bottom: 1%;
            font-weight: bold;
            background-color: burlywood;
        }
        
        
        button{
            
            border: none;
            background-color: black;
            color:white;
            font-weight: bold;
            margin-top: 1%;
            margin-bottom: 1%;
            cursor: pointer;
        }
        
        
        
        
    </style>
</head>

<body>
    <div class="se-pre-con"></div>
    <div class="wrapper">
        <!-- Sidebar Holder -->
        <nav id="sidebar">
            <div class="sidebar-header">
                <h1>
                    <img src="images/logo2.png" alt="store">Electro Store
                </h1>
               
            </div>
            
            <ul class="list-unstyled components">
                <li>
                        <a href="verify.html">
                        <i class="fa fa-plus"></i>
                        Verify customers
                        </a>
                </li>
                 </li>
                
                                <li>
                        <a href="transaction.html">
                        <i class="fa fa-building"></i>
                        Transactions
                        </a>
                </li>
                
            </ul>
        </nav>

        <!-- Page Content Holder -->
        <div id="content" class="content">
    <c:forEach items="${list}" var="i">
                
                <label>Dual Signature</label>
                <p style="background-color: yellow">${i.dualsignature}</p>
                <input type="hidden"  id="dualsig" value="${i.dualsignature}">
                <input type="hidden"  id="pomd" value="${i.pomd}">
                 <br><button id="decbut">Decrypt Using Private Key</button>
                 <div id="load" style="display: none;">
                 <br> <img src="images/1LBN.gif" alt="no-gif" style="width: 100px;height:100px;"/>
                 <p id="msg">Decrypting.....Please Wait</p>
                 </div>
                <c:forEach items="${list2}" var="j">
                    <input type="hidden" id="prk" value="${j.privatekey}">
                </c:forEach>
                    
                    <h1 id="test"></h1>
                
                    <br><button id="hashbut" style="display: none;">Match HASH-Key</button>
                    <br><p id="hashload" style="font-weight:bold;margin-top: 1%;display: none;">Matching....Please Wait</p>
                    <br><h1 id="hash" style="background-color: greenyellow"></h1>
                    <br><button id="detbut" style="display:none">Extract Customer Payment Info</button>
                    <div class="custdets" style="display: none;">
                        
                        <c:set value="${i.pi}" var="k" scope="session"></c:set>
                        <%
                            String pi=(String)session.getAttribute("k");
                            String payin[]=pi.split("_");
                            String acnum=payin[1];
                            String amount=payin[2];
                            String cusid=payin[0];
                          
                        
                        %>
                        
                        <label>Customer Account Number</label>
                        <input type="text" name="acnum" value="<%= acnum%>" readonly="">
                        
                        <label>Price</label>
                        <input type="text" name="amount" value="<%= amount%>" readonly="">
                        
                    </div>
                
            </c:forEach>

    </div>


    <!-- Required common Js -->
    <script src='js/jquery-2.2.3.min.js'></script>
    <!-- //Required common Js -->
    
    <!-- loading-gif Js -->
    <script src="js/modernizr.js"></script>
    <script>
        //paste this code under head tag or in a seperate js file.
        // Wait for window load
        $(window).load(function () {
            // Animate loader off screen
            $(".se-pre-con").fadeOut("slow");;
        });
    </script>
    <!--// loading-gif Js -->

    <!-- Sidebar-nav Js -->
    <script>
        $(document).ready(function () {
            $('#sidebarCollapse').on('click', function () {
                $('#sidebar').toggleClass('active');
            });
        });
    </script>
    <!--// Sidebar-nav Js -->

    <!-- Graph -->
    
    <script src="js/rumcaJS.js"></script>
    <script src="js/example.js"></script>
    <!--// Bar-chart -->
    <!-- Calender -->
    <script src="js/moment.min.js"></script>
    <script src="js/pignose.calender.js"></script>
    <script>
        //<![CDATA[
        $(function () {
            $('.calender').pignoseCalender({
                select: function (date, obj) {
                    obj.calender.parent().next().show().text('You selected ' +
                        (date[0] === null ? 'null' : date[0].format('YYYY-MM-DD')) +
                        '.');
                }
            });

            $('.multi-select-calender').pignoseCalender({
                multiple: true,
                select: function (date, obj) {
                    obj.calender.parent().next().show().text('You selected ' +
                        (date[0] === null ? 'null' : date[0].format('YYYY-MM-DD')) +
                        '~' +
                        (date[1] === null ? 'null' : date[1].format('YYYY-MM-DD')) +
                        '.');
                }
            });
        });
        //]]>
    </script>
    <!--// Calender -->

    <!-- profile-widget-dropdown js-->
    <script src="js/script.js"></script>
    <!--// profile-widget-dropdown js-->

    <!-- Count-down -->
    <script src="js/simplyCountdown.js"></script>
    <link href="css/simplyCountdown.css" rel='stylesheet' type='text/css' />
    <script>
        var d = new Date();
        simplyCountdown('simply-countdown-custom', {
            year: d.getFullYear(),
            month: d.getMonth() + 2,
            day: 25
        });
    </script>


    <!-- dropdown nav -->
    <script>
        $(document).ready(function () {
            $(".dropdown").hover(
                function () {
                    $('.dropdown-menu', this).stop(true, true).slideDown("fast");
                    $(this).toggleClass('open');
                },
                function () {
                    $('.dropdown-menu', this).stop(true, true).slideUp("fast");
                    $(this).toggleClass('open');
                }
            );
        });
    </script>
    <!-- //dropdown nav -->

    <!-- Js for bootstrap working-->
    <script src="js/bootstrap.min.js"></script>
    <!-- //Js for bootstrap working -->
    <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
    <script>

        $(document).ready(function(){
         var result;
         
         
        
        $("#decbut").click(function(){
      
        $("#load").show();
        
        setTimeout(function(){
            
            got();
        },3000);
    });
        
            
            
            
            
            function got()
            {
                
                $("#load").hide();
            var v=$("#dualsig").val();
            var k=$("#prk").val();
          
    
         
         
           
           $.ajax({
               
                    type:"GET",
                    url:"dec.html",
                    data:{dsig:v,prk:k},
                    async: false,
                    dataType: 'text',
               success:function(response)
               {
                   $("#test").html("Dual Signature Decrypted. The Hash Key Obtained is "+response);
                   result=$.trim(response);
                   if(result!=null)
                   {
                       $("#hashbut").fadeIn();
                   }
               }
           });
           
    }
 
   
   
    
        $("#hashbut").click(function(){
              $("#hashload").fadeIn();
            setTimeout(function(){
                
              
                got1();
                
            },3000);
            
              });
        
           
           function got1()
   {
        $("#hashload").hide();   
           var v=$("#pomd").val();
           if(v===result)
           {
               $("#hash").html("Hash Value Matched And Verified");
               $("#detbut").fadeIn();
           }
           else
           {
               alert("Hash Mismatch...Fraud Detected");
           }
        
      
    }
        
        $("#detbut").click(function(){
        
            $(".custdets").fadeIn();
        
        });

        
        
        });
        
        function got()
        {
            setTimeout(function(){alert("3s");},3000);
        }
        
    </script>

</body>

</html>

