package cn.bmy.servletconfig;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfigServletDemo1 extends HttpServlet {

	private ServletConfig config;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		//获取指定的初始化参数
		String value = config.getInitParameter("xxx");
		response.getOutputStream().write(value.getBytes());
		
		//获取所有初始化参数
		Enumeration e =  config.getInitParameterNames();
		while(e.hasMoreElements())
		{
			String name = (String) e.nextElement();
			value = config.getInitParameter(name);
			response.getOutputStream().write((name + "=" + value + "<br/>").getBytes());
			
		}
		
		String charset = this.config.getInitParameter("charset");
		String url = this.config.getInitParameter("url");
		String username = this.config.getInitParameter("username");
		String password = this.config.getInitParameter("password");
		
		System.out.println(url);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}
	

}
