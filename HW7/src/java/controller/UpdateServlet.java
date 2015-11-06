/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dbHelpers.UpdateQuery;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Episodes;

/**
 *
 * @author Tanner
 */
@WebServlet(name = "UpdateServlet", urlPatterns =
{
	"/updateEpisode"
})
public class UpdateServlet extends HttpServlet
{

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter())
		{
			/* TODO output your page here. You may use following sample code. */
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet UpdateServlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet UpdateServlet at " + request.getContextPath() + "</h1>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		doPost(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		//linked to updateform.jsp
		int episodeID = Integer.parseInt(request.getParameter("episodeID"));
		int seasonNum = Integer.parseInt(request.getParameter("season"));
		int episodeNum = Integer.parseInt(request.getParameter("episode"));
		String episodeTitle = request.getParameter("episodeTitle");
		String episodeDescription = request.getParameter("episodeDescription");

		Episodes episode = new Episodes();
		episode.setEpisodeID(episodeID);
		episode.setSeasonNum(seasonNum);
		episode.setEpisodeNum(episodeNum);
		episode.setEpisodeTitle(episodeTitle);
		episode.setEpisodeDescription(episodeDescription);

		//create an updateQuery object and use it toupdate the episode
		UpdateQuery uq = new UpdateQuery();
		uq.doUpdate(episode);

		//pass control onto read servlett
		String url = "/read";

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo()
	{
		return "Short description";
	}// </editor-fold>

}
