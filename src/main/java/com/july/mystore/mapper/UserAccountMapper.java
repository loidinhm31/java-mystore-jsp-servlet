package com.july.mystore.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.july.mystore.model.UserAccount;

public class UserAccountMapper implements IRowMapper<UserAccount> {

	@Override
	public UserAccount mapRow(ResultSet resultSet) {
		
		
		try {
			UserAccount user = new UserAccount();
			
			user.setUserEmail(resultSet.getString("UserEmail"));
			user.setUserName(resultSet.getString("UserName"));
			user.setUserPassword(resultSet.getString("UserPassword"));
			user.setUserRole(resultSet.getInt("UserRole"));
			
			
			return user;
			
			
		} catch (SQLException e) {
			return null;
		}	

	}

}
