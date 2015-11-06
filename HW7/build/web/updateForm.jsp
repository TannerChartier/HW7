<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Episodes"%>
<% Episodes episode = (Episodes) request.getAttribute("episode"); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update A Top Gear Episode</title>
        <link rel="stylesheet" type="text/css" href="css/TopGear.css" />
    </head>
    <body>
        <h1>Update A Top Gear Episode</h1>
        <div class="addWrapper">
            <form class="add" name="updateForm" action="updateEpisode" method="get">
                <table class="update">
                    <tr>
                        <td class="right">Episode ID:</td>
                        <td><input type="text" name="episodeID" value="<%=String.valueOf(episode.getEpisodeID())%>" /></td>
                    </tr>

                    <tr>
                        <td class="right">Season Number:</td>
                        <td><input type="text" name="season" value ="<%= episode.getSeasonNum() %>" /></td>
                    </tr>

                    <tr>
                        <td class="right">Episode Number:</td>
                        <td><input type="text" name="episode" value ="<%= episode.getEpisodeNum() %>" /></td>
                    </tr>

                    <tr>
                        <td class="right">Episode Title:</td>
                        <td><input type="text" name="episodeTitle" value ="<%= episode.getEpisodeTitle() %>" /></td>
                    </tr>

                    <tr>
                        <td class="right">Episode Description:</td>
                        <td><input type="text" name="episodeDescription" value ="<%= episode.getEpisodeDescription()%>" /></td>
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
