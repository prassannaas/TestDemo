package com.megacrm.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.megacrm.connect.DataBaseManager;
import com.megacrm.listener.MegaCRMHttpSessionListener;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		HttpSession session = request.getSession(true);
		try{
			session.setAttribute("username", userid);
			
			MegaCRMHttpSessionListener.nActiveSessionCount++;
			
			DataBaseManager.doConnectionSetupIfRequired( request.getRealPath("config.properties") );
		}catch(Exception ex){
			System.out.println("Exception in LoginServel: "+ex.getMessage());
			ex.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("view/home.jsp");
		rd.forward(request, response);
		
	}

}
