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
        <h1>Add A New Top Gear Episode</h1>
        <div class="addWrapper">
            <form class="add" name="addForm" action="addEpisode" method="get">

                <label class="add">Season Number:</label>
                <input type="text" name="season" value ="" />
                <br>
                <label class="add">Episode Number:</label>
                <input type="text" name="episode" value ="" />
                <br>
                <label class="add">Episode Title:</label>
                <input type="text" name="episodeTitle" value ="" />
                <br>
                <label class="add">Episode Description:</label>
                <input type="text" name="episodeDescription" value ="" />
                <br>
                <input type="submit" name="submit" value="Submit" />

            </form>
        </div>
    </body>
</html>
