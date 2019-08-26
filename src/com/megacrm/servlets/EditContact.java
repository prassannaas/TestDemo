package com.megacrm.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.megacrm.beans.ContactBean;
import com.megacrm.connect.DataBaseManager;
import com.megacrm.utils.Constants;

/**
 * Servlet implementation class EditContact
 */
public class EditContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContactBean contact = new ContactBean();
		
		if( request.getParameter("contactid") != null ) {
			contact.setContactid( Integer.parseInt( request.getParameter("contactid") ) );
		}
		contact.setFirstname( request.getParameter("firstname") );
		contact.setLastname( request.getParameter("lastname") );
		contact.setDesignation( request.getParameter("designation") );
		contact.setEmail( request.getParameter("email") );
		if( request.getParameter("phoneno") != null ) {
			contact.setPhoneno( Integer.parseInt( request.getParameter("phoneno") ) );
		}
		contact.setCity( request.getParameter("city") );
		contact.setCompany( request.getParameter("company") );
		
		Constants.alContactsInvolved.add( contact.toHashMap() );
		
		Connection con = null;
		Statement stmt = null;
		
		if( contact.getFirstname() !=null){
			try {
				DataBaseManager.doConnectionSetupIfRequired( request.getRealPath("config.properties") );
				con = DataBaseManager.giveConnection();
				stmt = con.createStatement();
				
				String sql = "update contacts set contactid="+contact.getContactid()+", firstname='"+contact.getFirstname()+"',lastname='"+contact.getLastname()+"',designation='"+contact.getDesignation()+"',email='"+contact.getEmail()+"', city='"+contact.getCity()+"',company='"+contact.getCompany()+"',phoneno="+contact.getPhoneno()+" where contactid="+contact.getContactid()+"";
				
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
			
			
			RequestDispatcher view = request.getRequestDispatcher("ContactsServlet?page=1");
			view.forward(request, response);
		}
	}
}
