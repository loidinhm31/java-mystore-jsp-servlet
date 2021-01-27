package com.july.mystore.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.july.mystore.model.Product;

public class ProductMapper implements IRowMapper<Product> {

	@Override
	public Product mapRow(ResultSet resultSet) {
		
		try {
			Product product = new Product();
			product.setProductID(resultSet.getLong("ProductID"));
			product.setProductSKU(resultSet.getString("ProductSKU"));
			product.setProductName(resultSet.getString("ProductName"));
			product.setProductPrice(resultSet.getFloat("ProductPrice"));
			product.setProductStock(resultSet.getInt("ProductStock"));
			product.setProductCategory(resultSet.getString("ProductCategory"));
			product.setProductManufacturer(resultSet.getString("ProductManufacturer"));
			product.setProductCondition(resultSet.getInt("ProductCondition"));
			product.setProductDescription(resultSet.getString("ProductDescription"));
			product.setProductSrc(resultSet.getString("ProductSrc"));
			
			
			return product;
			
			
		} catch (SQLException e) {
			return null;
		}	
		
	
	}

}
