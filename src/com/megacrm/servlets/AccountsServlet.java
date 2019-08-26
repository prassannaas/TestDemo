package com.megacrm.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.megacrm.beans.Accounts;
import com.megacrm.connect.DataBaseManager;
import com.megacrm.dao.AccountsDAO;

/**
 * Servlet implementation class AccountsServlet
 */
public class AccountsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		int page = 1;
		int recordsPerPage = 10;
		if(request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));
		AccountsDAO dao = new AccountsDAO();
		List<Accounts> list = dao.viewAllAccounts((page-1)*recordsPerPage,
								 recordsPerPage);
		int noOfRecords = dao.getNoOfRecords();
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		request.setAttribute("accountstList", list);
		request.setAttribute("noOfPages", noOfPages);
		request.setAttribute("currentPage", page);
		RequestDispatcher view = request.getRequestDispatcher("view/accounts.jsp");
		view.forward(request, response);
	}

}
