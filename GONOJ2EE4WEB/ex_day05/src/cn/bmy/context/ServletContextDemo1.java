package cn.bmy.context;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ServletContext代表一个web应用，通过setAttribute()存东西，
 * 并且是以map方式存取
 * 功能：1.管理web应用；2.实现servlet之间的通信
  */
//Demo1和Demo2  多个servlet通过servletContext实现数据共享
public class ServletContextDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String data = "dsaffsf";
		
		ServletContext context = this.getServletConfig().getServletContext();
		context.setAttribute("data", data);
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
