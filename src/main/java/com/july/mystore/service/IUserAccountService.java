package com.july.mystore.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.july.mystore.model.UserAccount;

public interface IUserAccountService {
	
	UserAccount findUser(Connection conn, String userEmail) throws SQLException;
	
	UserAccount findByUserEmailAndPassword(Connection conn, String userEmail, String password)
			throws SQLException;

	
}
