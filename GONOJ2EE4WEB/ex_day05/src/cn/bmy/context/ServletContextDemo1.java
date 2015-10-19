package cn.bmy.context;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ServletContext����һ��webӦ�ã�ͨ��setAttribute()�涫����
 * ��������map��ʽ��ȡ
 * ���ܣ�1.����webӦ�ã�2.ʵ��servlet֮���ͨ��
  */
//Demo1��Demo2  ���servletͨ��servletContextʵ�����ݹ���
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
