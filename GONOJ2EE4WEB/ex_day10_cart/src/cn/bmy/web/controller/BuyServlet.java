package cn.bmy.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bmy.domain.Cart;
import cn.bmy.service.BusinessService;

//完成购买操作
public class BuyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String bookid = request.getParameter("bookid");
		
		//把用户的书加到购物车中
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if(cart==null)
		{
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		
		BusinessService service = new BusinessService();
		service.buybook(bookid, cart);
		
		request.getRequestDispatcher("/WEB-INF/jsp/listcart.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
