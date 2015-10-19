package cn.bmy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo1 extends HttpServlet 
{
	public void service(ServletRequest req, ServletResponse res) throws IOException
	{
		res.getOutputStream().write("Hello servlet!!".getBytes());
		
	}

	

}
