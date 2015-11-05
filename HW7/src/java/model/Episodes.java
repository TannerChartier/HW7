/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Tanner
 */
public class Episodes
{
	private int episodeID;
	private int seasonNum;
	private int episodeNum;
	private String episodeTitle;
	private String episodeDescription;

	public Episodes()
	{
		this.episodeID = 0;
		this.seasonNum = 0;
		this.episodeNum = 0;
		this.episodeTitle = "";
		this.episodeDescription = "";
	}
	
	public Episodes(int episodeID, int seasonNum, int episodeNum, String episodeTitle, String episodeDescription)
	{
		this.episodeID = episodeID;
		this.seasonNum = seasonNum;
		this.episodeNum = episodeNum;
		this.episodeTitle = episodeTitle;
		this.episodeDescription = episodeDescription;
	}

	public int getEpisodeID()
	{
		return episodeID;
	}

	public void setEpisodeID(int episodeID)
	{
		this.episodeID = episodeID;
	}

	public int getSeasonNum()
	{
		return seasonNum;
	}

	public void setSeasonNum(int seasonNum)
	{
		this.seasonNum = seasonNum;
	}

	public int getEpisodeNum()
	{
		return episodeNum;
	}

	public void setEpisodeNum(int episodeNum)
	{
		this.episodeNum = episodeNum;
	}

	public String getEpisodeTitle()
	{
		return episodeTitle;
	}

	public void setEpisodeTitle(String episodeTitle)
	{
		this.episodeTitle = episodeTitle;
	}

	public String getEpisodeDescription()
	{
		return episodeDescription;
	}

	public void setEpisodeDescription(String episodeDescription)
	{
		this.episodeDescription = episodeDescription;
	}
	
	@Override
	public String toString()
	{
		return "Episodes{" + "episodeID=" + episodeID + ", seasonNum=" + seasonNum + ", episodeNum=" + episodeNum + ", episodeTitle=" + episodeTitle + ", episodeDescription=" + episodeDescription + '}';
	}
}
