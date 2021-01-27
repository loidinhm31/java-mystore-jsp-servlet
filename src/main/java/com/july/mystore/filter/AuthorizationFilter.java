package com.july.mystore.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.july.mystore.model.EnumConstant;
import com.july.mystore.model.UserAccount;
import com.july.mystore.util.AppUtils;

@WebFilter(filterName = "authorizationFilter", urlPatterns = { "/*" })
public class AuthorizationFilter implements Filter {

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

		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession session = req.getSession();

		String url = req.getRequestURI();

		if (url.startsWith(req.getContextPath() + "/admin/")) {
			UserAccount user = AppUtils.getLoginedUser(session);
			if (user != null) {
				
				if (user.getUserRole() == EnumConstant.Role.ADMIN.value) {

					chain.doFilter(request, response);
				} else if (user.getUserRole() == (EnumConstant.Role.USER.value)) {
					res.sendRedirect(req.getContextPath() + "/error");
				}
			} else {
				res.sendRedirect(req.getContextPath() + "/error");
			}

		} else {
			chain.doFilter(request, response);
		}
		
		

	}

}
