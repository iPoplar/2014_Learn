package cn.bmy.shopping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BuyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String id = request.getParameter("id");
		Book book = (Book) DB.getAll().get(id);//得到用户想买的书
		
		HttpSession session = request.getSession();
		Cookie cookie = new Cookie("JSESSIONID",session.getId());
		cookie.setMaxAge(1*3600);
		cookie.setPath("/ex_day07");//访问ex_day07下的所有资源，都会带着cookie去
		
		response.addCookie(cookie);
		
		List list = (List) session.getAttribute("list");//得到用户用于保存所有书的容器
		//判断session中是否有这个容器，如果第一次没哟，就new一个容器
		if(list==null)
		{
			list = new ArrayList();
			session.setAttribute("list", list);
		}
		list.add(book);
		
		//forward的性能上要比sendRedirect要好一些
		//request.getRequestDispatcher("/servlet/ListCartServlet").forward(request, response);
		//response.sendRedirect("/ex_day07/servlet/ListCartServlet");
		//当cookie被禁用时，要实现servlet数据共享 ----url重写
		String url = response.encodeRedirectURL("/ex_day07/servlet/ListCartServlet");
		response.sendRedirect(url);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
