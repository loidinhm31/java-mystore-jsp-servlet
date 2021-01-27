package com.july.mystore.connection;

import java.sql.Connection;
import java.sql.SQLException;



public class ConnectionUtils {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		// Here I using Oracle Database.
		// (You can change to use another database.)

		return MySQLConn.getMySQLConnection();

	}

	public static void closeQuietly(Connection conn) {
		try {
			conn.close();
			System.out.println("conn closed: " + conn.isClosed());
		} catch (Exception e) {
		}
	}

	public static void rollbackQuietly(Connection conn) {
		try {
			conn.rollback();
		} catch (Exception e) {
		}
	}
}
