package com.july.mystore.service;

import java.sql.Connection;
import java.util.List;

import com.july.mystore.model.Product;

public interface IProductService {
	
	List<Product> findAll(Connection conn);

	Product findOneByCode(Connection conn, String productCode);
	
	Long insertProduct(Connection conn, Product product);

}
