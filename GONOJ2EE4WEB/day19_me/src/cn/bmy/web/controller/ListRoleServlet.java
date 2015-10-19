package cn.bmy.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bmy.domain.Role;
import cn.bmy.service.SecurityService;

//�г����н�ɫ
public class ListRoleServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		SecurityService  service = new SecurityService();
		List<Role> roles = service.getAllRole();
		request.setAttribute("roles", roles);
		request.getRequestDispatcher("/jsp/listroles.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
