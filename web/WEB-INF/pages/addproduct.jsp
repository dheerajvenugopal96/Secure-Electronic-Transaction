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
    <link href="css/styleadd.css" rel="stylesheet" type="text/css"/>
    <!--web-fonts-->
    <link href="//fonts.googleapis.com/css?family=Poiret+One" rel="stylesheet">
    <link href="//fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
    <script src='js/jquery-2.2.3.min.js'></script>
    <!--//web-fonts-->
    
    <c:if test="${not empty msg}">
    <script>
        
        alert("Card Details Are Pending");
        window.location.href="addmerchantcard.html";
        
        
    </script>
    </c:if>
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
                    <a href="addproduct.html">
                        <i class="fa fa-plus"></i>
                        Add Products
                    </a>
                </li>
                
            </ul>
        </nav>

        <!-- Page Content Holder -->
        <div id="content">
        <!-- Product Add Holder -->
            
        <div class="beautyform">
            <form action="insertproduct.html" method="post" class="addproductform" enctype="multipart/form-data">
            <div class="imageselect" id="imageselect">
                <img id="image" style="width:100%;height:100%;" alt="No Image Selected">
            </div>
            <input type="hidden" id="merid" name="merid" value="<%=session.getAttribute("idd")%>" > 
            <label>Add Product Image</label><br>
            <input type="file" id="file" name="file" accept="image/gif, image/jpeg, image/png" required="">
            <label>Enter Electronics Category</label><br>
            <input type="text" id="cat" name="cat" required="">
            <label>Enter Brand Name</label><br>
            <input type="text" id="brand" name="brand" required="">
            <label>Enter Product Name</label><br>
            <input type="text" id="product" name="product" required="">
            <label>Enter Product Description</label><br>
            <textarea type="text" id="description" name="description" required=""></textarea>
            <label>Enter Price in Rupees</label>
            <input type="text" id="price" name="price" required="">
            <label>Enter Product Quantity</label>
            <input type="text" id="quantity" name="quantity" required="">
            <input type="submit" name="sub" value="Add Item">
            
	</form>
        </div>
         <!-- Product Add Holder -->
    </div>


    <!-- Required common Js -->
    
    <!-- //Required common Js -->
    
    <!-- loading-gif Js -->
    <script>
        
        document.getElementById("file").onchange=function()
        {
            var reader=new FileReader();
            
            reader.onload=function(e)
            {
                
                document.getElementById("image").src=e.target.result;
            
            };
            reader.readAsDataURL(this.files[0]);
        };
        
        
    </script>
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

</body>

</html>

