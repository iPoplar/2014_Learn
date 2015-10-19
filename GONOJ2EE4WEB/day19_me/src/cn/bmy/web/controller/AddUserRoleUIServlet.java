package cn.bmy.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bmy.domain.User;
import cn.bmy.service.SecurityService;

public class AddUserRoleUIServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user_id = request.getParameter("user_id");
		SecurityService service = new SecurityService();
		
		
		User user = service.findUser(user_id);
		List user_roles = service.getUserRoles(user_id);
		List system_roles = service.getAllRole();
		
		request.setAttribute("user", user);
		request.setAttribute("user_roles", user_roles);
		request.setAttribute("system_roles", system_roles);
		
		request.getRequestDispatcher("/jsp/addUserRole.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
