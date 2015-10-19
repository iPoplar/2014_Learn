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
 * 负责产生表单
 */
public class FormServlet extends HttpServlet 
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String token = TokenProccessor.getInstance().makeToken();
		//在服务器端保存随机数
		request.getSession().setAttribute("token", token);
		out.println("<form action='/day07/servlet/DoFormServlet' method='post'>");
		//隐藏字段，带一个随机数（令牌）
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
	 * 单态设计模式（保证类的对象在内存中只有一个）
	 * 1.把类的构造函数私有
	 * 2.自己创建一个类的对象
	 * 3.对外提供一个公共的方法，返回类的对象
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
		//数据指纹
		try 
		{
			//使用md5算法
			MessageDigest md = MessageDigest.getInstance("md5");
			byte md5[] = md.digest(token.getBytes());
			//base64编码--任意二进制编码明文字符
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(md5);
		} catch (NoSuchAlgorithmException e)		
		{
			throw new RuntimeException(e);
		}
		
	}
	
}
