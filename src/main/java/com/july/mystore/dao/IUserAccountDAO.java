package com.july.mystore.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.july.mystore.model.UserAccount;

public interface IUserAccountDAO extends GenericDAO<UserAccount> {
	
	UserAccount findUser(Connection conn, String userName);
	
	UserAccount findUserByUserEmailAndPassword(Connection conn, String userEmail, String password)
		throws SQLException;

	
}
