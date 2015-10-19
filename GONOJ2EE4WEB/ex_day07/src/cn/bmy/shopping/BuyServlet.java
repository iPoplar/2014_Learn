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
		Book book = (Book) DB.getAll().get(id);//�õ��û��������
		
		HttpSession session = request.getSession();
		Cookie cookie = new Cookie("JSESSIONID",session.getId());
		cookie.setMaxAge(1*3600);
		cookie.setPath("/ex_day07");//����ex_day07�µ�������Դ���������cookieȥ
		
		response.addCookie(cookie);
		
		List list = (List) session.getAttribute("list");//�õ��û����ڱ��������������
		//�ж�session���Ƿ�����������������һ��ûӴ����newһ������
		if(list==null)
		{
			list = new ArrayList();
			session.setAttribute("list", list);
		}
		list.add(book);
		
		//forward��������Ҫ��sendRedirectҪ��һЩ
		//request.getRequestDispatcher("/servlet/ListCartServlet").forward(request, response);
		//response.sendRedirect("/ex_day07/servlet/ListCartServlet");
		//��cookie������ʱ��Ҫʵ��servlet���ݹ��� ----url��д
		String url = response.encodeRedirectURL("/ex_day07/servlet/ListCartServlet");
		response.sendRedirect(url);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
