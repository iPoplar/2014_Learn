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
			//���У�У��ͨ��
			chain.doFilter(request, response);
		}
		else
		{
			//���أ�У�鲻��ͨ��
			request.setAttribute("message", "���ǷǷ���½,�밴Ҫ���½!");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
			
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
