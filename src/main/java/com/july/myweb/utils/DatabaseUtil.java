/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.july.myweb.utils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Loi Dinh Oct 20, 2020
 * @version 1.0
 */
public class DatabaseUtil {
    private static DatabaseUtil instance;
    private String dbName = "shopping_db";
    private DataSource dataSource;
    // Get a connection to db
    private Connection conn;
    private PreparedStatement sqlStatement;
    private ResultSet queryResultSet;
    
    
    
    private DatabaseUtil() {
        try {
		InitialContext initContext = new InitialContext();

                Context env = (Context) initContext.lookup("java:comp/env");

		dataSource = (DataSource) env.lookup("jdbc/" + dbName);

	} catch (NamingException e) {
            e.printStackTrace();
	}
    }
    
    public static DatabaseUtil getInstance() {
        if (instance == null) {
            instance = new DatabaseUtil();
        }
        
        return instance;
    }
    
    
    public ResultSet queryDb(String table) throws SQLException {
        
        
        // Create a SQL statement and query
        conn = dataSource.getConnection();
        // Create a SQL statement
        String sql = "SELECT * FROM " + table;
        sqlStatement = conn.prepareStatement(sql);

        // Execute query
        queryResultSet = sqlStatement.executeQuery();
           
            
       return queryResultSet;
    }
    
    public ResultSet queryExactDb(String table, String column, String wildCard) throws SQLException {
        
        // Create a SQL statement and query
        conn = dataSource.getConnection();
        // Create a SQL statement
        String sql = "SELECT * FROM " + table + " WHERE " + column + "=?";
        sqlStatement = conn.prepareStatement(sql);
        sqlStatement.setString(1, wildCard);

        // Execute query
        queryResultSet = sqlStatement.executeQuery();
           
            
       return queryResultSet;
    }
    
    public ResultSet queryExactDb(String table, List<String> columns, List<String> wildCards) throws SQLException {
        
        // Create a SQL statement and query
        conn = dataSource.getConnection();
        // Create a SQL statement
        String sql = "SELECT * FROM " + table + " WHERE ";
        
        // Extend for multi fields
        for (int i = 1; i <= columns.size(); i++) {
            if (i == columns.size()) {
                sql += columns.get(i-1) + "=?";
            } else {
                sql += columns.get(i-1) + "=? AND ";
            }
        }
        
        // Set wild card
        sqlStatement = conn.prepareStatement(sql);
        for (int i = 1; i <= wildCards.size(); i++) {
            sqlStatement.setString(i, wildCards.get(i-1));
        }
        

        // Execute query
        queryResultSet = sqlStatement.executeQuery();
           
            
       return queryResultSet;
    }
    
    
    public ResultSet queryLikeDb(String table, String column, String wildCard) throws SQLException {
        
        
        // Create a SQL statement and query
        conn = dataSource.getConnection();
        // Create a SQL statement
        String sql = "SELECT * FROM " + table + " WHERE " + column + " LIKE?";
        sqlStatement = conn.prepareStatement(sql);
        sqlStatement.setString(1, "%" + wildCard + "%");

        // Execute query
        queryResultSet = sqlStatement.executeQuery();
            
            
       return queryResultSet;
    }
    
    public ResultSet queryLikeDb(String table, List<String> columns, List<String> wildCards) throws SQLException {
        
        
        // Create a SQL statement and query
        conn = dataSource.getConnection();
        // Create a SQL statement
        String sql = "SELECT * FROM " + table + " WHERE ";
        
        // Extend for multi fields
        for (int i = 1; i <= columns.size(); i++) {
            if (i == columns.size()) {
                sql += columns.get(i-1) + " LIKE?";
            } else {
                sql += columns.get(i-1) + " LIKE? OR ";
            }
        }
        
        // Set wild card
        sqlStatement = conn.prepareStatement(sql);
        for (int i = 1; i <= wildCards.size(); i++) {
            sqlStatement.setString(i, "%" + wildCards.get(i-1) + "%");
        }
        

        // Execute query
        queryResultSet = sqlStatement.executeQuery();
            
            
       return queryResultSet;
    }
    
    
    public long insertDb(String table, List<String> columns, List<String> values) throws SQLException{
        conn = dataSource.getConnection();
        String sql = "INSERT INTO " + table + " ("  ;
        
        for (int i = 1; i <= columns.size(); i++) {
            if (i == columns.size()) {
                sql += columns.get(i-1) + ") ";
            } else {
                sql += columns.get(i-1) + ", ";
            }
        }
        
        sql += " VALUES (";
        
        for (int i = 1; i <= values.size(); i++) {
            if (i == values.size()) {
                sql += "?" + ") ";
            } else {
                sql += "?" + ", ";
            }
        }
        
        sqlStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        for (int i = 1; i <= values.size(); i++) {
            sqlStatement.setString(i, values.get(i-1));           
        }
        
        sqlStatement.executeUpdate();
        
        
        // Get the ID was created
        long id = -1L;
        queryResultSet = sqlStatement.getGeneratedKeys();
        if (queryResultSet.next()) {
            id = queryResultSet.getLong(1);
        }
        
        return id;
    }
    

    public void closeConnection() {
            
        try {
                if (queryResultSet != null) {
                        queryResultSet.close();
                }

                if (sqlStatement != null) {
                        sqlStatement.close();
                }

                if (conn != null) {
                        conn.close();   // doesn't really close it ... just puts back in connection pool
                }
        }
        catch (Exception exc) {
                exc.printStackTrace();
        }
    }
    
}
