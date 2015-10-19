package cn.bmy.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//网站首页，可以实现显示用户上次访问的时间
public class CookieDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.write("这是网站首页！！<br/><br/>");
		
		out.write("上次访问的时间是：");
		//得到上次访问的时间-----此段程序第一次访问浏览器时不执行
		Cookie cookies[] = request.getCookies();
		for(int i=0; cookies!=null && i<cookies.length; i++)
		{
			Cookie cookie = cookies[i];
			if(cookie.getName().equals("lastAccessTime"))
			{
				long time = Long.parseLong(cookie.getValue());
				Date d = new Date(time);
				out.write(d.toLocaleString());			
			}
				
		}
		
		//给用户以cookie的形式送最新的时间
		Cookie cookie = new Cookie("lastAccessTime",System.currentTimeMillis()+"");
		cookie.setMaxAge(10000);//设置cookie的有效期，单位是秒
		//当将cookie.setMaxAge(0); 即删除了cookie
		response.addCookie(cookie);
		/*
		 * cookie的path，如果没有设置，则，servlet在哪个目录，cookie就在那个目录
		 * eg:day07/servlet/
		 * 设置：cookie.setPath("/day07");
		 * 当设置了cookie的有效目录时，删除时，也要在设置有效路径下删
		 * eg：cookie.setMaxAge(0);
		 *     cookie.setPath("/day07");
		 */

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
