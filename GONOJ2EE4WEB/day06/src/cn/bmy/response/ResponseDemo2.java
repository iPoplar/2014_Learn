package cn.bmy.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		test1(response);
		test2(response);	
	}

	private void test2(HttpServletResponse response) throws IOException {
		String data = "�й�w";
		//�þ����ȼ����������
		response.setContentType("text/html;charset=GB2312");
		//response.setCharacterEncoding("GB2312");
		//response.setHeader("Content-type", "text/html;charset=ISO-8859-1");
		PrintWriter out = response.getWriter();
		out.write(data);
	}

	private void test1(HttpServletResponse response) throws IOException
	{
		String data = "�й�q";
		//����responseʹ�õ�����Կ���response��ʲô�����������������ݣ�Ĭ��ΪISO-8859-1
		response.setCharacterEncoding("GB2312");
		//ָ���������ʲô���򿪷��������͵�����
		response.setHeader("Content-type", "text/html;charset=GB2312");
		//response.setHeader("Content-type", "text/html;charset=ISO-8859-1");
		PrintWriter out = response.getWriter();
		out.write(data);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
