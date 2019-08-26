package com.megacrm.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.megacrm.connect.DataBaseManager;

/**
 * Servlet implementation class DeleteContact
 */
public class DeleteContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String contactid = request.getParameter("contactid");
		Statement stmt = null;
		Connection con = null;
		if(contactid !=null)
		{
			try {
				DataBaseManager.doConnectionSetupIfRequired( request.getRealPath("config.properties") );
				System.out.println(request.getRealPath("config.properties"));
				con = DataBaseManager.giveConnection();
				System.out.println(con);
				stmt = con.createStatement();
				String mandatorysql = "delete from convos where contactid="+contactid;
				System.out.println(mandatorysql);
				stmt.execute(mandatorysql);
				String sql = "delete from contacts where contactid="+contactid;
				System.out.println(sql);
				stmt.execute(sql);
				RequestDispatcher view = request.getRequestDispatcher("/ContactsServlet?page=1");
				view.forward(request, response);
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
	}

	
}
