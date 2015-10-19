package cn.bmy.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bmy.domain.Customer;
import cn.bmy.exception.DaoException;
import cn.bmy.service.BusinessService;
import cn.bmy.utils.WebUtils;

public class AddCustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");
		
		try {
			Customer c = WebUtils.request2Bean(request, Customer.class);
			c.setId(WebUtils.makeId());
			BusinessService service = new BusinessService();
			service.addCustomer(c);
			request.setAttribute("message", "客户添加成功！！");
		} catch (DaoException e) {
			e.printStackTrace();
			request.setAttribute("message", "客户添加失败！！");
		}
		
		request.getRequestDispatcher("/message.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
