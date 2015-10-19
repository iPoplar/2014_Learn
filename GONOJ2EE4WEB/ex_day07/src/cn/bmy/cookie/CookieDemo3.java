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

public class CookieDemo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//1.�����û���������id�ţ���ʾ��Ʒ����ϸ��Ϣ
		String id = request.getParameter("id");
		Book book = (Book) DB.getAll().get(id);
		
		out.write("��Ҫ�鿴�������ϸ��Ϣ���£�<br/><br/>");
		out.write(book.getId()+"<br/>");
		out.write(book.getName()+"<br/>");
		out.write(book.getAuthor()+"<br/>");
		out.write(book.getDescription()+"<br/>");
		
		
		//2.���û����Ͱ�����ǰ��Ʒid��cookie
		String bookHistory = makeHistory(request,id);
		Cookie cookie = new Cookie("bookHistory",bookHistory);
		//cookie.setMaxAge(1*30*24*3600);//������Чʱ��
		response.addCookie(cookie);
	}

	

	private String makeHistory(HttpServletRequest request, String id) 
	{
		String bookHistory = null;
		Cookie cookies[] = request.getCookies();
		for(int i=0; cookies!=null && i<cookies.length; i++)
		{
			if(cookies[i].getName().equals("bookHistory"))
			{
				bookHistory = cookies[i].getValue();
			}
		}
		
		//�������
		//  bookHistory=null      1    bookHistory=1
		//  bookHistory=3_1_5     1    bookHistory=1_3_5
		//  bookHistory=3_2_5     1    bookHistory=1_3_2
		//  bookHistory=3_2       1    bookHistory=1_3_2
		
		//  bookHistory=null      1    bookHistory=1
		if(bookHistory==null)
		{
			return id;
		}
		
		//��id�ò�ֳ����飬�ڽ������е����ݴ浽�����У����ü����еķ����ж��Ƿ����
		List li = Arrays.asList(bookHistory.split("\\_"));
		//��������Ҫ�Լ��ϵĽ�����ɾ�Ĳ飬��ʱ�����ʺ���List���ϣ��谡Ӵ��������д洢��
		LinkedList<String> list = new LinkedList();
		list.addAll(li);//��List�����е����ݵ��뵽������
		
		//  bookHistory=3_1_5     1    bookHistory=1_3_5
		if(list.contains(id))
		{
			list.remove(id);//�Ƴ�id
			list.addFirst(id);//��id�ӵ���ǰ��
		}
		else
		{
			if(list.size()>=3)
			{//bookHistory=3_2_5     1    bookHistory=1_3_2
				list.removeLast();//�Ƴ����һ��id
				list.addFirst(id);//����id������ǰ
			}
			else
			{//  bookHistory=3_2       1    bookHistory=1_3_2
				list.addFirst(id);
			}
		}
		
		//һ���漰�Ĺ����ַ������ͽ�StringBuffer new����
		StringBuffer sb = new StringBuffer();
		for(String lid : list)
		{
			sb.append(id+"_");
		}
		
		
		return sb.deleteCharAt(sb.length()-1).toString();
	}



	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}


