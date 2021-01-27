package com.july.mystore.dao.impl;

import java.sql.Connection;
import java.util.List;

import com.july.mystore.dao.IProductDAO;
import com.july.mystore.mapper.ProductMapper;
import com.july.mystore.model.Product;


public class ProductDAO extends AbstractDAO<Product> 
		implements IProductDAO {


	@Override
	public List<Product> findAll(Connection conn) {
		String sql = "SELECT * FROM Product";
		return query(conn, sql, new ProductMapper());
	}

	@Override
	public Product findOneByCode(Connection conn, String productCode) {
		String sql = "SELECT * FROM Product WHERE ProductSKU = ?";
		
		List<Product> products = query(conn, sql, new ProductMapper(), productCode);
		
		return products.isEmpty() ? null : products.get(0);
	}
	
	
	@Override
	public Long insertProduct(Connection conn, Product product) {
		Long id = null;
		
		StringBuilder sql = //
				new StringBuilder("INSERT INTO Product(ProductSKU, ProductName, ProductPrice, ProductStock, ProductManufacturer, ProductCategory, ProductCondition, ProductDescription, ProductSrc)");
		sql.append(" VALUES (?,?,?,?,?,?,?,?,?)");
		
		id = insert(conn, sql.toString(), 
				product.getProductSKU(), 
				product.getProductName(), 
				product.getProductPrice(),
				product.getProductStock(),
				product.getProductManufacturer(),
				product.getProductCategory(),
				product.getProductCondition(),
				product.getProductDescription(),
				product.getProductSrc());
				
		return id;
	}
	

}
