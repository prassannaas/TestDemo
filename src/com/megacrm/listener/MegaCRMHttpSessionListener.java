package com.megacrm.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Do the relative operation on Login & Logout.
 * Maintains and process the active sessions.
 * 
 * @author Ramkumar
 *
 */
public class MegaCRMHttpSessionListener implements HttpSessionListener {
	
	// active session count
	public static int nActiveSessionCount = 0;
	
	public void sessionCreated(HttpSessionEvent se) {
		synchronized (this) {
			// increase session count
			//nActiveSessionCount++;
			//System.out.println("new session created: "+nActiveSessionCount);
		}
	}
	
	public void sessionDestroyed(HttpSessionEvent se) {
		synchronized (this) {
			// decrease session count
			nActiveSessionCount--;
			//System.out.println("session destoryed: "+nActiveSessionCount);
		}
	}
}
