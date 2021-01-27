package com.july.mystore.dao;

import java.sql.Connection;
import java.util.List;

import com.july.mystore.model.Product;

public interface IProductDAO extends GenericDAO<Product> {

	List<Product> findAll(Connection conn);

	Product findOneByCode(Connection conn, String productCode);
	
	Long insertProduct(Connection conn, Product product);
}
