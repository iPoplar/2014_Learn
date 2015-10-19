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
		
		//1.根据用户带过来的id号，显示商品的详细信息
		String id = request.getParameter("id");
		Book book = (Book) DB.getAll().get(id);
		
		out.write("您要查看的书的详细信息如下：<br/><br/>");
		out.write(book.getId()+"<br/>");
		out.write(book.getName()+"<br/>");
		out.write(book.getAuthor()+"<br/>");
		out.write(book.getDescription()+"<br/>");
		
		
		//2.给用户回送包含当前商品id的cookie
		String bookHistory = makeHistory(request,id);
		Cookie cookie = new Cookie("bookHistory",bookHistory);
		//cookie.setMaxAge(1*30*24*3600);//设置有效时间
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
		
		//四种情况
		//  bookHistory=null      1    bookHistory=1
		//  bookHistory=3_1_5     1    bookHistory=1_3_5
		//  bookHistory=3_2_5     1    bookHistory=1_3_2
		//  bookHistory=3_2       1    bookHistory=1_3_2
		
		//  bookHistory=null      1    bookHistory=1
		if(bookHistory==null)
		{
			return id;
		}
		
		//将id好拆分成数组，在将数组中的数据存到集合中，调用集合中的方法判断是否包含
		List li = Arrays.asList(bookHistory.split("\\_"));
		//接下来需要对集合的进行增删改查，此时，不适合用List集合，需啊哟用链表进行存储！
		LinkedList<String> list = new LinkedList();
		list.addAll(li);//将List集合中的数据导入到链表中
		
		//  bookHistory=3_1_5     1    bookHistory=1_3_5
		if(list.contains(id))
		{
			list.remove(id);//移除id
			list.addFirst(id);//将id加到最前面
		}
		else
		{
			if(list.size()>=3)
			{//bookHistory=3_2_5     1    bookHistory=1_3_2
				list.removeLast();//移除最后一个id
				list.addFirst(id);//将现id加至最前
			}
			else
			{//  bookHistory=3_2       1    bookHistory=1_3_2
				list.addFirst(id);
			}
		}
		
		//一旦涉及的构建字符串，就将StringBuffer new出来
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


