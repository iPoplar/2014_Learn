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
		boolean b = isToken(request);//�ж��û��Ƿ��ظ��ύ
		if(b==true)
		{
			System.out.println("�벻Ҫ�ظ��ύ");
			return;
		}
		
		request.getSession().removeAttribute("token");
		System.out.println("�����û��ύ���󣡣�");

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
