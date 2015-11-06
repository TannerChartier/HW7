<%-- 
    Document   : add
    Created on : Oct 28, 2015, 8:49:32 PM
    Author     : Tanner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add A New Top Gear Episode</title>
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
                <h3> Add A New Top Gear Episode </h3>
                <div class="addWrapper">
                    <form class="add" name="addForm" action="addEpisode" method="get">
                        <table class="add">
                            <tr>
                                <td class="right">Season Number:</td>
                                <td><input type="text" name="season" value ="" /></td>
                            </tr>

                            <tr>
                                <td class="right">Episode Number:</td>
                                <td><input type="text" name="episode" value ="" /></td>
                            </tr>

                            <tr>
                                <td class="right">Episode Title:</td>
                                <td><input type="text" name="episodeTitle" value ="" /></td>
                            </tr>

                            <tr>
                                <td class="right">Episode Description:</td>
                                <td><input type="text" name="episodeDescription" value ="" /></td>
                            </tr>

                            <tr>
                                <td><input type="submit" name="submit" value="Submit" /></td>
                                <td><input type="reset" name="clear" value="Clear" /></td>
                            </tr>

                        </table>
                    </form>
                    <br clear="all">
                </div>
            </div>                  <!--close main div -->



            <div class="footer">
                &copy; Copyright 2015 SoftwareDesignAndDevelopment.com | All rights reserved | <a href="sitemap.jsp">Site Map</a>
            </div>

        </div>              <!--close the wrap div -->

    </body>
</html>
