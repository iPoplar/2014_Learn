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
 *��վ��ҳ������ʵ����ʾ�û��ϴη���ʱ�� 
 *
 */
public class CookieDemo1 extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		response.setContentType("text/html;charset=UTF-8"); //����������鿴�����
		PrintWriter out = response.getWriter();
		out.write("������վ��ҳ������<br/><br/>");
		
		out.write("���ϴη��ʵ�ʱ���ǣ�");
		//�õ��ϴη��ʵ�ʱ��
		Cookie cookies[] = request.getCookies();	//��ȡ�ͻ����ύ��Cookie
		/*
		 * һ��Cookieֻ�ܱ�ʶһ����Ϣ�������ٺ���һ����ʶ����Ϣ�����ƣ�NAME��������ֵ��VALUE����
		 */
		for(int i = 0; cookies != null && i < cookies.length; i++)
		{
			Cookie cookie = cookies[i];
			if(cookie.getName().equals("lastAccessTime"))
			{
				long time = Long.parseLong(cookie.getValue());
				Date d = new Date(time);
				out.write(d.toLocaleString());//�����ڸ�ʽ���ó����ǳ��õ�
				  
			}
		}
		
		//���û���cookie����ʽ�����µ�ʱ��
		Cookie cookie = new Cookie("lastAccessTime",System.currentTimeMillis()+"");
		cookie.setMaxAge(10000); //����cookie����//day06/servlet/
		cookie.setPath("day06");
		/*
		 * ����ͬһӦ�÷������ڹ�����������cookie.setPath("/");
		 */
		response.addCookie(cookie);//�����������һ��cookie
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
	
	
}
