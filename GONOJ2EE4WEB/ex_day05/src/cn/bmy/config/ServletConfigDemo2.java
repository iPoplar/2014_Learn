package cn.bmy.config;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//��ȡ��ʼ����������һ�ַ�������Ϊ��������servletConfig���󣬻�ȡ�˶���
public class ServletConfigDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		ServletConfig config = this.getServletConfig();
		System.out.println(config.getInitParameter("zz"));

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
