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
 * Servlet implementation class SearchOpportunitiesServlet
 */
public class SearchOpportunitiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchOpportunitiesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Displaying search results
		
				String search = request.getParameter("search");
				if(search != null&& search!=""){
					
					OpportunitiesDAO dao = new OpportunitiesDAO();
					List<Opportunities> list = dao.viewSearchResults(search);
					
					request.setAttribute("opportunitiesList", list);
					//request.setAttribute("noOfPages", noOfPages);
					//request.setAttribute("currentPage", page1);
					RequestDispatcher view = request.getRequestDispatcher("view/opportunities.jsp");
					view.forward(request, response);
				}
				else
				{
					RequestDispatcher view = request.getRequestDispatcher("OpportunityServlet?page=1");
					view.forward(request, response);
				}
	}

}
