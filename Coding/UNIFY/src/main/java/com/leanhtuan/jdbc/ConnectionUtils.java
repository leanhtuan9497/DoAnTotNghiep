package com.leanhtuan.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	public static Connection getConnection() {
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
}
