package com.megacrm.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.megacrm.beans.Opportunities;
import com.megacrm.dao.OpportunitiesDAO;

/**
 * Servlet implementation class GetOpportunity
 */
public class GetOpportunity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOpportunity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opportunityid = request.getParameter("opportunityid");
		OpportunitiesDAO dao = new OpportunitiesDAO();
		List<Opportunities> list = dao.viewRecord(opportunityid);
		request.setAttribute("opportunitiesList", list);
		RequestDispatcher view = request.getRequestDispatcher("/OAccServlet");
		view.forward(request, response);
	}

}
