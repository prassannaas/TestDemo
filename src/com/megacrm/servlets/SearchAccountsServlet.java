package com.megacrm.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.megacrm.beans.Accounts;
import com.megacrm.dao.AccountsDAO;

/**
 * Servlet implementation class SearchAccountsServlet
 */
public class SearchAccountsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAccountsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Displaying search results
		
		String search = request.getParameter("search");
		if(search != null && search != ""){
			//int page1 = 1;
			//int recordsPerPage1 = 5;
//			if(request.getParameter("page") != null)
//				page1 = Integer.parseInt(request.getParameter("page"));
			AccountsDAO dao = new AccountsDAO();
			List<Accounts> list = dao.viewSearchResults(search);
			//int noOfRecords = dao.getNoOfRecords();
			//int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage1);
			request.setAttribute("accountstList", list);
			//request.setAttribute("noOfPages", noOfPages);
			//request.setAttribute("currentPage", page1);
			RequestDispatcher view = request.getRequestDispatcher("view/accounts.jsp");
			view.forward(request, response);
		}
		else
		{
			RequestDispatcher view = request.getRequestDispatcher("AccountsServlet?page=1");
			view.forward(request, response);
		}
	}

}
