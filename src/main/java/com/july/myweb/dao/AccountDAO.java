/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.july.myweb.dao;

import com.july.myweb.utils.DatabaseUtil;
import com.july.myweb.beans.Account;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Loi Dinh Oct 25, 2020
 * @version 1.0
 */
public class AccountDAO {
    private String tableName = "account";
    private DatabaseUtil dbUtil = DatabaseUtil.getInstance();
    
    public Account getAccount(List<String> columns, List<String> wildCards) throws SQLException{
        ResultSet queryResultSet;
        Account newAccount = null;
        queryResultSet = dbUtil.queryExactDb(tableName, columns, wildCards);
        
        while (queryResultSet.next()) {
            String userId = queryResultSet.getString("user_mail");
            String password = queryResultSet.getString("password");
            int role = queryResultSet.getInt("account_role");
            String userName = queryResultSet.getString("user_name");
            String userAddress = queryResultSet.getString("user_address");
            String userPhone = queryResultSet.getString("user_phone");
            
            newAccount = new Account(userId, password, role, userName, userAddress, userPhone);

        }
        
        //
        dbUtil.closeConnection();

        return newAccount;
    }
    
    public void createAccount() throws SQLException {
        
    }
}
