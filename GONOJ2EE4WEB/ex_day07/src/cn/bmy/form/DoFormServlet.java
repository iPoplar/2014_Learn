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
		//�ж��û��Ƿ��ظ��ύ
		boolean b =  isToken(request);
		if(b==true)
		{
			out.write("�Բ����벻Ҫ�ظ��ύ!!!");
			System.out.println("�Բ����벻Ҫ�ظ��ύ!!!");
			return;
		}
		
		request.getSession().removeAttribute("token");
		System.out.println("�����û��ύ����Q");
	}

	private boolean isToken(HttpServletRequest request) 
	{
		String client_token = request.getParameter("token");
		if(client_token==null)
		{
			return true;
		}
		
		String server_token = (String) request.getSession().getAttribute("token");
		if(server_token==null)//���ύ���󣬷������Ὣsession��������Ƴ���
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
