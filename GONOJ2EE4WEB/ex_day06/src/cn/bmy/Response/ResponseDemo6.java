package cn.bmy.Response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ä¯ÀÀÆ÷»º´æ
 * 
 */
public class ResponseDemo6 extends HttpServlet 
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String data = "aaaa";
		response.setDateHeader("expires", System.currentTimeMillis()+3600*1000);
		response.getWriter().write(data);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{

		doGet(request, response);
	}

}
