package cn.bmy;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	//locationͷ��Ӧ��:Location��������ͨ�����ͷ���������������������
	public void test1(HttpServletRequest request, HttpServletResponse response)
	{
		response.setStatus(302);//��ת��ָ��ҳ��
		response.setHeader("location", "/ex_day04/1.html");
	}

	//����ѹ��
	public void test2(HttpServletRequest requset, HttpServletResponse response) throws IOException
	{
		String data = "abcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcd" +
				"abcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabc" +
				"dabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcd" +
				"abcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcda" +
				"bcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabc" +
				"dabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdab" +
				"cdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdab" +
				"cdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdab" +
				"cdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdab" +
				"cdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabc" +
				"dabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcd" +
				"abcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdab" +
				"cdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcd" +
				"abcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdab" +
				"cdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdab" +
				"cdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdab" +
				"cdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdab" +
				"cdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdab" +
				"cdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcda" +
				"bcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcd" +
				"abcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdab" +
				"cdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcda" +
				"bcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcd" +
				"abcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcd" +
				"abcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabc" +
				"dabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabc" +
				"dabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabc" +
				"dabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcd" +
				"abcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcda" +
				"bcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdab" +
				"cdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabc" +
				"dabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcd" +
				"abcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcd" +
				"abcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabc" +
				"dabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdab" +
				"cdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdab" +
				"cdabcdabcdabcdabcdabcd";
		
		System.out.println("ԭʼ���ݵĴ�СΪ��"+data.getBytes().length);
		
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		//GZIPOutputStreamͨ��write()����������ѹ������Ϊ��һ��д�������Բ�һ��д���ײ�����
		//��Ҫclose()�������õ����浽�ײ������
		//GZIPOutputStream���Դ������buffer
		GZIPOutputStream gout = new GZIPOutputStream(bout);//buffer
		gout.write(data.getBytes());
		gout.close();
		
		//�õ�ѹ���������
		byte g[] = bout.toByteArray();
		//������Ӧͷ�����������ѹ����ʽ�����ݳ��ȣ���ֹѹ���������
		response.setHeader("Content-Encoding", "gzip");
		response.setHeader("Content-Length", g.length+"");
		
		response.getOutputStream().write(g);

	}
	
	//ָ��������������
	public void test3(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		//���÷�������������������ݵ����ͣ����Ե������ļ��в鿴
		//c:\apache-tomcat-6.0.20\conf\web.xml		
		response.setHeader("content-type", "image/jpeg");
		
		InputStream in = this.getServletContext().getResourceAsStream("/1.jpg");
		byte buffer[] = new byte[1024];
		int len = 0;
		OutputStream out = response.getOutputStream();
		while((len=in.read(buffer))>0)
		{
			out.write(buffer, 0, len);
		}
	}
	
	//ָ���������ʱˢ��
	public void test4(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		response.setHeader("refresh", "3;url='http://www.sina.com'");//url�ǽ�����ת
		response.getWriter().write("abce");
	}
	
	//ָ�����������
	public void test5(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		//������Ӧͷ�����������һ���ط�ʽ�������͵�����
		response.setHeader("content-disposition", "attachment;filename=xxx.jpg");
		//��ȡ���͵�����		
		InputStream in = this.getServletContext().getResourceAsStream("/2.jpg");
		byte buffer[] = new byte[1024];
		int len = 0;
		OutputStream out = response.getOutputStream();
		while((len = in.read(buffer))>0)
		{
			out.write(buffer, 0, len);
		}
	}
		
	
}