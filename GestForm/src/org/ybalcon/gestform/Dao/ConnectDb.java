package org.ybalcon.gestform.Dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectDb {
	private static Connection cn = null;
	static String url = "jdbc:mysql://localhost/java";

	public static Connection getConnection() {
		String login = "root";
		String passwd = "admin";
		if (cn == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				cn = (Connection) DriverManager.getConnection(url, login,
						passwd);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return cn;
	}
}
