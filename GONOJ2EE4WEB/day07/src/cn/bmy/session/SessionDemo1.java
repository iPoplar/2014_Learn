package cn.bmy.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionDemo1 extends HttpServlet 
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		session.setAttribute("data", "abc");
		

		/*String sessionid = session.getId();
		Cookie cookie = new Cookie("JSESSIONID",sessionid);
		cookie.setMaxAge(1*3600);
		cookie.setPath("/day07");
		
		response.addCookie(cookie);*/
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
