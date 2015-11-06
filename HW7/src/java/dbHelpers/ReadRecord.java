/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Tanner
 */
public class ReadRecord
{

	private Connection conn;
	private ResultSet results;

	private Episodes episode;
	private int episodeID;

	public ReadRecord(int episodeID)
	{
		Properties props = new Properties();	//MWC
		InputStream instr = getClass().getResourceAsStream("dbConn.properties");
		try
		{
			props.load(instr);
		} catch (IOException ex)
		{
			Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
		}
		try
		{
			instr.close();
		} catch (IOException ex)
		{
			Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
		}

		String driver = props.getProperty("driver.name");					//gets the drivername to load
		String url = props.getProperty("server.name");					//gets server name
		String username = props.getProperty("user.name");					//gets username
		String passwd = props.getProperty("user.password");				//gets password

		this.episodeID = episodeID;

		try
		{
			Class.forName(driver);									//how we load the driver -> ojdb6.jar
		} catch (ClassNotFoundException ex)
		{
			Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
		}
		try
		{
			conn = DriverManager.getConnection(url, username, passwd);		//performing connection
		} catch (SQLException ex)
		{
			Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void doRead()
	{
		try
		{
			String query = "Select * from TOPGEAR WHERE episodeID = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, episodeID);
			
			this.results = ps.executeQuery();

			this.results.next();

			episode.setEpisodeID(this.results.getInt("EPISODEID"));
			episode.setSeasonNum(this.results.getInt("SEASONNUMBER"));
			episode.setEpisodeNum(this.results.getInt("EPISODENUMBER"));
			episode.setEpisodeTitle(this.results.getString("EPISODETITLE"));
			episode.setEpisodeDescription(this.results.getString("EPISODEDESCR"));
		} catch (SQLException ex)
		{
			Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public Episodes getEpisode()
	{
		return this.episode;
	}
}
