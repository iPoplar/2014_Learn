package cn.itcast.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.service.impl.BusinessService;

public class ListCustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try{
			BusinessService service = new BusinessService();
			List list = service.getAllCustomer();
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/jsp/listcustomer.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "��ѯʧ�ܣ�����");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
