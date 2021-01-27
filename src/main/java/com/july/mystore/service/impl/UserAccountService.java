package com.july.mystore.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.july.mystore.dao.IUserAccountDAO;
import com.july.mystore.dao.impl.UserAccountDAO;
import com.july.mystore.model.UserAccount;
import com.july.mystore.service.IUserAccountService;

public class UserAccountService implements IUserAccountService {
	
	private IUserAccountDAO userAccountDAO;
	
	public UserAccountService() {
		userAccountDAO = new UserAccountDAO();
	}
	
	@Override
	public UserAccount findUser(Connection conn, String userEmail) throws SQLException {
		return userAccountDAO.findUser(conn, userEmail);
	}
	
	
	@Override
	public UserAccount findByUserEmailAndPassword(Connection conn, String userEmail, String password) 
			throws SQLException {
		
		return userAccountDAO.findUserByUserEmailAndPassword(conn, userEmail, password);
	}

	

}
