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
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tanner
 */
public class DeleteQuery
{
	private Connection conn;
	
	public DeleteQuery()
	{
		Properties props = new Properties();	//MWC
		InputStream instr = getClass().getResourceAsStream("dbConn.properties");
		try
		{
			props.load(instr);
		} catch (IOException ex)
		{
			Logger.getLogger(DeleteQuery.class.getName()).log(Level.SEVERE, null, ex);
		}
		try
		{
			instr.close();
		} catch (IOException ex)
		{
			Logger.getLogger(DeleteQuery.class.getName()).log(Level.SEVERE, null, ex);
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
			Logger.getLogger(DeleteQuery.class.getName()).log(Level.SEVERE, null, ex);
		}
		try
		{
			conn = DriverManager.getConnection(url, username, passwd);		//performing connection
		} catch (SQLException ex)
		{
			Logger.getLogger(DeleteQuery.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void doDelete(int episodeID)
	{
		try
		{
			//set up a string to hold our query
			String query = "DELETE FROM TopGear WHERE episodeID = ?";
			//create a preparedstatement using our query settings
			PreparedStatement ps = conn.prepareStatement(query);
			
			//fill in the preparedstatement
			ps.setInt(1, episodeID);
			//execute the query
			ps.executeUpdate();
		} catch (SQLException ex)
		{
			Logger.getLogger(DeleteQuery.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		
	}
}
