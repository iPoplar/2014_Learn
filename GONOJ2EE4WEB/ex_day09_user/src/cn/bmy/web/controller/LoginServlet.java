package cn.bmy.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bmy.domain.User;
import cn.bmy.service.BusinessService;
import cn.bmy.service.impl.BusinessServiceImpl;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		BusinessService service = new BusinessServiceImpl();
		User user = service.login(username, password);
		if(user==null)
		{
			request.setAttribute("message", "sorry!@��������û������������󣡣�");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		//request.setAttribute("message", "��ϲ��"+user.getUsername()+",��½�ɹ�����ҳ����5���������ҳ����<meta http-equiv='refresh' content='5;url=/day09_user/index.jsp'");
		request.getSession().setAttribute("user", user);
		request.setAttribute("message", "O(��_��)O~���ڵ�½�ɹ���������"+user.getUsername()+",��½�ɹ�����ҳ����5���������ҳ����<meta http-equiv='refresh' content='5;url=/ex_day09_user/index.jsp'>");
		request.getRequestDispatcher("/message.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
