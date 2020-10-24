/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.july.myweb.dao;

import com.july.myweb.model.Product;
import com.july.myweb.utils.DatabaseUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Loi Dinh Oct 24, 2020
 * @version 1.0
 */
public class ListProductDAO {
    private String tableName = "products";
    private DatabaseUtil dbUtil = DatabaseUtil.getInstance();
    
    
    
    /**
     * Return the list of products by product name
     * 
     * @param wildCard
     * @return 
     * @throws java.sql.SQLException 
     */
    public List<Product> search(String wildCard) throws SQLException{
        List<Product> listProducts = new ArrayList<>();
        ResultSet queryResultSet;
        
        if (wildCard.isEmpty()) {
            queryResultSet = dbUtil.queryDb(tableName);
        } else {
            queryResultSet = dbUtil.queryLikeDb(tableName, "product_name", wildCard);
        }
        
        while (queryResultSet.next()) {
            int id = queryResultSet.getInt("product_id");
            String name = queryResultSet.getString("product_name");
            String description = queryResultSet.getString("product_des");
            float price = queryResultSet.getFloat("product_price");
            String src = queryResultSet.getString("product_img_source");
            String type = queryResultSet.getString("product_type");
            String brand = queryResultSet.getString("product_brand");
            
            Product newProduct = new Product(id, name, description, price, src, type, brand);
            
            listProducts.add(newProduct);
        }
        
        //
        dbUtil.closeConnection();
        
        
        
        return listProducts;
    }
    
    
    public Product getProduct(String column, String wildCard) throws SQLException {
        
        ResultSet queryResultSet = dbUtil.queryExactDb(tableName, column, wildCard);
        Product product = null;
        //
         while (queryResultSet.next()) {
            int id = queryResultSet.getInt("product_id");
            String name = queryResultSet.getString("product_name");
            String description = queryResultSet.getString("product_des");
            float price = queryResultSet.getFloat("product_price");
            String src = queryResultSet.getString("product_img_source");
            String type = queryResultSet.getString("product_type");
            String brand = queryResultSet.getString("product_brand");
            
            product = new Product(id, name, description, price, src, type, brand);
            
           
        }
        
        //
        dbUtil.closeConnection();
        
        return product;
    }
}
