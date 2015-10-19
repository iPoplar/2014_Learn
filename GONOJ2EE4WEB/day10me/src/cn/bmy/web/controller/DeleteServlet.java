package cn.bmy.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bmy.domain.Cart;
import cn.bmy.exception.CartNotFoundException;
import cn.bmy.service.BusinessService;

public class DeleteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String bookid = request.getParameter("bookid");
		
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		
		BusinessService service = new BusinessService();
		try {
			service.deleteBook(bookid,cart);
			request.getRequestDispatcher("/WEB-INF/jsp/listcart.jsp").forward(request, response);
			
		} catch (CartNotFoundException e) {
			request.setAttribute("message", "�Բ�������û�й����κ���Ʒ!!!");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
