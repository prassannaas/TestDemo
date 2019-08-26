package com.megacrm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class ConnectionFactory1 {
    //static reference to itself
    private static ConnectionFactory1 instance = 
                new ConnectionFactory1();
    String url = "jdbc:mysql://localhost/test";
    String user = "root";
    String password = "sa";
    String driverClass = "com.mysql.jdbc.Driver"; 
     
    //private constructor
    private ConnectionFactory1() {
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
     
    public static ConnectionFactory1 getInstance()   {
        return instance;
    }
     
    public Connection getConnection() throws SQLException, 
    ClassNotFoundException {
        Connection connection = 
            DriverManager.getConnection(url, user, password);
        return connection;
    }   
}
