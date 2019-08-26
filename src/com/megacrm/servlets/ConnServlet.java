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

import com.megacrm.beans.Convo;
import com.megacrm.connect.DataBaseManager;
import com.megacrm.dao.ConvoDAO;

/**
 * Servlet implementation class ConnServlet
 */
public class ConnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String contactid = request.getParameter("contactid");
		String name = request.getParameter("firstname");
		String phoneno = request.getParameter("phoneno");
		String convo = request.getParameter("convo");
		String details = request.getParameter("details");
		Connection con = null;
		Statement stmt = null;
		if(convo!= null && details!=null)
		{
			try {
				DataBaseManager.doConnectionSetupIfRequired( request.getRealPath("config.properties") );
				System.out.println(request.getRealPath("config.properties"));
				con = DataBaseManager.giveConnection();
				stmt = con.createStatement();
				String sql = "INSERT INTO CONN VALUES("+contactid+",'"+name+"',"+phoneno+",CURRENT_TIMESTAMP,'"+convo+"','"+details+"')";
				System.out.println(sql);
				stmt.execute(sql);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally {
				DataBaseManager.close(stmt);
				stmt = null;
				DataBaseManager.close(con);
				con = null;
			}
		}
		int page = 1;
		int recordsPerPage = 10;
		if(request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));
		ConvoDAO dao = new ConvoDAO();
		List<Convo> list = dao.viewAllAccounts((page-1)*recordsPerPage,
								 recordsPerPage);
		int noOfRecords = dao.getNoOfRecords();
		int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
		request.setAttribute("convoList", list);
		request.setAttribute("noOfPages", noOfPages);
		request.setAttribute("currentPage", page);
		RequestDispatcher view = request.getRequestDispatcher("view/convo.jsp");
		view.forward(request, response);
	}

}
