package com.july.mystore.servlet.admin;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.july.mystore.model.Product;
import com.july.mystore.service.IProductService;
import com.july.mystore.service.impl.ProductService;
import com.july.mystore.util.AppUtils;

@WebServlet(urlPatterns = { "/admin/create-product" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 50, // 50MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class CreateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IProductService productService;

	public CreateProductServlet() {
		productService = new ProductService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/admin/createProductView.jsp");
		
		dispatcher.forward(request, response);
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = AppUtils.getStoredConnection(request);
		

		// Get parameter from form
		String name = (String) request.getParameter("ProductName");
		String code = (String) request.getParameter("SKU");
		String price = (String) request.getParameter("Price");
		String quantity = (String) request.getParameter("Quantity");
		String description = (String) request.getParameter("Description");
		String manufacturer = (String) request.getParameter("Manufacturer");
		String category = (String) request.getParameter("Category");
		String option = (String) request.getParameter("Option");

		String dir = getServletContext().getRealPath("") + File.separator + "resources" + File.separator + "product";

		Part part = request.getPart("ProductImage");

		String fileName = extractFileName(part);
		
		// Refine the fileName in case it is an absolute path
		fileName = new File(fileName).getName();
		part.write(dir + File.separator + fileName);
		String src = fileName;
		
		
		
		Product product = new Product();
		product.setProductSKU(code);
		product.setProductName(name);
		product.setProductPrice(Float.parseFloat(price));
		product.setProductStock(Integer.parseInt(quantity));
		product.setProductManufacturer(manufacturer);
		product.setProductCategory(category);
		product.setProductDescription(description);
		product.setProductCondition(Integer.parseInt(option));
		product.setProductSrc(src);
		
		
		Long id = productService.insertProduct(conn, product);
		
	
		
		if (id != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/view/admin/adminHomeView.jsp");
			dispatcher.forward(request, response);
		}
			

	}

	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}

}
