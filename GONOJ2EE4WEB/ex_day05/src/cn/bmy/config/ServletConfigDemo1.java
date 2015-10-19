package cn.bmy.config;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**��Servlet�������ļ��У�����ʹ��һ������<init-param>��ǩΪservlet����һЩ��ʼ��������

	��servlet�����˳�ʼ��������web�����ڴ���servletʵ������ʱ��
	���Զ�����Щ��ʼ��������װ��ServletConfig�����У����ڵ���servlet��init����ʱ��
	��ServletConfig���󴫵ݸ�servlet��	
	����������Աͨ��ServletConfig����Ϳ��Եõ���ǰservlet�ĳ�ʼ��������Ϣ��
 */
public class ServletConfigDemo1 extends HttpServlet {

	private ServletConfig config;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		//��ȡָ���ĳ�ʼ������
		String value = config.getInitParameter("xxx");
		response.getOutputStream().write(value.getBytes());
		
		//��ȡ���еĳ�ʼ������
		//Enumeration���ص���һ��������
		Enumeration e = config.getInitParameterNames();
		while(e.hasMoreElements())
		{
			String name = (String) e.nextElement();
			value = config.getInitParameter(name);
			//ע�⣺<br/>�������������ʾʱ�л���
			response.getOutputStream().write((name+"="+value+"<br/>").getBytes());
		}
		
		//�������ļ��������ַ������룬Ȼ��������ļ��л�ȡ������������
		String charset = this.config.getInitParameter("charset");
		
		//�˴��ķ�ʽ��д���ķ�ʽ
		/*String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "root";*/
		//�˴��ķ�ʽ�Ǵ������ļ��л�ȡ��Ϣ������˿����������
		String url = this.config.getInitParameter("url");
		String username = this.config.getInitParameter("username");
		String password = this.config.getInitParameter("password");
		
		System.out.println(url);		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	public void init(ServletConfig config) throws ServletException
	{
		this.config = config;
	}
}
