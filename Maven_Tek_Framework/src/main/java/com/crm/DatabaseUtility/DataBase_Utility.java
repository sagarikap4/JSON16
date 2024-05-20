package com.crm.DatabaseUtility;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBase_Utility {
	Connection conn;
	public void getConnection(String url,String username, String password) throws Throwable {
		try{
			Driver d = new Driver();
		DriverManager.registerDriver(d);
		conn=DriverManager.getConnection(url, username, password);
		}catch(Exception e) {}
		}
	public void getConnection() throws Throwable {
		try{
			Driver d = new Driver();
		DriverManager.registerDriver(d);
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root@%", "root");
		}catch(Exception e) {}
	}
	public void closeConnection() throws SQLException {
		try{
			conn.close();
		  }catch(Exception e) {}
		}
	public ResultSet executeSelectQuery(String query) {
		ResultSet result=null;
		try {
			Statement stat = conn.createStatement();
			result=stat.executeQuery(query);
		}catch(Exception e) {}
		return result;
	  }
	public int executeSelectupdateQuery(String query) {
		int result=0;
		try {
			Statement stat = conn.createStatement();
			result=stat.executeUpdate(query);
		}catch(Exception e) {}
		return result;
	  }
	}

