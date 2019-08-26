package com.megacrm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.megacrm.beans.Convo;
import com.megacrm.connect.DataBaseManager;

public class ConvoDAO {

	Connection connection;
	Statement stmt;
	private int noOfRecords;
	
	
	private static Connection getConnection() 
			throws SQLException, 
				ClassNotFoundException 
	{
		Connection con = DataBaseManager.giveConnection();
		
		return con;
	}
	public List<Convo> viewAllAccounts(int offset, int noOfRecords)
	{
		String query = "select SQL_CALC_FOUND_ROWS * from convo limit "
			 + offset + ", " + noOfRecords;
		List<Convo> list = new ArrayList<Convo>();
		Convo convo = null;
		try {
			connection = getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			System.out.println(query);
			while (rs.next()) {
				convo = new Convo();
				convo.setDatetime(rs.getTimestamp(1));
				convo.setConvo(rs.getString(2));
				convo.setDetails(rs.getString(3));
				list.add(convo);
			}
			rs.close();
			
			rs = stmt.executeQuery("SELECT FOUND_ROWS()");
			if(rs.next())
				this.noOfRecords = rs.getInt(1);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				if(stmt != null)
					stmt.close();
				if(connection != null)
					connection.close();
				} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public List<Convo> viewAllConvos(String contactid)
	{
		String query = "select * from convos where contactid="+contactid;
		List<Convo> list = new ArrayList<Convo>();
		Convo convo = null;
		try {
			connection = getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			System.out.println(query);
			while (rs.next()) {
				convo = new Convo();
				convo.setContactid(rs.getInt(1));
				convo.setFirstname(rs.getString(2));
				convo.setDatetime(rs.getTimestamp(3));
				convo.setConvo(rs.getString(4));
				convo.setDetails(rs.getString(5));
				list.add(convo);
			}
			rs.close();
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				if(stmt != null)
					stmt.close();
				if(connection != null)
					connection.close();
				} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public int getNoOfRecords() {
		return noOfRecords;
	}
}
