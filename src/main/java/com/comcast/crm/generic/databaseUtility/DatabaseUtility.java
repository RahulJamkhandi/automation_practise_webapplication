package com.comcast.crm.generic.databaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtility {
	Connection connection;

	public void getConnection(String url, String un, String pwd) {
		try {
			connection = DriverManager.getConnection(url, un, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			DriverManager.getConnection("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ResultSet excuteSelectStatement(String query) {
		ResultSet rs =  null;
		try {
			Statement statement = connection.createStatement();
			rs = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public int executeNonSelectStatement(String query) {
		int result = 0;
		try {
			Statement statement = connection.createStatement();
			result = statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
