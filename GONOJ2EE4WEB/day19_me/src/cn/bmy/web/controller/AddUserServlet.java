package cn.bmy.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bmy.domain.User;
import cn.bmy.service.SecurityService;
import cn.bmy.utils.WebUtils;

//����û�
public class AddUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		try
		{
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			User user = new User();
			user.setId(WebUtils.makeUUID());
			user.setUsername(username);
			user.setPassword(password);
			
			SecurityService service = new SecurityService();
			service.addUser(user);
			request.setAttribute("message", "��ӳɹ�����");
			}catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("message", "���ʧ�ܣ���");
			}
			request.getRequestDispatcher("/message.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
