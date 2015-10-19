package cn.itcast.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.service.SecurityService;

//�г�����Ȩ��
public class ListPrivilegeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SecurityService service = new SecurityService();
		List privileges = service.getAllPrivilege();
		request.setAttribute("privileges", privileges);
		request.getRequestDispatcher("/jsp/listprivilege.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
