package cn.itcast.web.UI;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Role;
import cn.itcast.service.SecurityService;
//为角色授权提供用户界面
public class AddRolePrivilegeUIServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String role_id = request.getParameter("role_id");
		
		SecurityService service = new SecurityService();
		//得到角色信息
		Role role = service.findRole(role_id);
		
		//得到角色当前拥有的权限
		List role_privileges = service.getRolePrivileges(role_id);
		
		//得到系统所有权限
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
