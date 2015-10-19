package cn.bmy.login2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String checkcode = request.getParameter("checkcode");
		String s_checkcode = (String) request.getSession().getAttribute("checkcode");
		if(checkcode==null || s_checkcode==null || !checkcode.equals(s_checkcode))
		{
			System.out.println("认证码错误！");
			return ;
		}
		
		//得到用户名和密码，帮用户完成登陆

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
