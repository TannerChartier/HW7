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
        </div>
    </body>
</html>
