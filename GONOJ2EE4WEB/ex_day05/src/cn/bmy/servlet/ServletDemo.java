package cn.bmy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ���ڲ������仯�����ݣ���servlet�п���Ϊ�����ú���Ļ���ʱ��ֵ��
 * �Ա������������������������������������� *
 */
public class ServletDemo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String data = "sssssss";
		
		response.setDateHeader("expires", System.currentTimeMillis()+24*3600*1000);//�˴�������һ��
		response.getOutputStream().write(data.getBytes());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
