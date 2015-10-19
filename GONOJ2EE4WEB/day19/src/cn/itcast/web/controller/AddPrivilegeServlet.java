package cn.itcast.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Privilege;
import cn.itcast.service.SecurityService;
import cn.itcast.utils.WebUtils;

//添加权限
public class AddPrivilegeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try{
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			
			Privilege p = new Privilege();
			p.setName(name);
			p.setDescription(description);
			p.setId(WebUtils.makeUUID());
			
			SecurityService service = new SecurityService();
			service.addPrivilege(p);
			
			request.setAttribute("message", "添加成功！！");
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "添加失败！！");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
