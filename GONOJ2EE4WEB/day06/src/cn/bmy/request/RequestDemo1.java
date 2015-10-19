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
		
		//用在权限设置上
		System.out.println(request.getQueryString());
		System.out.println(request.getRemoteAddr());//127.0.0.1
		System.out.println(request.getRemoteHost());//返回：127.0.0.1，因为没有在DNS中注册
		System.out.println(request.getRemotePort());//远程端口号49300
		System.out.println(request.getMethod());//GET,在表单里可为POST
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
