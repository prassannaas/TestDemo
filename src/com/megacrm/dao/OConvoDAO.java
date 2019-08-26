package com.megacrm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.megacrm.beans.Convo;
import com.megacrm.beans.OConvo;
import com.megacrm.connect.DataBaseManager;

public class OConvoDAO {

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
	public List<OConvo> viewAllConvos(String opportunityid)
	{
		String query = "select * from oconvos where opportunityid="+opportunityid;
		List<OConvo> list = new ArrayList<OConvo>();
		OConvo oconvo = null;
		try {
			connection = getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			System.out.println(query);
			while (rs.next()) {
				oconvo = new OConvo();
				oconvo.setOpportunityid(rs.getInt(1));
				oconvo.setSubject(rs.getString(2));
				oconvo.setDatetime(rs.getTimestamp(3));
				oconvo.setConvo(rs.getString(4));
				oconvo.setDetails(rs.getString(5));
				list.add(oconvo);
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
}
