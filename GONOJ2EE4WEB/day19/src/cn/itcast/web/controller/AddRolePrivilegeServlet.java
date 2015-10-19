package cn.itcast.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.service.SecurityService;

//���½�ɫȨ��
public class AddRolePrivilegeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try{
			String role_id = request.getParameter("role_id");
			String privilege_ids[] = request.getParameterValues("privilege_id");
			SecurityService service = new SecurityService();
			service.updateRolePrivilege(role_id,privilege_ids);
			request.setAttribute("message", "��Ȩ�ɹ�����");
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "��Ȩʧ�ܣ���");
		}
		
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
