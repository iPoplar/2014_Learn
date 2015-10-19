package cn.bmy.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bmy.domain.Page;
import cn.bmy.service.BusinessService;


public class ListCustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try{
			String pagenum = request.getParameter("pagenum");
			BusinessService service = new BusinessService();
			
			String serletName = this.getServletName();
		
			Page page = service.getPageData(pagenum,request.getContextPath() + "/servlet/" + serletName);
			request.setAttribute("page", page);
			request.getRequestDispatcher("/WEB-INF/jsp/listcustomer.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "≤È—Ø ß∞‹£°£°£°");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
