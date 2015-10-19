package cn.bmy.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bmy.domain.UserBlog;
import cn.bmy.service.impl.BusinessService;
import cn.bmy.utils.WebUtils;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("/index.jsp");
		try {
			UserBlog user = WebUtils.request2Bean(request, UserBlog.class);
			BusinessService service = new BusinessService();
			service.addUserInfo(user);
			request.setAttribute("message", "博客用户注册成功！");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "博客用户注册失败！");
		}
		
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
