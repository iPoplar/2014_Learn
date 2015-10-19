package cn.bmy.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bmy.dao.UserDao;
import cn.bmy.domain.User;
import cn.bmy.utils.WebUtils;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDao dao = new UserDao();
		User user = dao.find(username, password);
		if(user==null)
		{
			request.setAttribute("message", "用户名或密码不对!!");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		request.getSession().setAttribute("user", user);
		request.setAttribute("message", "登录成功!!!");
		
		//发送自动登录cookie
		sendAutoLoginCookie(request,response,user);

	}

	private void sendAutoLoginCookie(HttpServletRequest request,
			HttpServletResponse response, User user) {
		int logintime = Integer.parseInt(request.getParameter("logintime"));
		Cookie cookie = new Cookie("autologin",user.getUsername()+"." +WebUtils.md5(user.getPassword()));
		cookie.setMaxAge(logintime);
		cookie.setPath("/day18");
		response.addCookie(cookie);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
