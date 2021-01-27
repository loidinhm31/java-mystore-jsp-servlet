package com.july.mystore.service.impl;

import java.sql.Connection;
import java.util.List;

import com.july.mystore.dao.IProductDAO;
import com.july.mystore.dao.impl.ProductDAO;
import com.july.mystore.model.Product;
import com.july.mystore.service.IProductService;

public class ProductService implements IProductService {
	
	private IProductDAO productDAO;
	
	public ProductService() {
		productDAO = new ProductDAO();
	}
	

	@Override
	public List<Product> findAll(Connection conn) {
		
		return productDAO.findAll(conn);
	}


	@Override
	public Product findOneByCode(Connection conn, String productCode) {
		
		return productDAO.findOneByCode(conn, productCode);
	}


	@Override
	public Long insertProduct(Connection conn, Product product) {
		Long id = productDAO.insertProduct(conn, product);
		return id;
	}

}
