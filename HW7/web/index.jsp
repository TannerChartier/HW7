<%-- 
    Document   : index
    Created on : Oct 16, 2015, 1:36:17 PM
    Author     : Tanner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tanner's HW4</title>
        <link rel="stylesheet" type="text/css" href="css/TopGear.css" />
    </head>
    <body>
        <div class="wrap">  <!--div to hold all the other divs -->    

            <div class="header">    <!--header div -->

                <div class="headerImg">     <!--Header Image div -->
                    <img src="img/logo.png" height="150px" />
                </div>                      <!--Close Header Image Div -->


                <div class="headerText">    <!--Header Text Div -->
                    <h1>Top Gear Episodes Web App</h1>                
                </div>                      <!--Close Header Text div -->

                <br clear="all">
            </div>                  <!--close header div -->


            <!--http://css.maxdesign.com.au/listamatic/horizontal32.htm-->

            <div class="navcontainer">
                <ul class="navlist">
                    <li class="active"><a href="index.jsp" id="current">Home</a></li>
                    <li><a href="read">View All Episodes</a></li>
                    <li><a href="add">Add An Episode</a></li>
                    <li><a href="search.jsp">Search Episodes</a></li>
                </ul>
                <br clear="all">
            </div>

            <div class="main">      <!--main div -->
                <h3>  </h3>
                <p>
                    Please choose an option from the menu bar.
                </p>


                <br clear="all">
            </div>                  <!--close main div -->



            <div class="footer">
                &copy; Copyright 2015 SoftwareDesignAndDevelopment.com | All rights reserved | <a href="sitemap.jsp">Site Map</a>
            </div>

        </div>              <!--close the wrap div -->

    </body>
</html>
