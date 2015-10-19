package cn.bmy.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *网站首页：可以实现显示用户上次访问时间 
 *
 */
public class CookieDemo1 extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		response.setContentType("text/html;charset=UTF-8"); //设置浏览器查看编码表
		PrintWriter out = response.getWriter();
		out.write("这是网站首页！！！<br/><br/>");
		
		out.write("你上次访问的时间是：");
		//得到上次访问的时间
		Cookie cookies[] = request.getCookies();	//获取客户端提交的Cookie
		/*
		 * 一个Cookie只能标识一种信息，它至少含有一个标识该信息的名称（NAME）和设置值（VALUE）。
		 */
		for(int i = 0; cookies != null && i < cookies.length; i++)
		{
			Cookie cookie = cookies[i];
			if(cookie.getName().equals("lastAccessTime"))
			{
				long time = Long.parseLong(cookie.getValue());
				Date d = new Date(time);
				out.write(d.toLocaleString());//将日期格式设置成我们常用的
				  
			}
		}
		
		//给用户以cookie的形式送最新的时间
		Cookie cookie = new Cookie("lastAccessTime",System.currentTimeMillis()+"");
		cookie.setMaxAge(10000); //设置cookie期限//day06/servlet/
		cookie.setPath("day06");
		/*
		 * 可在同一应用服务器内共享方法：设置cookie.setPath("/");
		 */
		response.addCookie(cookie);//向浏览器回送一个cookie
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
	
	
}
