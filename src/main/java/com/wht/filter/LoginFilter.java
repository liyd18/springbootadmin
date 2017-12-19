package com.wht.filter;

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import com.wht.config.User;

@Order(1)
@WebFilter(filterName="loginFilter",urlPatterns="/index/*",asyncSupported=true)
public class LoginFilter implements Filter{
	private static Logger logger = LoggerFactory.getLogger(LoginFilter.class);
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>进入过滤器");
		try {
			HttpServletRequest req = (HttpServletRequest) request;
			User user = (User) req.getSession().getAttribute("user");
			if (user==null) {
				HttpServletResponse res = (HttpServletResponse) response;
				res.sendRedirect("/login");
			}else{
				chain.doFilter(request, response);
			}
		} catch (Exception e) {
			//有异常，放过
			logger.error("filter error: " + e.getStackTrace());
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
