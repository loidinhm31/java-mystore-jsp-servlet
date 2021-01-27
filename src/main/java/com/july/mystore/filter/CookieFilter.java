package com.july.mystore.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.july.mystore.model.UserAccount;
import com.july.mystore.service.IUserAccountService;
import com.july.mystore.service.impl.UserAccountService;
import com.july.mystore.util.AppUtils;


@WebFilter(filterName = "cookieFilter", urlPatterns = { "/*" })
public class CookieFilter implements Filter {
	private IUserAccountService userAccountService;
	
	public CookieFilter() {
		
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {

	}

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		
		// Connection was created in JDBCFilter.
		Connection conn = AppUtils.getStoredConnection(request);
		
		// Flag check cookie
		String checked = (String) session.getAttribute("COOKIE_CHECKED");		
		
		String userEmail = AppUtils.getUserInCookie(req);
		
		if (userEmail != null) {
			
			session.setAttribute("COOKIE_CHECKED", "CHECKED");
		}
		
		if (checked == null) {
			
			chain.doFilter(request, response);
			return;
		}
		
		
		if (checked != null && conn != null && userEmail != null) {
	
			try {
				UserAccount userInSession = AppUtils.getLoginedUser(session);
				if ( userInSession == null) {
					userAccountService = new UserAccountService();
					UserAccount user = userAccountService.findUser(conn, userEmail);
					AppUtils.storeLoginedUser(session, user);
				}	
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

		chain.doFilter(request, response);
	}

}
