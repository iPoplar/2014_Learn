package cn.bmy.Request;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		//ֻҪ��д��ַ����ͳͳ��/����
		//"/"�Ǹ��������õģ������web���̣�"/"�Ǹ�������õģ������webqpps
		//���������URL��Դ����"/"�������ȡӲ����Դ����"\\"
		
		//servletContext
		this.getServletContext().getRealPath("/download/11.jpg");
		
		
		//forward
		this.getServletContext().getRequestDispatcher("/register.html");
		
		//sendRedirct
		response.sendRedirect("/day06/register.html");
		
		//html <a href=""></a> ��������õ�
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
	
	private void test1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		/*
		mvc���ص㣺
		�ͻ��˵����ݴ�����servlet���û���ʾ����jsp��
		������jsp����request��servlet��request���л�ȡ�ģ�
	*/
	
		String data = "asbc";
		request.setAttribute("data", data);
		
		//ת��1��
		//this.getServletContext().getRequestDispatcher("/test.jsp").forward(request, response);
		
		//ת��2��
		RequestDispatcher rq = this.getServletContext().getRequestDispatcher("/test.jsp");
		rq.forward(request, response);
		
		//������ת������
	}

}
