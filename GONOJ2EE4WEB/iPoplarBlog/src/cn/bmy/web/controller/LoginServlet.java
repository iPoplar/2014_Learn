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
			List list = service.getLoginInfo();
			request.setAttribute("list", list);
			//request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
			System.out.println("����Ҫ����Ҫִ�е�½���ˣ�");
			request.getRequestDispatcher("/index.jsp");
			System.out.println("�����Ѿ�ִ������ˣ�");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "��½ʧ������");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
		
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
