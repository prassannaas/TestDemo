package com.megacrm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.megacrm.beans.ContactBean;
import com.megacrm.connect.DataBaseManager;

public class ContactsDAO {

	Connection connection;
	Statement stmt;
	private int noOfRecords;
	public ContactsDAO(){}
	
	private static Connection getConnection() 
			throws SQLException, 
				ClassNotFoundException 
	{
		Connection con = DataBaseManager.giveConnection();
		
		return con;
	}
	
	public List<ContactBean> viewAllContacts(int offset, int noOfRecords)
	{
		String query = "select SQL_CALC_FOUND_ROWS * from contacts limit "
			 + offset + ", " + noOfRecords;
		List<ContactBean> list = new ArrayList<ContactBean>();
		ContactBean contacts = null;
		try {
			connection = getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			System.out.println(query);
			while (rs.next()) {
				contacts = new ContactBean();
				contacts.setContactid(rs.getInt(1));
				contacts.setFirstname(rs.getString(2)); 
				contacts.setLastname(rs.getString(3));
				contacts.setDesignation(rs.getString(4));
				contacts.setEmail(rs.getString(5));
				contacts.setCity(rs.getString(6));
				contacts.setCompany(rs.getString(7));
				contacts.setPhoneno(rs.getInt(8));
				list.add(contacts);
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
		public List<ContactBean> viewRecord(String contactid)
		{
			String query = "select * from contacts where contactid="+contactid+"";
			List<ContactBean> list = new ArrayList<ContactBean>();
			ContactBean contacts = null;
			try {
				connection = getConnection();
				stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				System.out.println(query);
				while (rs.next()) {
					contacts = new ContactBean();
					contacts.setContactid(rs.getInt(1));
					contacts.setFirstname(rs.getString(2)); 
					contacts.setLastname(rs.getString(3));
					contacts.setDesignation(rs.getString(4));
					contacts.setEmail(rs.getString(5));
					contacts.setCity(rs.getString(6));
					contacts.setCompany(rs.getString(7));
					contacts.setPhoneno(rs.getInt(8));
					list.add(contacts);
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
		
	
	//searching query
	public List<ContactBean> viewSearchResults(String search)
	{
		String query = "select * from contacts where firstname like '%"+search+"%'";
		List<ContactBean> list = new ArrayList<ContactBean>();
		ContactBean contacts = null;
		try {
			connection = getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			System.out.println(query);
			while (rs.next()) {
				contacts = new ContactBean();
				contacts.setContactid(rs.getInt(1));
				contacts.setFirstname(rs.getString(2)); 
				contacts.setLastname(rs.getString(3));
				contacts.setDesignation(rs.getString(4));
				contacts.setEmail(rs.getString(5));
				contacts.setCity(rs.getString(6));
				contacts.setCompany(rs.getString(7));
				contacts.setPhoneno(rs.getInt(8));
				list.add(contacts);
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

	public void addContacts(Connection con, String firstname, String lastname, String designation, String email, String city, String company, String phone) {
		Statement stmt = null;
		
		try{
			stmt = con.createStatement();
			String sql = "insert into contacts(firstname, lastname, designation,email,city, company,phoneno) values('"+firstname+"','"+lastname+"','"+designation+"','"+email+"','"+city+"','"+company+"',"+phone+")";
			
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
