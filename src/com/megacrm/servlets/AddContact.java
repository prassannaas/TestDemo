package com.megacrm.servlets;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.RandomUtils;

import com.megacrm.connect.DataBaseManager;
import com.megacrm.dao.ContactsDAO;
import com.megacrm.listener.MegaCRMHttpSessionListener;
import com.megacrm.utils.Constants;
import com.megacrm.utils.FileOpertionUtils;

/**
 * Servlet implementation class AddContact
 */
public class AddContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String designation = request.getParameter("designation");
		String email = request.getParameter("email");
		String phone = request.getParameter("phoneno");
		String city = request.getParameter("city");
		String company = request.getParameter("company");
		Connection con = null;
		Statement stmt = null;
		
		String strFileName = null, strFilePath = null;
		
		if( firstname !=null && lastname!= null && designation!=null && email!=null && phone!=null && city!=null && company!=null ) {
			try {
				// if active session is above 50 then wait for 10 seconds
				if( MegaCRMHttpSessionListener.nActiveSessionCount > 50 ){
					Thread.sleep(10000);
				}
				
				DataBaseManager.doConnectionSetupIfRequired( request.getRealPath("config.properties") );
				con = DataBaseManager.giveConnection();
				
				// Add Contact
				(new ContactsDAO()).addContacts(con, firstname, lastname, designation, email, city, company, phone);
				
				// write 500 character String in a file
				if( Constants.MAKE_PERFORMANCE_ISSUES ) {
					strFileName = "file_write_"+RandomUtils.nextInt()+".txt";
					strFilePath = request.getRealPath("")+File.separator+strFileName;
					(new FileOpertionUtils()).writeIntoFile( strFilePath );
					
					// remove the file from disk
					if( new File(strFileName).exists() ) {
						new File(strFileName).delete();
					}
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				DataBaseManager.close(stmt);
				stmt = null;
				
				DataBaseManager.close(con);
				con = null;
			}
			
		}
		RequestDispatcher view = request.getRequestDispatcher("/ContactsServlet");
		view.forward(request, response);
	}

}
