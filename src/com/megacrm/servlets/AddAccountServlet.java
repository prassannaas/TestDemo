package com.megacrm.servlets;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.RandomUtils;

import com.megacrm.connect.DataBaseManager;
import com.megacrm.dao.AccountsDAO;
import com.megacrm.utils.Constants;
import com.megacrm.utils.FileOpertionUtils;

/**
 * Servlet implementation class AddAccountServlet
 */
public class AddAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String website = request.getParameter("website");
		String city = request.getParameter("city");
		String boardphno = request.getParameter("boardphno");
		String industry = request.getParameter("industry");
		String employees = request.getParameter("employees");
		String branches = request.getParameter("branches");
		String revenue = request.getParameter("revenue");
		
		Connection con = null;
		
		String strFileName = null, strFilePath = null;

		if(name !=null && website!=null && city!= null && boardphno!= null && industry!=null && employees != null && branches!= null && revenue != null){
			try {
				DataBaseManager.doConnectionSetupIfRequired( request.getRealPath("config.properties") );
				con = DataBaseManager.giveConnection();
				
				// Add Account
				(new AccountsDAO()).addAccounts(con, name, website, city, boardphno, industry, employees, branches, revenue);
				
				// Read an one MB file
				if( Constants.MAKE_PERFORMANCE_ISSUES ) {
					strFileName = "1mb_file.txt";
					strFilePath = request.getRealPath("")+File.separator+strFileName;
					
					(new FileOpertionUtils()).readFromFile( strFilePath );
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				DataBaseManager.close(con);
				con = null;
			}
		}
		RequestDispatcher view = request.getRequestDispatcher("AccountsServlet?page=1");
		view.forward(request, response);
	}

}
