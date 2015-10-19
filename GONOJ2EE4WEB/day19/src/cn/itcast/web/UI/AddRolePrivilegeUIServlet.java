package cn.itcast.web.UI;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Role;
import cn.itcast.service.SecurityService;
//Ϊ��ɫ��Ȩ�ṩ�û�����
public class AddRolePrivilegeUIServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String role_id = request.getParameter("role_id");
		
		SecurityService service = new SecurityService();
		//�õ���ɫ��Ϣ
		Role role = service.findRole(role_id);
		
		//�õ���ɫ��ǰӵ�е�Ȩ��
		List role_privileges = service.getRolePrivileges(role_id);
		
		//�õ�ϵͳ����Ȩ��
		List system_privileges = service.getAllPrivilege();
		
		
		request.setAttribute("role", role);
		request.setAttribute("role_privileges", role_privileges);
		request.setAttribute("system_privileges",  system_privileges);
		
		request.getRequestDispatcher("/jsp/addRolePrivilege.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
