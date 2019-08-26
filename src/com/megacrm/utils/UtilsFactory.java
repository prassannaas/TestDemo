package com.megacrm.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Class which do some utilization operation.
 * 
 * @author Ramkumar R
 *
 */
public class UtilsFactory {
	
	/**
	 * Close the given InputStream
	 * 
	 * @param is
	 * @return
	 */
	public static boolean close(InputStream is){
		try{
			if(is != null){
				is.close();
			}
		}catch(Exception e){
			System.out.println("Exception: "+e.getMessage());
			e.printStackTrace();
			
			return false;
		}
		return true;
	}
	
	/**
	 * Close the given InputStreamReader
	 * 
	 * @param isr
	 * @return
	 */
	public static boolean close(InputStreamReader isr){
		try{
			if(isr != null){
				isr.close();
			}
		}catch(Exception e){
			System.out.println("Exception: "+e.getMessage());
			e.printStackTrace();
			
			return false;
		}
		return true;
	}
	
	/**
	 * Close the given BufferedReader
	 * 
	 * @param reader
	 * @return
	 */
	public static boolean close(BufferedReader reader){
		try{
			if(reader != null){
				reader.close();
			}
		}catch(Exception e){
			System.out.println("Exception: "+e.getMessage());
			e.printStackTrace();
			
			return false;
		}
		return true;
	}
	
	/**
	 * Close the given OutputStream
	 * 
	 * @param outputStream
	 * @return
	 */
	public static boolean close(OutputStream outputStream){
		try{
			if(outputStream != null){
				outputStream.close();
			}
		}catch(Exception e){
			System.out.println("Exception: "+e.getMessage());
			e.printStackTrace();
			
			return false;
		}
		return true;
	}

	/**
	 * Close the given PrintWriter
	 * 
	 * @param printWriter
	 * @return
	 */
	public static boolean close(PrintWriter printWriter){
		try{
			if(printWriter != null){
				printWriter.close();
			}
		}catch(Exception e){
			System.out.println("Exception: "+e.getMessage());
			e.printStackTrace();
			
			return false;
		}
		return true;
	}

	/**
	 * Close the given StringWriter
	 * 
	 * @param stringWriter
	 * @return
	 */
	public static boolean close(StringWriter stringWriter){
		try{
			if(stringWriter != null){
				stringWriter.close();
			}
		}catch(Exception e){
			System.out.println("Exception: "+e.getMessage());
			e.printStackTrace();
			
			return false;
		}
		return true;
	}

	public static boolean close(Writer writer){
		try{
			if(writer != null){
				writer.close();
			}
		}catch(Exception e){
			System.out.println("Exception: "+e.getMessage());
			e.printStackTrace();
			
			return false;
		}
		return true;
	}
	
	/**
	 * Closes the nested collection variable.
	 * 
	 * @param objCollection
	 */
	public static void clearCollectionHieracy(Object objCollection){
		try{
			if( objCollection == null ){
				
			}else if( objCollection instanceof Map ) {
				Map mapCollection = (Map)objCollection;
				Iterator it = mapCollection.keySet().iterator();
				while( it.hasNext() ){
					Object str = it.next();
					clearCollectionHieracy( mapCollection.get(str) );
				}
				mapCollection.clear();
				mapCollection = null;
			}else if( objCollection instanceof List ) {
				List listCollection = (List)objCollection;
				for( int i=0; i < listCollection.size(); i++ ){
					clearCollectionHieracy( listCollection.get(i) );
				}
				listCollection.clear();
				listCollection = null;
			}else if( objCollection instanceof StringBuilder ) {
				StringBuilder sbCollection = (StringBuilder)objCollection;
				sbCollection.setLength(0);
			}else if( objCollection instanceof StringBuffer ) {
				StringBuffer sbCollection = (StringBuffer)objCollection;
				sbCollection.setLength(0);
			}else if( objCollection instanceof Set ) {
				Set setCollection = (Set)objCollection;
				Object[] objSetCollections = setCollection.toArray();
				for( int i = 0; i < objSetCollections.length; i++ ){
					clearCollectionHieracy( objSetCollections[i] );
				}
				setCollection.clear();
				setCollection = null;
			}
			
			objCollection = null;
		}catch(Throwable t){
			System.out.println("Exception: "+t.getMessage());
			t.printStackTrace();
		}
	}
	
	/**
	 * Return 'val2' if 'val1' is null; else return 'val1' 
	 * This function should be used when db_column definition is "NOT NULL DEFAULT ''"
	 * 
	 * @param val1 
	 * @param val2 
	 * @return String
	 */
	public static String replaceNullWithQuote(Object val1, String val2) {
		if (val1 == null)
			return "'" + val2 +"'";
		else
			return "'" + val1.toString() + "'";
	}
}
