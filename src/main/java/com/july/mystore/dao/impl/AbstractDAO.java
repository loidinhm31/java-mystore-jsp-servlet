package com.july.mystore.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.july.mystore.dao.GenericDAO;
import com.july.mystore.mapper.IRowMapper;
import com.july.mystore.util.DBUtils;

public class AbstractDAO<T> implements GenericDAO<T> {	
	private DBUtils dbUtils;
	
	
	public AbstractDAO() {
		dbUtils = new DBUtils();
	}
	
	@Override
	public List<T> query(Connection conn, String sql, IRowMapper<T> rowMapper, Object... parameters) {
		
		List<T> results = new ArrayList<>();
		
		ResultSet resultSet = null;
		
		try {
			resultSet = dbUtils.query(conn, sql, parameters);
			
			while (resultSet.next()) {
				results.add(rowMapper.mapRow(resultSet));
			}
			
			return results;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			dbUtils.closeConnection();
		}
				

	}

	@Override
	public void update(Connection conn, String sql, Object... parameters) {
		try {
			dbUtils.update(conn, sql, parameters);
		} finally {
			dbUtils.closeConnection();
		}
		
		
	}

	@Override
	public Long insert(Connection conn, String sql, Object... parameters) {
		
		Long id = null;
		try {
			id = dbUtils.insert(conn, sql, parameters);
			
			return id;
		} finally {
			dbUtils.closeConnection();
		}
		
	}

	@Override
	public int count(String sql, Object... parameters) {
		
		return 0;
	}
	
}
