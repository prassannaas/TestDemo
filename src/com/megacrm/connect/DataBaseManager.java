package com.megacrm.connect;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;

/**
 * Manager for the DataBase connections.
 * 
 */
public class DataBaseManager {

	/**
	 * Connection detail parameters
	 * 
	 */
	private static String driver = "";
	private static String protocal = "";
	private static String port = "";
	private static String dbHostName = "";
	private static String dbName = "";
	private static String userName = "";
	private static String password = "";
	private static int maxActive = 10;
	private static int maxWait = 500;
	private static boolean autoCommit = false;
	private static Boolean connEstb = false;

	/**
	 * Objects for functionality
	 * 
	 */
	public static Connection con;
    private static GenericObjectPool connectionPool = null;
	private static PoolingDataSource dataSource = null;

	/**
	 * Get the connection details from a property file given.
	 * 
	 * @param configfilePath
	 * @throws Exception
	 */
	public static void getDetails(String configfilePath) throws Exception{
		Properties prop = new Properties();
		InputStream is = new FileInputStream( configfilePath );
		prop.load(is);
		driver		= prop.getProperty("DRIVER");
		protocal	= prop.getProperty("PROTOCAL");
		dbHostName	= prop.getProperty("DBHOST");
		port		= prop.getProperty("LOCALLISTERNPORT");
		dbName		= prop.getProperty("DBNAME");
		userName	= prop.getProperty("DBUSERNAME");
		password	= prop.getProperty("DBPASSWORD");
		maxActive	= Integer.parseInt(prop.getProperty("MAXACTIVE"));
		maxWait		= Integer.parseInt(prop.getProperty("MAXWAIT"));
		autoCommit	= Boolean.parseBoolean(prop.getProperty("AUTOCOMMIT"));
	}
	
	/**
	 * Create a connection if no connection has been established previously.
	 * 
	 * @param configfilePath
	 * @return
	 * @throws Exception
	 */
	public static boolean doConnectionSetupIfRequired(String configfilePath) throws Exception{
		boolean b = false;
		if( !connEstb ){
			b = connect(configfilePath);
		}
		return b;
	}
	
	/**
	 * Connect the database with the properties file details.
	 * And create the Connection Pool.
	 * 
	 * This will execute only if connection is already not created.
	 * 
	 * @param configFilePath
	 * @return Connection creation status
	 * @throws Exception
	 */
    private static boolean connect(String configFilePath) throws Exception{
        try {
        	synchronized (connEstb) {
        		if( ! connEstb ) {
					// create connection pool
					connectionPool = new GenericObjectPool(null);
					connectionPool.setMaxActive(maxActive);
					connectionPool.setMaxWait(maxWait);
					
		        	getDetails(configFilePath);
					Class.forName(driver).newInstance();
		        	String dbURL = "jdbc:"+protocal+"://"+dbHostName+":"+port+"/"+dbName+"?autoReconnect=true";
					String connectURI = dbURL+"&user="+userName+"&password="+password;
					//System.out.println("connectURI: "+connectURI);
					// create Connection factory
					ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(connectURI, null);
					
					// create the PoolableConnectionFactory
					PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(
							connectionFactory, connectionPool, null, null, false, true);
					
					// set connection factory
					connectionPool.setFactory(poolableConnectionFactory);
					
					// create pool data source
					dataSource = new PoolingDataSource(connectionPool);
					
					connEstb = true;
        		}
        	}
        } catch (Exception e) {
            System.out.println("This is the Exception in conect db: "+e.getMessage());
            e.printStackTrace();
            throw e;
        }
        return true;
    }

	/**
	 * @return a connection form the Pool.
	 */
    public static Connection giveConnection() {
		Connection con = null;
		try{
			con = dataSource.getConnection();
			con.setAutoCommit(autoCommit);
			
			// gmt_differance is a connection variable now
			// it will have the MySQL server to GMT difference
			// Eg.: if MySQL server is EDT then gmt_differance will get -4:00:00
			//con.createStatement().execute("set @gmt_differance = timediff(now(),convert_tz(now(),@@session.time_zone,'+00:00'))");
		} catch (Exception e) {
			System.out.println("General exception" + e.getMessage());
			e.printStackTrace();
		}
		return con;
    }

    /**
     * Print the status of the Pool.
     *
     */
	public static void printStatus(){
		System.out.println("returning static dataSource: "+connectionPool.getNumIdle()+"<>"+connectionPool.getNumActive());
	}

	/**
	 * Close a ResultSet if it has an object in its reference
	 * 
	 * @param rst
	 * @return
	 */
	public static boolean close(ResultSet rst){
		try{
			if( rst != null )
				rst.close();
		}catch(Exception e){
			System.out.println("Exception while closing ResultSet: "+e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Close a Statement if it has an object in its reference
	 * 
	 * @param sta
	 * @return
	 */
	public static boolean close(Statement sta){
		try{
			if( sta != null )
				sta.close();
		}catch(Exception e){
			System.out.println("Exception while closing Statement: "+e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Close a Connection if it has an object in its reference
	 * 
	 * @param conn
	 * @return
	 */
	public static boolean close(Connection conn){
		try{
			if( conn != null )
				conn.close();
		}catch(Exception e){
			System.out.println("Exception while closing Connection: "+e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
    /**
     * Insert the data with given Query. Then extract the auto-generated key(primary key) from Statement and return it.
     * This does't work for PostgresSQL
     * 
     * @param con
     * @param strQuery
     * @return
     */
    public static long insertAndReturnKey(Connection con, String strQuery) throws Exception {
    	Statement stmt = null;
    	ResultSet rstPrimaryKey = null;
    	long lGeneratedKey = -1l;
    	
    	try{
    		stmt = con.createStatement();
			stmt.execute(strQuery, Statement.RETURN_GENERATED_KEYS);
			
			//condition to check resultset containing values or not
			rstPrimaryKey = stmt.getGeneratedKeys();
			while( rstPrimaryKey.next() ){
				lGeneratedKey = rstPrimaryKey.getLong("GENERATED_KEY");
			}
    	} catch(Exception e){
    		throw e;
    	} finally {
    		close(rstPrimaryKey);
    		rstPrimaryKey = null;
    		close(stmt);
    		stmt = null;
    	}
    	
    	return lGeneratedKey;
    }
    
    public static long insertAndReturnKey(Connection con, String strQuery, String strPrimaryKey) throws Exception {
    	Statement stmt = null;
    	ResultSet rstPrimaryKey = null;
    	long lGeneratedKey = -1l;
    	
    	try{
    		stmt = con.createStatement();
			stmt.execute(strQuery, Statement.RETURN_GENERATED_KEYS);
			
			//condition to check resultset containing values or not
			rstPrimaryKey = stmt.getGeneratedKeys();
			while( rstPrimaryKey.next() ){
				lGeneratedKey = rstPrimaryKey.getLong(strPrimaryKey);
			}
    	} catch(Exception e){
    		throw e;
    	} finally {
    		close(rstPrimaryKey);
    		rstPrimaryKey = null;
    		close(stmt);
    		stmt = null;
    	}
    	
    	return lGeneratedKey;
    }
    
    public static long insertAndReturnKey(Statement stmt, String strQuery) throws Exception {
    	long lGeneratedKey = -1l;
    	
    	try{
    		stmt.execute(strQuery, Statement.RETURN_GENERATED_KEYS);
	
			//condition to check resultset containing values or not
			ResultSet rstPrimaryKey = stmt.getGeneratedKeys();
			while( rstPrimaryKey.next() ){
				lGeneratedKey = rstPrimaryKey.getLong("GENERATED_KEY");
			}
    	} catch(Exception e){
    		throw e;
    	}
    	
    	return lGeneratedKey;
    }
    
    /**
     * Returns last insert key 
     * 
     * @param stmt
     * @return
     * @throws Exception
     */
    public static long returnKey(Statement stmt) throws Exception {
    	long lGeneratedKey = -1l;
    	
    	try{
    		//stmt.execute(strQuery, Statement.RETURN_GENERATED_KEYS);
	
			//condition to check resultset containing values or not
			ResultSet rstPrimaryKey = stmt.getGeneratedKeys();
			while( rstPrimaryKey.next() ){
				lGeneratedKey = rstPrimaryKey.getLong("GENERATED_KEY");
			}
    	} catch(Exception e){
    		throw e;
    	}
    	
    	return lGeneratedKey;
    }
    
    /**
     * Returns last inserted key 
     * 
     * @param pstmt
     * @return
     * @throws Exception
     */
    public static long returnKey(PreparedStatement pstmt) throws Exception {
    	long lGeneratedKey = -1l;
    	
    	try{
    		//stmt.execute(strQuery, Statement.RETURN_GENERATED_KEYS);
	
			//condition to check resultset containing values or not
			ResultSet rstPrimaryKey = pstmt.getGeneratedKeys();
			while( rstPrimaryKey.next() ){
				lGeneratedKey = rstPrimaryKey.getLong("GENERATED_KEY");
			}
    	} catch(Exception e){
    		throw e;
    	}
    	
    	return lGeneratedKey;
    }

    /**
     * Insert the data with given Query. Then extract the auto-generated key(primary key) from Statement and return it.
     *  
     * @param con
     * @param strQuery
     * @return
     */
    public static long insertAndReturnKey(PreparedStatement psAgentResponse, String strAutoIncreamentColumnName) throws Exception {
    	ResultSet rstPrimaryKey = null;
    	long lGeneratedKey = -1l;
    	
    	try{
    		psAgentResponse.executeUpdate();
			
			//condition to check resultset containing values or not
			rstPrimaryKey = psAgentResponse.getGeneratedKeys();
			
			while( rstPrimaryKey.next() ){
				lGeneratedKey = rstPrimaryKey.getLong(strAutoIncreamentColumnName);
			}
    	} catch(Exception e){
    		throw e;
    	} finally {
    		close(rstPrimaryKey);
    		rstPrimaryKey = null;
    	}
    	
    	return lGeneratedKey;
    }
}