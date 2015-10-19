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
		
		//1.�����û���������id�ţ���ʾ��Ʒ����ϸ��Ϣ
		String id = request.getParameter("id");
		Book book = (Book) DB.getAll().get(id);
		
		out.write("��Ҫ�鿴�������ϸ��Ϣ���£�<br/><br/>");
		
		out.write(book.getId() + "<br/>");	
		out.write(book.getName() + "<br/>");
		out.write(book.getAuthor() + "<br/>");
		out.write(book.getDescription() + "<br/>");
		
		//2.���û����Ͱ�����ǰ����Ʒid��cookie
		String bookHistory = makeHistory(request,id);
	}

	private String makeHistory(HttpServletRequest request, String id) 
	{
		String bookHistory = null;
		Cookie cookies[] = request.getCookies(); //�Զ������蹦�ܵ�cookie�������Դ���cookie
		for(int i = 0; cookies != null && i < cookies.length; i++)
		{
			if(cookies[i].getName().equals("bookHistory"))
			{
				bookHistory = cookies[i].getValue();
			}
		}
		//����Щ���
	//  bookHistory=null      1    bookHistory=1
		//  bookHistory=3_1_5     1    bookHistory=1_3_5
		//  bookHistory=3_2_5     1    bookHistory=1_3_2
		//  bookHistory=3_2       1    bookHistory=1_3_2
		
		
	//  bookHistory=null      1    bookHistory=1
		if(bookHistory == null)
		{
			return id;
		}
		
		List l = Arrays.asList(bookHistory.split("\\_"));//[3,4]  //����  ����
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
			sb.append(lid + "_");//׷���Ӵ�
		}
		
		
		return sb.deleteCharAt(sb.length()-1).toString();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
