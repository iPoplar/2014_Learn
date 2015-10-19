package cn.bmy.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		System.out.println(request.getRequestURI());
		///day06/servlet/requestDemo1
		System.out.println(request.getRequestURL());
		//http://localhost:8080/day06/servlet/requestDemo1
		
		//����Ȩ��������
		System.out.println(request.getQueryString());
		System.out.println(request.getRemoteAddr());//127.0.0.1
		System.out.println(request.getRemoteHost());//���أ�127.0.0.1����Ϊû����DNS��ע��
		System.out.println(request.getRemotePort());//Զ�̶˿ں�49300
		System.out.println(request.getMethod());//GET,�ڱ����ΪPOST
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
