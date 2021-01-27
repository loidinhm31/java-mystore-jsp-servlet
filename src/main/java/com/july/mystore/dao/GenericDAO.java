package com.july.mystore.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.july.mystore.mapper.IRowMapper;



public interface GenericDAO<T> {
	List<T> query(Connection conn, String sql, IRowMapper<T> rowMapper, Object... parameters) 
			throws SQLException;
	
	void update (Connection conn, String sql, Object... parameters);
	
	Long insert (Connection conn,String sql, Object... parameters);
	
	int count(String sql, Object... parameters);
}
