package cn.bmy.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//��վ��ҳ������ʵ����ʾ�û��ϴη��ʵ�ʱ��
public class CookieDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.write("������վ��ҳ����<br/><br/>");
		
		out.write("�ϴη��ʵ�ʱ���ǣ�");
		//�õ��ϴη��ʵ�ʱ��-----�˶γ����һ�η��������ʱ��ִ��
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
		
		//���û���cookie����ʽ�����µ�ʱ��
		Cookie cookie = new Cookie("lastAccessTime",System.currentTimeMillis()+"");
		cookie.setMaxAge(10000);//����cookie����Ч�ڣ���λ����
		//����cookie.setMaxAge(0); ��ɾ����cookie
		response.addCookie(cookie);
		/*
		 * cookie��path�����û�����ã���servlet���ĸ�Ŀ¼��cookie�����Ǹ�Ŀ¼
		 * eg:day07/servlet/
		 * ���ã�cookie.setPath("/day07");
		 * ��������cookie����ЧĿ¼ʱ��ɾ��ʱ��ҲҪ��������Ч·����ɾ
		 * eg��cookie.setMaxAge(0);
		 *     cookie.setPath("/day07");
		 */

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
