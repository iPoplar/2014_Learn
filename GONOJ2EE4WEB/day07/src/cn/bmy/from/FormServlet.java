package cn.bmy.from;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;
/**
 * ���������
 */
public class FormServlet extends HttpServlet 
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String token = TokenProccessor.getInstance().makeToken();
		//�ڷ������˱��������
		request.getSession().setAttribute("token", token);
		out.println("<form action='/day07/servlet/DoFormServlet' method='post'>");
		//�����ֶΣ���һ������������ƣ�
		out.write("<input type='hidden' name='token' value='"+token+"'>");
		out.println("</form>");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

class TokenProccessor
{
	/*
	 * ��̬���ģʽ����֤��Ķ������ڴ���ֻ��һ����
	 * 1.����Ĺ��캯��˽��
	 * 2.�Լ�����һ����Ķ���
	 * 3.�����ṩһ�������ķ�����������Ķ���
	 */
	private TokenProccessor()
	{}
	
	private static final TokenProccessor instance = new TokenProccessor();
	
	public static TokenProccessor getInstance()
	{
		return instance;
	}
	
	public String makeToken()
	{
		String token = (System.currentTimeMillis() + new Random().nextInt(9999999)+"");
		//����ָ��
		try 
		{
			//ʹ��md5�㷨
			MessageDigest md = MessageDigest.getInstance("md5");
			byte md5[] = md.digest(token.getBytes());
			//base64����--��������Ʊ��������ַ�
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(md5);
		} catch (NoSuchAlgorithmException e)		
		{
			throw new RuntimeException(e);
		}
		
	}
	
}
