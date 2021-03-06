package project.javaee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManager {
	
	private static DbManager single_instance = null; 
	private String user, pass;
	private Connection conn;
	
	 private DbManager(){
		this.user = "Dg3jCj0JRD";
		this.pass = "bHPu8tQZqy";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/Dg3jCj0JRD", user, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	 public static DbManager getInstance() 
	    { 
	        if (single_instance == null) 
	            single_instance = new DbManager(); 
	  
	        return single_instance; 
	    } 
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/Dg3jCj0JRD", user, pass);
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet getQuerryResponse(String querry) {
		Statement stmt;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(querry);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	  
		return rs;
	}
	
	public void executeUpdate(String query) {
		Statement stmt;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	  
		
	}
}
