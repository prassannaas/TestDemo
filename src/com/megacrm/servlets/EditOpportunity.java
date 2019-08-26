package com.megacrm.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.megacrm.connect.DataBaseManager;
import com.megacrm.utils.Constants;

/**
 * Servlet implementation class EditOpportunity
 */
public class EditOpportunity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditOpportunity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opportunityid = request.getParameter("opportunityid");
		String subject = request.getParameter("subject");
		String account = request.getParameter("account");
		String type = request.getParameter("type");
		String status = request.getParameter("status");
		String probability = request.getParameter("probability");
		String notes = request.getParameter("notes");
		Connection con = null;
		Statement stmt = null;
		
		if(subject !=null){
			try {
				DataBaseManager.doConnectionSetupIfRequired( request.getRealPath("config.properties") );
				con = DataBaseManager.giveConnection();
				stmt = con.createStatement();
				String sql = "update opportunities set opportunityid="+opportunityid+", subject='"+subject+"',account='"+account+"',type='"+type+"',status='"+status+"', probability='"+probability+"',notes='"+notes+"' where opportunityid="+opportunityid;
				stmt.execute(sql);
				
				dummyDelay1();
				
				RequestDispatcher rd = request.getRequestDispatcher("/OpportunityServlet?page=1");
				rd.forward(request, response);
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
				
				dummyDelay2();
			}
		}
	}
	
	public static void dummyDelay1() {
		System.out.println("Dummy Delay-1 Started: "+new Date().getTime());
		
//		for(int i=0; i<Constants.DUMMY_DELAY_LOOP_1; i++)
//			for(int j=0; j<Constants.DUMMY_DELAY_LOOP_2; j++)
//				for(int k=0; k<Constants.DUMMY_DELAY_LOOP_3; k++);
		
		try {
			Thread.sleep(25000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		dummyDelay2();
		
		System.out.println("Dummy Delay-1 Completed: "+new Date().getTime());
	}
	
	public static void dummyDelay2() {
		System.out.println("Dummy Delay-2 Started: "+new Date().getTime());
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Dummy Delay-2 Completed: "+new Date().getTime());
	}
}
