package com.megacrm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.megacrm.beans.Accounts;
import com.megacrm.connect.DataBaseManager;

public class AccountsDAO {

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
	public List<Accounts> viewAllAccounts1() {
		String query = "select * from accounts";
		List<Accounts> list = new ArrayList<Accounts>();
		Accounts accounts = null;
		try {
			connection = getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				accounts = new Accounts();
				accounts.setName(rs.getString(2)); 
				list.add(accounts);
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
			
	//For displaying records
	public List<Accounts> viewAllAccounts(int offset, int noOfRecords)
	{
		String query = "select SQL_CALC_FOUND_ROWS * from accounts limit "
			 + offset + ", " + noOfRecords;
		List<Accounts> list = new ArrayList<Accounts>();
		Accounts accounts = null;
		try {
			connection = getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				accounts = new Accounts();
				accounts.setAccountid(rs.getInt(1));
				accounts.setName(rs.getString(2)); 
				accounts.setWebsite(rs.getString(3));
				accounts.setCity(rs.getString(4));
				accounts.setBoardphno(rs.getInt(5));
				accounts.setIndustry(rs.getString(6));
				accounts.setNoofemployees(rs.getInt(7));
				accounts.setBranches(rs.getInt(8));
				accounts.setRevenue(rs.getInt(9));
				list.add(accounts);
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
	
	//For getting record
	public List<Accounts> viewRecord(String accountid, String name)
	{
		String query = "select * from accounts where accountid="+accountid+"";
		List<Accounts> list = new ArrayList<Accounts>();
		Accounts accounts = null;
		try {
			connection = getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				accounts = new Accounts();
				accounts.setAccountid(rs.getInt(1));
				accounts.setName(rs.getString(2)); 
				accounts.setWebsite(rs.getString(3));
				accounts.setCity(rs.getString(4));
				accounts.setBoardphno(rs.getInt(5));
				accounts.setIndustry(rs.getString(6));
				accounts.setNoofemployees(rs.getInt(7));
				accounts.setBranches(rs.getInt(8));
				accounts.setRevenue(rs.getInt(9));
				list.add(accounts);
			}
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
	
	//for searching records
	public List<Accounts> viewSearchResults(String search)
	{
		String query = "select * from accounts where name like '%"+search+"%'";
		List<Accounts> list = new ArrayList<Accounts>();
		Accounts accounts = null;
		try {
			connection = getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				accounts = new Accounts();
				accounts.setAccountid(rs.getInt(1));
				accounts.setName(rs.getString(2)); 
				accounts.setWebsite(rs.getString(3));
				accounts.setCity(rs.getString(4));
				accounts.setBoardphno(rs.getInt(5));
				accounts.setIndustry(rs.getString(6));
				accounts.setNoofemployees(rs.getInt(7));
				accounts.setBranches(rs.getInt(8));
				accounts.setRevenue(rs.getInt(9));
				list.add(accounts);
			}
			
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
	
	public void addAccounts(Connection con, String name, String website, String city, String boardphno, String industry, String employees, String branches, String revenue) {
		Statement stmt = null;
		
		try{
			stmt = con.createStatement();
			String sql = "insert into accounts(name,website, city, boardphno, industry, employees,branches, revenue) values('"+name+"','"+website+"','"+city+"',"+boardphno+",'"+industry+"',"+employees+","+branches+","+revenue+")";
			
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
