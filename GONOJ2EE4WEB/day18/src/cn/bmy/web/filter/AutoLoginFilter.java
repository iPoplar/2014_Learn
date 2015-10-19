package cn.bmy.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bmy.dao.UserDao;
import cn.bmy.domain.User;
import cn.bmy.utils.WebUtils;

public class AutoLoginFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		if(request.getSession().getAttribute("user")!=null)
		{
			chain.doFilter(request, response);
			return;
		}
		
		//1.�õ��û���������authlogin��cookie
		String value = null;
		Cookie cookies[] = request.getCookies();
		for(int i=0; cookies!=null && i < cookies.length; i++)
		{
			value = cookies[i].getValue();
		}
		
		//2.�õ�cookie�е��û���������
		if(value!=null)
		{
			String username = value.split("\\.")[0];
			String password = value.split("\\.")[1];
			
			//3.����dao��ȡ�û���Ӧ������
			UserDao dao = new UserDao();
			User user = dao.find(username);
			String dbpassword = user.getPassword();
			
			//4.����û���������md5����������ݿ��е������Ƿ�ƥ�䣬��ƥ�����Զ���¼
			if(password.equals(WebUtils.md5(dbpassword)))
			{
				request.getSession().setAttribute("user", user);
			}
		}
		
		chain.doFilter(request, response);
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
