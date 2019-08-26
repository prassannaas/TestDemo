package com.megacrm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.megacrm.beans.Opportunities;
import com.megacrm.connect.DataBaseManager;

public class OpportunitiesDAO {

	Connection connection;
	Statement stmt;
	private int noOfRecords;
	public OpportunitiesDAO(){}
	
	private static Connection getConnection() 
			throws SQLException, 
				ClassNotFoundException 
	{
		Connection con = DataBaseManager.giveConnection();
		
		return con;
	}

	//For displaying records
	public List<Opportunities> viewAllOpportunities(int offset, int noOfRecords)
	{
		String query = "select SQL_CALC_FOUND_ROWS * from opportunities limit "
			 + offset + ", " + noOfRecords;
		List<Opportunities> list = new ArrayList<Opportunities>();
		Opportunities opportunities = null;
		try {
			connection = getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				opportunities = new Opportunities();
				opportunities.setOpportunityid(rs.getInt(1)); 
				opportunities.setSubject(rs.getString(2)); 
				opportunities.setAccount(rs.getString(3));
				opportunities.setType(rs.getString(4));
				opportunities.setStatus(rs.getString(5));
				opportunities.setProbability(rs.getInt(6));
				opportunities.setNotes(rs.getString(7));
				list.add(opportunities);
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
	//for Getting record
	public List<Opportunities> viewRecord(String opportunityid)
	{
		String query = "select * from opportunities where opportunityid="+opportunityid;
		List<Opportunities> list = new ArrayList<Opportunities>();
		Opportunities opportunities = null;
		try {
			connection = getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				opportunities = new Opportunities();
				opportunities.setOpportunityid(rs.getInt(1)); 
				opportunities.setSubject(rs.getString(2)); 
				opportunities.setAccount(rs.getString(3));
				opportunities.setType(rs.getString(4));
				opportunities.setStatus(rs.getString(5));
				opportunities.setProbability(rs.getInt(6));
				opportunities.setNotes(rs.getString(7));
				list.add(opportunities);
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
	//For Search records
	public List<Opportunities> viewSearchResults(String search)
	{
		String query = "select * from opportunities where subject like '%"+search+"%'";
		List<Opportunities> list = new ArrayList<Opportunities>();
		Opportunities opportunities = null;
		try {
			connection = getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				opportunities = new Opportunities();
				opportunities.setOpportunityid(rs.getInt(1));
				opportunities.setSubject(rs.getString(2)); 
				opportunities.setAccount(rs.getString(3));
				opportunities.setType(rs.getString(4));
				opportunities.setStatus(rs.getString(5));
				opportunities.setProbability(rs.getInt(6));
				opportunities.setNotes(rs.getString(7));
				list.add(opportunities);
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
	
	public void addOpportunities(Connection con, String subject, String account, String type, String status, String probability, String notes) {
		Statement stmt = null;
		
		try{
			stmt = con.createStatement();
			String sql = "insert into opportunities(subject, account, type, status,probability, notes) values('"+subject+"','"+account+"','"+type+"','"+status+"',"+probability+",'"+notes+"')";
			stmt.execute(sql);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseManager.close(stmt);
			stmt = null;
		}
	}
	
	public int getNoOfRecords() {
		return noOfRecords;
	}
}
