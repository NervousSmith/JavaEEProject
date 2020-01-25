package project.javaee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManager {

	private String user, pass;
	Connection conn;
	DbManager(String user, String pass){
		this.user = user;
		this.pass = pass;
	}
	
	DbManager(){
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
