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

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.item.entity.SysInfo;
import com.item.entity.Users;
import com.item.service.SysInfoService;
import com.item.utils.StringUtil;



public class UrlFilter implements Filter{

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
		String url = (String) session.getAttribute("url");
		if(StringUtil.isNotNull(url)){
			session.removeAttribute("url");
			response.sendRedirect(url);
		}else{
			ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
			SysInfoService sysInfoService = (SysInfoService) applicationContext.getBean("sysInfoServiceImpl");
			SysInfo sysInfo = new SysInfo();
			Users user = (Users) session.getAttribute("user");
			sysInfo.setDocCreatorId(user.getId());
			if(StringUtil.isNull(sysInfo.getReadFlag())){
				sysInfo.setReadFlag("0");
			}
			session.setAttribute("unReadNum", sysInfoService.count(sysInfo));
			chain.doFilter(req, res);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
