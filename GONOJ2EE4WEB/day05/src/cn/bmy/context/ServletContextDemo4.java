package cn.bmy.context;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextDemo4 extends HttpServlet {

	//用servletContext实现请求转发mvc
	//注意:
	//1.转发之前的所有写入都无效
	//2.转发前，response不能提交，否则转发时候服务器会抛出：Cannot forward after response has been committed
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.getOutputStream().write("00000".getBytes());
		ServletContext context = this.getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/servlet/ServletContextDemo5");
		rd.forward(request, response);
		
		response.getOutputStream().write("454545454".getBytes());

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
