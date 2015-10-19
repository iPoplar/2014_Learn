package cn.bmy.request;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		InputStream in  = request.getInputStream();
		byte buffer[] = new byte[1024];
		int len = 0;
		while((len = in.read(buffer)) > 0)
		{
			System.out.println(new String(buffer,0,len));
			
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{

		doGet(request, response);
	}
	
	private void test1(HttpServletRequest request)
	{
		String headValue = request.getHeader("Accept-Encoding");
		Enumeration e = request.getHeaderNames();
		while(e.hasMoreElements())
		{
			String value = (String)e.nextElement();
			System.out.println(value);
		}
		
		e = request.getHeaderNames();
		while(e.hasMoreElements())
		{
			String name = (String) e.nextElement();
			String value = request.getHeader(name);
			System.out.println("name= " + name+ ",value=" + value);
			
		}
	}

}
