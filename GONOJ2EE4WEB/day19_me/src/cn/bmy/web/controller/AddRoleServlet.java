package cn.bmy.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bmy.domain.Role;
import cn.bmy.service.SecurityService;
import cn.bmy.utils.WebUtils;

public class AddRoleServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			
			Role role = new Role();
			role.setName(name);
			role.setDescription(description);
			role.setId(WebUtils.makeUUID());
			
			SecurityService service = new SecurityService();
			service.addRole(role);
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
