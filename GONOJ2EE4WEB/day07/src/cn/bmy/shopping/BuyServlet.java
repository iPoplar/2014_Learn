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

public class BuyServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String id = request.getParameter("id");
		Book book  = (Book) DB.getAll().get(id); //得到用户想买的书
		HttpSession session = request.getSession();
		
		Cookie cookie = new Cookie("JSESSIONID",session.getId());
		cookie.setMaxAge(30*60);
		cookie.setPath("/day07");
		response.addCookie(cookie);
		
		//得到用户用于保存的所有书的容器
		List list = (List) session.getAttribute("list");
		if(list==null)
		{
			list = new ArrayList();
			session.setAttribute("list", list);
		}
		list.add(book);
		

		//request.getRequestDispatcher("/servlet/ListCartServlet").forward(request, response);
		
		String url = response.encodeRedirectURL("/day07/servlet/ListCartServlet");
		System.out.println(url);
		response.sendRedirect(url);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
