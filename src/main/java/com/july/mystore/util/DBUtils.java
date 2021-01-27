package com.july.mystore.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class DBUtils {
	private PreparedStatement sqlStatement;
	private ResultSet resultSet;

	public ResultSet query(Connection conn, String sqlQuery, Object... parameters) {

		try {

			sqlStatement = conn.prepareStatement(sqlQuery);

			setParameter(sqlStatement, parameters);

			// Execute query
			resultSet = sqlStatement.executeQuery();

			return resultSet;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public void update(Connection conn, String sql, Object... parameters) {

		PreparedStatement sqlStatement = null;

		try {
			conn.setAutoCommit(false);

			sqlStatement = conn.prepareStatement(sql);

			setParameter(sqlStatement, parameters);

			sqlStatement.executeUpdate();

			conn.commit();
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {

				if (sqlStatement != null) {
					sqlStatement.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	public Long insert(Connection conn, String sql, Object... params) {

		PreparedStatement sqlStatement = null;
		ResultSet resultSet = null;

		try {
			Long id = null;
			conn.setAutoCommit(false);
			sqlStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			setParameter(sqlStatement, params);

			sqlStatement.executeUpdate();

			resultSet = sqlStatement.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getLong(1);
			}

			conn.commit();

			return id;

		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {

				if (sqlStatement != null) {
					sqlStatement.close();
				}

				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

		return null;
	}

	private void setParameter(PreparedStatement statement, Object... parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				int index = i + 1;
				if (parameter instanceof Long) {

					statement.setLong(index, (Long) parameter);

				} else if (parameter instanceof String) {

					statement.setString(index, (String) parameter);
				} else if (parameter instanceof Float) {

					statement.setFloat(index, (Float) parameter);
				} else if (parameter instanceof Integer) {

					statement.setInt(index, (Integer) parameter);
				} else if (parameter instanceof Timestamp) {

					statement.setTimestamp(index, (Timestamp) parameter);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeConnection() {

		try {
			if (resultSet != null) {
				resultSet.close();
				System.out.println("result closed: " + resultSet.isClosed());
			}

			if (sqlStatement != null) {
				sqlStatement.close();
				System.out.println("statement closed: " + sqlStatement.isClosed());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
