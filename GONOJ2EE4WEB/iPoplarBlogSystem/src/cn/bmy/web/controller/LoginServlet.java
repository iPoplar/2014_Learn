package cn.bmy.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bmy.service.impl.BusinessService;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			BusinessService service = new BusinessService();
			List list = service.getUserInfo();
			request.setAttribute("list", list);
			System.out.println("马上要跳转呀！");
			request.getRequestDispatcher("/main/Login.jsp");
			System.out.println("这是跳转完成的节奏就！");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "登陆失败啦！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);		
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
