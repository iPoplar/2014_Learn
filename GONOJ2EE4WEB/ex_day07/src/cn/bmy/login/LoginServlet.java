package cn.bmy.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = DB.find(username, password);
		if(user==null)
		{
			out.write("您的用户名和密码为正确填写");
		}
		//向用户session中存一个登陆标记,也就是让用户登陆成功
		request.getSession().setAttribute("user", user);
		//跳首页
		response.sendRedirect("/ex_day07/index.jsp");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

class DB 
{//此处没有查找的需求，所以使用单列的集合即可
	private static List<User> list = new ArrayList();
	static
	{
		list.add(new User("aaa","123"));
		list.add(new User("bbb","123"));
		list.add(new User("ccc","123"));
	}
	
	public  static User find(String username, String password)
	{
		for(User user : list)
		{
			if(user.getUsername().equals(username) && user.getPassword().equals(password))
			{
				return user;
			}
		}
		return null;
	}
}


