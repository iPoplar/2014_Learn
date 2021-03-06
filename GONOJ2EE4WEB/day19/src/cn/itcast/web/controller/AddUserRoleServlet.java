package cn.itcast.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.service.SecurityService;

//更新用户角色
public class AddUserRoleServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try{
			//得到需要授于角色的用户id
			String user_id = request.getParameter("user_id");
			
			
			//得到需要授权的所有角色id
			String role_ids[] = request.getParameterValues("role_id"); //null
			
			SecurityService service = new SecurityService();
			service.updateUserRole(user_id, role_ids);
			request.setAttribute("message", "更新成功！！");
			
		
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "更新失败！！");
		}
		
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
