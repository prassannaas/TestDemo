package com.megacrm.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.megacrm.connect.DataBaseManager;

/**
 * Servlet implementation class EditAccount
 */
public class EditAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String name1 = request.getParameter("name1");
		String accountid = request.getParameter("accountid");
		String name = request.getParameter("name");
		String website = request.getParameter("website");
		String city = request.getParameter("city");
		String boardphno = request.getParameter("boardphno");
		String industry = request.getParameter("industry");
		String employees = request.getParameter("employees");
		String branches = request.getParameter("branches");
		String revenue = request.getParameter("revenue");
		Connection con = null;
		Statement stmt = null;
		if(name !=null){
			try {
				DataBaseManager.doConnectionSetupIfRequired( request.getRealPath("config.properties") );
				System.out.println(request.getRealPath("config.properties"));
				con = DataBaseManager.giveConnection();
				stmt = con.createStatement();
				String sql = "update accounts set accountid="+accountid+", name='"+name+"',website='"+website+"',city='"+city+"',boardphno="+boardphno+", industry='"+industry+"',employees="+employees+",branches="+branches+", revenue="+revenue+" where accountid="+accountid;
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
		RequestDispatcher view = request.getRequestDispatcher("/AccountsServlet?page=1");
		view.forward(request, response);
	}
}
