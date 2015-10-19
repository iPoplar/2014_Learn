package cn.bmy.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DoFormServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//判断用户是否重复提交
		boolean b =  isToken(request);
		if(b==true)
		{
			out.write("对不起，请不要重复提交!!!");
			System.out.println("对不起，请不要重复提交!!!");
			return;
		}
		
		request.getSession().removeAttribute("token");
		System.out.println("处理用户提交请求Q");
	}

	private boolean isToken(HttpServletRequest request) 
	{
		String client_token = request.getParameter("token");
		if(client_token==null)
		{
			return true;
		}
		
		String server_token = (String) request.getSession().getAttribute("token");
		if(server_token==null)//当提交过后，服务器会将session的随机数移除的
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
