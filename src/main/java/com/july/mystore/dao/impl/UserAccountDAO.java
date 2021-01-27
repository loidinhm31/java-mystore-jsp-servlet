package com.july.mystore.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.july.mystore.dao.IUserAccountDAO;
import com.july.mystore.mapper.UserAccountMapper;
import com.july.mystore.model.UserAccount;

public class UserAccountDAO extends AbstractDAO<UserAccount> 
		implements IUserAccountDAO {
	
	
	@Override
	public UserAccount findUser(Connection conn, String userEmail) {
		StringBuilder sql = new StringBuilder("SELECT * FROM UserAccount");
		sql.append(" WHERE UserEmail = ?");
		
		List<UserAccount> users = query(conn, sql.toString(), new UserAccountMapper(), 
				userEmail);
		
		return users.isEmpty() ? null : users.get(0);
	}
	

	@Override
	public UserAccount findUserByUserEmailAndPassword(Connection conn, String userEmail, String password) throws SQLException {
		String sql = "SELECT * FROM UserAccount WHERE UserEmail = ? AND UserPassword = ?";		
		
		List<UserAccount> users = query(conn, sql, new UserAccountMapper(), 
									userEmail, password);
		
		return users.isEmpty() ? null : users.get(0);

	}

	
	
	
	
}
