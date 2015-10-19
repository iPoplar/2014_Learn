package cn.bmy.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bmy.exception.DaoException;
import cn.bmy.service.impl.BusinessService;

public class ListCustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		try 
		{
			BusinessService service = new BusinessService();
			List list = service.getAllCustomer();
			request.setAttribute("list", list);
			request.getRequestDispatcher("/WEB-INF/jsp/listcustomer.jsp").forward(request, response);
			
		} catch (DaoException e) 
		{
			e.printStackTrace();
			request.setAttribute("message", "≤È—Ø ß∞‹@@");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
