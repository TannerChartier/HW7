package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Episodes;

public class ReadQuery
{

	private Connection conn;
	private ResultSet results;

	public ReadQuery()
	{
		Properties props = new Properties();	//MWC
		InputStream instr = getClass().getResourceAsStream("dbConn.properties");
		try
		{
			props.load(instr);
		} catch (IOException ex)
		{
			Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
		}
		try
		{
			instr.close();
		} catch (IOException ex)
		{
			Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
		}

		String driver = props.getProperty("driver.name");					//gets the drivername to load
		String url = props.getProperty("server.name");					//gets server name
		String username = props.getProperty("user.name");					//gets username
		String passwd = props.getProperty("user.password");				//gets password
		try
		{
			Class.forName(driver);									//how we load the driver -> ojdb6.jar
		} catch (ClassNotFoundException ex)
		{
			Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
		}
		try
		{
			conn = DriverManager.getConnection(url, username, passwd);		//performing connection
		} catch (SQLException ex)
		{
			Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void doRead()
	{
		try
		{
			String query = "Select * from TOPGEAR";

			PreparedStatement ps = conn.prepareStatement(query);
			this.results = ps.executeQuery();
		} catch (SQLException ex)
		{
			Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public String getHTMLTable()
	{
		String table = "";

		table += "<table class='Main'>";	//change this to id= or class =
			table += "<tr>";
				table += "<td class='Headers'>";
					table += "Season #";
				table += "</td>";

				table += "<td class='Headers'>";
					table += "Episode #";
				table += "</td>";

				table += "<td class='Headers'>";
					table += "Episode Title";
				table += "</td>";

				table += "<td class='Headers'>";
					table += "Episode Description";
				table += "</td>";

				table += "<td class='Headers'>";

				table += "</td>";
			table += "</tr>";
		try
		{
			while (this.results.next())			//as long as next record, get info and put in model
			{
				Episodes episode = new Episodes();
				episode.setEpisodeID(this.results.getInt("EPISODEID"));
				episode.setSeasonNum(this.results.getInt("SEASONNUMBER"));
				episode.setEpisodeNum(this.results.getInt("EPISODENUMBER"));
				episode.setEpisodeTitle(this.results.getString("EPISODETITLE"));
				episode.setEpisodeDescription(this.results.getString("EPISODEDESCR"));
				
				table += "<tr class='Entry'>";
					//table += "<td>";
					//	table += episode.getEpisodeID();
					//table += "</td>";

					table += "<td class='Centered'>";
						table += episode.getSeasonNum();
					table += "</td>";

					table += "<td class='Centered'>";
						table += episode.getEpisodeNum();
					table += "</td>";

					table += "<td class ='Title'>";
						table += episode.getEpisodeTitle();
					table += "</td>";

					table += "<td class='Description'>";
						table += episode.getEpisodeDescription();
					table += "</td>";
					
					table += "<td>";
						table += "<a href=update?ID=" + String.valueOf(episode.getEpisodeID()) + "> Update </a>" + "<a href=delete?episodeID=" + episode.getEpisodeID() + "> Delete </a>";
						
					table += "</td>";
				table += "</tr>";
			}
		} catch (SQLException ex)
		{
			Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
		}

		table += "</table>";

		return table;
	}
}
