package com.megacrm.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.megacrm.beans.ContactBean;
import com.megacrm.dao.ContactsDAO;

/**
 * Servlet implementation class GetContact
 */
public class GetContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String contactid = request.getParameter("contactid");
		ContactsDAO dao = new ContactsDAO();
		List<ContactBean> list = dao.viewRecord(contactid);
		request.setAttribute("contactList", list);
		RequestDispatcher view = request.getRequestDispatcher("view/editContact.jsp");
		view.forward(request, response);
		
	}

}
