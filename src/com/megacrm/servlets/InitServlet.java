package com.megacrm.servlets;

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.megacrm.utils.Constants;

/**
 * Servlet to handle one operation for the whole application
 * 
 * @author navin
 * 
 */
public class InitServlet extends HttpServlet {
	// set log access

	private static final long serialVersionUID = 1L;
	public static String realPath = null;
	public static TimerTask timerTaskLoadTest = null, timerTaskProcessingQueue = null, timerTaskCount = null, timerTaskPaid = null, timerJmeter = null, timerJmeterPro = null, timerJmeterDrain = null;
	public static Timer timerLT = new Timer(), timerProcessing = new Timer(), timerCount = new Timer(), timerPaid = new Timer(), timerJM = new Timer(),timerJMPro = new Timer(),timerJMDrain = new Timer();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public void init() {
		ServletContext context = getServletContext();
		
		realPath = context.getRealPath("//");
		
		try {
			Constants.CONSTANTS_FILE_PATH = InitServlet.realPath + File.separator+"config.properties";
			
			// Loads Constant properties
			Constants.loadConstantsProperties(Constants.CONSTANTS_FILE_PATH);
			
		} catch (Throwable e) {
			System.out.println("Exception in InitServlet.init: "+e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
