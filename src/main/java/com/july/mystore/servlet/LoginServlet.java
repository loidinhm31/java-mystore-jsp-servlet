package com.july.mystore.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.july.mystore.model.EnumConstant;
import com.july.mystore.model.UserAccount;
import com.july.mystore.service.IUserAccountService;
import com.july.mystore.service.impl.UserAccountService;
import com.july.mystore.util.AppUtils;

@WebServlet(urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IUserAccountService userAccountService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		userAccountService = new UserAccountService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Forward to /WEB-INF/view/loginView.jsp
		// (Users can not access directly into JSP pages placed in WEB-INF)
		RequestDispatcher dispatcher //
				= this.getServletContext().getRequestDispatcher("/WEB-INF/view/loginView.jsp");

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userEmail = request.getParameter("user-email");
		String password = request.getParameter("password");
		String rememberMeStr = request.getParameter("remember-me");
		boolean remember = "Y".equals(rememberMeStr);

		UserAccount user = null;
		boolean hasError = false;
		String errorString = null;
		
	
		
		if (userEmail == null || password == null || userEmail.length() == 0 || password.length() == 0) {
			hasError = true;
			errorString = "Required user email and password!";
		} else {
			Connection conn = AppUtils.getStoredConnection(request);
			try {
				// Find the user in the DB.
				user = userAccountService.findByUserEmailAndPassword(conn, userEmail, password);

				if (user == null) {
					hasError = true;
					errorString = "User Emai or password invalid";
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				hasError = true;
				errorString = e.getMessage();
			}
		}
		
		
		// If error, forward to /WEB-INF/view/login.jsp
		if (hasError) {
			user = new UserAccount();
			user.setUserName(userEmail);
			user.setUserPassword(password);

			// Store information in request attribute, before forward.
			request.setAttribute("errorString", errorString);
			request.setAttribute("user", user);

			// Forward to /WEB-INF/views/login.jsp
			RequestDispatcher dispatcher //
					= request.getRequestDispatcher("/WEB-INF/view/loginView.jsp");

			dispatcher.forward(request, response);
		}
		// If no error
		// Store user information in Session
		// And redirect to userInfo page.
		else {
			HttpSession session = request.getSession();
			AppUtils.storeLoginedUser(session, user);
			
			
			if (user.getUserRole() == EnumConstant.Role.ADMIN.value) {
				
					
				response.sendRedirect(request.getContextPath() + "/admin/home");
			
			} else if (user.getUserRole() == EnumConstant.Role.USER.value) {
				// If user checked "Remember me".
				if (remember) {
					AppUtils.storeUserCookie(response, user);
				}
				// Else delete cookie.
				else {
					AppUtils.deleteUserCookie(response);
				}

				// Redirect to userInfo page.
				response.sendRedirect(request.getContextPath() + "/home");
			}
			
			
		}
	}

}
