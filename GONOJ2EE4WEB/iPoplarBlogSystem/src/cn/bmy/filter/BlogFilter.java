package cn.bmy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BlogFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req  = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		String userName = (String) session.getAttribute("userName");
		if(userName != null)
		{
			//放行，校验通过
			chain.doFilter(request, response);
		}
		else
		{
			//拦截，校验不让通过
			request.setAttribute("message", "您是非法登陆,请按要求登陆!");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
			
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
