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
 * Servlet implementation class OAccServlet
 */
public class OAccServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OAccServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AccountsDAO dao = new AccountsDAO();
		List<Accounts> list = dao.viewAllAccounts1();

		request.setAttribute("accountstList", list);

		RequestDispatcher view = request.getRequestDispatcher("view/editOpportunity.jsp");
		view.forward(request, response);
	}

}
