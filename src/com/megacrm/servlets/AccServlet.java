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
 * Servlet implementation class AccServlet
 */
public class AccServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AccountsDAO dao = new AccountsDAO();
		List<Accounts> list = dao.viewAllAccounts1();

		request.setAttribute("accountstList", list);

		RequestDispatcher view = request.getRequestDispatcher("view/addopportunity.jsp");
		view.forward(request, response);
	}

}
