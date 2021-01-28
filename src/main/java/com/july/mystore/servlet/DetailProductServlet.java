package com.july.mystore.servlet;

import java.io.IOException;
import java.sql.Connection;

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
 * Servlet implementation class DetailProductServlet
 */
@WebServlet("/detail-product")
public class DetailProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private IProductService productService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailProductServlet() {
        super();
        productService = new ProductService();
        		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conn = AppUtils.getStoredConnection(request);
		
		String productCode = request.getParameter("product-code");
        
        Product product = productService.findOneByCode(conn, productCode);
        
        if (product != null) {
        	request.setAttribute("PRODUCT", product);
        	
        	//
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/detailProductView.jsp");
            dispatcher.forward(request, response);
        } else {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/homeView.jsp");
            dispatcher.forward(request, response);
        }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
