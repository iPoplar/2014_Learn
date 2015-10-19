package cn.bmy.context;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextDemo4 extends HttpServlet {

	//��servletContextʵ������ת��mvc
	//ע��:
	//1.ת��֮ǰ������д�붼��Ч
	//2.ת��ǰ��response�����ύ������ת��ʱ����������׳���Cannot forward after response has been committed
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
