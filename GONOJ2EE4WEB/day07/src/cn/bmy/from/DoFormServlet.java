package cn.bmy.from;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoFormServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		boolean b = isToken(request);//判断用户是否重复提交
		if(b==true)
		{
			System.out.println("请不要重复提交");
			return;
		}
		
		request.getSession().removeAttribute("token");
		System.out.println("处理用户提交请求！！");

	}

	private boolean isToken(HttpServletRequest request) 
	{
		String client_token = request.getParameter("token");
		if(client_token == null)
		{
			return true;
		}
		
		String server_token = (String) request.getSession().getAttribute("token");
		if(server_token == null)
		{
			return true;
		}
		
		if(!client_token.equals(server_token))
		{
			return true;
		}
		return false;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
