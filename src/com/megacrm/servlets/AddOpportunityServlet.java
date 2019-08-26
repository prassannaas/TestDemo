package com.megacrm.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.megacrm.connect.DataBaseManager;
import com.megacrm.dao.OpportunitiesDAO;
import com.megacrm.listener.MegaCRMHttpSessionListener;
import com.megacrm.utils.Constants;

/**
 * Servlet implementation class AddOpportunityServlet
 */
public class AddOpportunityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOpportunityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String subject = request.getParameter("subject");
		String account = request.getParameter("account");
		String type = request.getParameter("type");
		String status = request.getParameter("status");
		String probability = request.getParameter("probability");
		String notes = request.getParameter("notes");
		
		Connection con = null;
		
		if(subject !=null && account!=null && type!=null && status!=null && probability!=null && notes!=null){
			try {
				// if active session is above 50 thn wait for 10 seconds
				if( MegaCRMHttpSessionListener.nActiveSessionCount > 50 ){
					Thread.sleep(10000);
				}
				
				DataBaseManager.doConnectionSetupIfRequired( request.getRealPath("config.properties") );
				con = DataBaseManager.giveConnection();
				
				(new OpportunitiesDAO()).addOpportunities(con, subject, account, type, status, probability, notes);
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if( Constants.MAKE_PERFORMANCE_ISSUES ) {
					DataBaseManager.close(con);
					con = null;
				}
			}
		}
		RequestDispatcher view = request.getRequestDispatcher("/OpportunityServlet");
		view.forward(request, response);
	}
}
