package com.leanhtuan.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	/*
	 * public static Connection getJDBCConnection() { Connection connection = null;
	 * try { Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); String
	 * user = "leanhtuan"; String pass = "654321"; String url =
	 * "jdbc:sqlserver://localhost:1433;integratedSecurity=true;databaseName=UNIFY";
	 * connection = DriverManager.getConnection(url, user, pass);
	 * System.out.println("thanh cong");
	 * 
	 * } catch ( SQLException | ClassNotFoundException ex) { ex.printStackTrace(); }
	 * 
	 * return connection; }
	 * 
	 */
	
//	private static JDBCConnection instance;
//	private Connection connection;

	public static Connection getJDBCConnection() {
		String hostName = "localhost";
		String sqlInstanceName = "SQLEXPRESS";
		String database = "UNIFY";
		String connectionURL = "jdbc:sqlserver://" + hostName + ":1433" + ";instance=" + sqlInstanceName
				+ ";databaseName=" + database;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(connectionURL, "leanhtuan", "654321");
			return conn;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

//	public static JDBCConnection getInstance() throws SQLException {
//		if (instance == null || instance.getJDBCConnection().isClosed()) {
//			instance = new JDBCConnection();
//		}
//		return instance;
//	}
}
