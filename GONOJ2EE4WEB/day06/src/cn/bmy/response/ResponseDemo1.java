package cn.bmy.response;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *��servlet��getOutputStream����������� *
 */
public class ResponseDemo1 extends HttpServlet 
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		//test1(response);
		test2(response);
	}
	

	private void test3(HttpServletResponse response) throws IOException 
	{
		//���ַ����������
		String data = "�й�";
		
		//֪ͨ�������utf-8��
		//��1   response.setHead("Content-type","text/html;chartset=UTF-8");
		//��2	response.setContentType("text/html;charset=UTF-8");	
	
		//֪ͨ�������utf-8���
		//�뷨1���� response.setCharacterEncoding("UTF-8"); 	//�뷨1���þ��൱�ڷ�2����һ��
		PrintWriter out = response.getWriter();
		out.write(data);
	}


	private void test2(HttpServletResponse response) throws IOException 
	{
		String data="�й�2";
		//html:<meta>��ǩģ��һ��http��Ӧͷ
		OutputStream out = response.getOutputStream();
		//out.write(data.getBytes());
		out.write("<meta http-equiv='content-type'content='text/html;charset=UTF-8'>".getBytes());
	}
	


	private void test1(HttpServletResponse response) throws IOException,
			UnsupportedEncodingException 
	{
		String data = "�й�";
		//������ʲô��������һ��Ҫ�����������ʲô����
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		OutputStream out = response.getOutputStream();
		//out.write(data.getBytes());
		out.write(data.getBytes("UTF-8"));
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
