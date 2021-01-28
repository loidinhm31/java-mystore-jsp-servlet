package com.july.mystore.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.july.mystore.model.Cart;
import com.july.mystore.model.Product;
import com.july.mystore.service.IProductService;
import com.july.mystore.service.impl.ProductService;
import com.july.mystore.util.AppUtils;

/**
 * Servlet implementation class AddProductToCartServlet
 */
@WebServlet("/action-cart")
public class ActionOnProductInCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private IProductService productService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionOnProductInCartServlet() {
        super();
        productService = new ProductService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get session
        HttpSession session = request.getSession(true);
        String productCode = request.getParameter("product-code");
        String action = request.getParameter("action");
        
        if (action != null && action.equalsIgnoreCase("add")) {
        	// Create a new cart to add items
            if (session.getAttribute("cart") == null) {
                session.setAttribute("cart", new Cart());
            }
            
            Connection conn = AppUtils.getStoredConnection(request);
            
            // Get the current product from database
            Product currProduct = productService.findOneByCode(conn, productCode);
            
            // Get the current cart if it was created
            Cart currCart = (Cart) session.getAttribute("cart");
            
            currCart.addItem(currProduct);
        } 
        // Delete an item from the cart
        else if (action != null && action.equalsIgnoreCase("delete")) {   
            Cart currCart = (Cart) session.getAttribute("cart");
            
            currCart.removeItem(productCode);
        }
        // Clear all items in the cart
        else if (action != null && action.equalsIgnoreCase("clear")) {
        	Cart currCart = (Cart) session.getAttribute("cart");
        	
        	if (currCart != null) {
        		currCart.clearCart();
        	}
        	
        }
        
        
        // Redirect to the cart page
        response.sendRedirect(request.getContextPath() + "/cart");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		
		doGet(request, response);
	}

}
