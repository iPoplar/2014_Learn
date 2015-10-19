package cn.itcast.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.service.SecurityService;

//�����û���ɫ
public class AddUserRoleServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try{
			//�õ���Ҫ���ڽ�ɫ���û�id
			String user_id = request.getParameter("user_id");
			
			
			//�õ���Ҫ��Ȩ�����н�ɫid
			String role_ids[] = request.getParameterValues("role_id"); //null
			
			SecurityService service = new SecurityService();
			service.updateUserRole(user_id, role_ids);
			request.setAttribute("message", "���³ɹ�����");
			
		
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "����ʧ�ܣ���");
		}
		
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}