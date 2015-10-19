package cn.bmy.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//1.根据用户带过来的id号，显示商品的详细信息
		String id = request.getParameter("id");
		Book book = (Book) DB.getAll().get(id);
		
		out.write("您要查看的书的详细信息如下：<br/><br/>");
		
		out.write(book.getId() + "<br/>");	
		out.write(book.getName() + "<br/>");
		out.write(book.getAuthor() + "<br/>");
		out.write(book.getDescription() + "<br/>");
		
		//2.给用户回送包含当前的商品id的cookie
		String bookHistory = makeHistory(request,id);
	}

	private String makeHistory(HttpServletRequest request, String id) 
	{
		String bookHistory = null;
		Cookie cookies[] = request.getCookies(); //自定义所需功能的cookie，覆盖自带的cookie
		for(int i = 0; cookies != null && i < cookies.length; i++)
		{
			if(cookies[i].getName().equals("bookHistory"))
			{
				bookHistory = cookies[i].getValue();
			}
		}
		//有这些情况
	//  bookHistory=null      1    bookHistory=1
		//  bookHistory=3_1_5     1    bookHistory=1_3_5
		//  bookHistory=3_2_5     1    bookHistory=1_3_2
		//  bookHistory=3_2       1    bookHistory=1_3_2
		
		
	//  bookHistory=null      1    bookHistory=1
		if(bookHistory == null)
		{
			return id;
		}
		
		List l = Arrays.asList(bookHistory.split("\\_"));//[3,4]  //数组  链接
		LinkedList<String> list = new LinkedList();
		list.addAll(l);
		
		if(list.contains(id))
		{
			//  bookHistory=3_1_5     1    bookHistory=1_3_5
			list.remove(id);
			list.addFirst(id);
		}
		else
		{
			if(list.size()>=3)
			{
				//  bookHistory=3_2_5     1    bookHistory=1_3_2
				list.removeLast();
				list.addFirst(id);
			}
			else
			{
				//  bookHistory=3_2       1    bookHistory=1_3_2
				list.addFirst(id);
			}
		}
		
		StringBuffer sb = new StringBuffer();
		for(String lid : list)
		{
			sb.append(lid + "_");//追加子串
		}
		
		
		return sb.deleteCharAt(sb.length()-1).toString();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
