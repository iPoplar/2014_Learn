package cn.bmy.Request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
�ύ���������������⣺
1.����ύ��ʽΪpost���벻���룬ֻ������request����ı��뼴��
	ע�⣺�ͻ����������ֱ����ύ�ģ�request��Ӧ����ʲô����

2.����ύ��ʽΪget������request����ı�������Ч�ģ�
�û��벻���룬ֻ���ֹ�ת��
	String data = "?????"; 	//�����ַ�
	byte source[] = data.getBytes("iso8859-1");//�õ��ͻ�����ԭʼ����
	data = new String(source,"UTF-8");	//�������
	
	//��ͬ��
	
	data = new String(data.getBytes("iso8859-1"),"UTF-8");
	
3.get��ʽ������,������ͨ���ı������������ʵ��
		3.1<Connector post="8080" protocol="HTTP/1.1"
				connectionTimeout="20000" 
				redirectPort="8443"		URIEncoding="UTF-8"/>
		
		3.2<Connector post="8080" protocol="HTTP/1.1"
				connectionTimeout="20000"
				redirectPort="8443" useBodyEncodignForURI="true"/>
				
*/
public class RequestDemo2 extends HttpServlet {

	
	//��������֤
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");//get��ʽ�ύ��request���ñ�����Ч
		
		String username = request.getParameter("username");
		System.out.println(username);
		
		byte source[] = username.getBytes("iso8859-1");
		username = new String(source,"UTF-8");
		System.out.println(username);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
