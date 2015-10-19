package cn.bmy.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *ɾ��cookie
 */
public class CookieDemo2 extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		/*
		 * һ���Ự�����cookie�����洢����������ڴ��У����û��˳������֮�󼴱�ɾ������ϣ���������
		 * ��cookie�洢�ڴ����ϣ�����Ҫʹ��maxAge��������һ������Ϊ��λ��ʱ�䡣�����ʱЧ��Ϊ0�������������ɾ����cookie��
			ע�⣬ɾ��cookieʱ��path����һ�£����򲻻�ɾ��
		 */
		Cookie cookie = new Cookie("lastAccessTime",System.currentTimeMillis()+"");
		cookie.setMaxAge(0);
		cookie.setPath("/day06");
		
		response.addCookie(cookie);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
