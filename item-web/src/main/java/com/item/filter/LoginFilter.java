package com.item.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.item.entity.Users;
import com.item.utils.StringUtil;



public class LoginFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		if(null == user){
			String url = request.getContextPath() + request.getServletPath();
			if(StringUtil.isNotNull(request.getQueryString())){
				url += ("?" + request.getQueryString());
			}
			session.setAttribute("url", url);
			response.sendRedirect("/item-web/login.do");
		}else{
			chain.doFilter(req, res);
		}
//		chain.doFilter(req, res);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
