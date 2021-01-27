package com.july.mystore.servlet;

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

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet(urlPatterns = { "/product" })
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private IProductService productService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        
        productService = new ProductService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Connection conn = AppUtils.getStoredConnection(request);
		
		List<Product> products = productService.findAll(conn);
		
		request.setAttribute("PRODUCTS", products);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/productListView.jsp");
		
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
