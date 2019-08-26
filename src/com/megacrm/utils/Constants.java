package com.megacrm.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

public class Constants {
	
	public static String CONSTANTS_FILE_PATH = "";
	
	public static boolean MAKE_PERFORMANCE_ISSUES = false;
	
	public static int DUMMY_DELAY_LOOP_1 = 250000;
	public static int DUMMY_DELAY_LOOP_2 = 13940;
	public static int DUMMY_DELAY_LOOP_3 = 1;
	
	
	public static ArrayList< HashMap<String,String> > alContactsInvolved = new ArrayList< HashMap<String,String> >();
	
	public static void loadConstantsProperties(String srtConstantsPath) throws Exception {
		Properties prop = new Properties();
		InputStream is = null;
		
		try {
			is = new FileInputStream(srtConstantsPath);
			prop.load(is);
			
			if ( prop.getProperty("MAKE_PERFORMANCE_ISSUES") != null ) {
				MAKE_PERFORMANCE_ISSUES = Boolean.parseBoolean( prop.getProperty("MAKE_PERFORMANCE_ISSUES") );
				
				Constants.DUMMY_DELAY_LOOP_1 = Integer.parseInt( prop.getProperty("DUMMY_DELAY_LOOP_1") );
				Constants.DUMMY_DELAY_LOOP_2 = Integer.parseInt( prop.getProperty("DUMMY_DELAY_LOOP_2") );
				Constants.DUMMY_DELAY_LOOP_3 = Integer.parseInt( prop.getProperty("DUMMY_DELAY_LOOP_3") );
			}
			
		} catch(Throwable th) {
			System.out.println("Exception in loadConstantsProperties: "+th.getMessage());
			
			throw th;
		} finally {
			UtilsFactory.close(is);
			is = null;
		}
	}}
