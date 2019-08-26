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
 * Servlet implementation class DeleteOpportunity
 */
public class DeleteOpportunity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteOpportunity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opportunityid = request.getParameter("opportunityid");
		Connection con = null;
		Statement stmt = null;
		if(opportunityid !=null)
		{
			try {
				DataBaseManager.doConnectionSetupIfRequired( request.getRealPath("config.properties") );
				System.out.println(request.getRealPath("config.properties"));
				con = DataBaseManager.giveConnection();
				stmt = con.createStatement();
				String mandatorysql = "delete from oconvos where opportunityid="+opportunityid;
				System.out.println(mandatorysql);
				stmt.execute(mandatorysql);
				String sql = "delete from opportunities where opportunityid="+opportunityid;
				System.out.println(sql);
				stmt.execute(sql);
				RequestDispatcher view = request.getRequestDispatcher("/OpportunityServlet?page=1");
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
