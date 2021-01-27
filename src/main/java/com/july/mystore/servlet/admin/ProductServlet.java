package com.july.mystore.servlet.admin;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.july.mystore.model.Product;
import com.july.mystore.service.IProductService;
import com.july.mystore.service.impl.ProductService;
import com.july.mystore.util.AppUtils;

@WebServlet(urlPatterns = {"/admin/product"})
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IProductService productService;

	public ProductServlet() {
		productService = new ProductService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = AppUtils.getStoredConnection(req);

		List<Product> products = productService.findAll(conn);

		req.setAttribute("PRODUCTS", products);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/admin/adminProductView.jsp");

		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
