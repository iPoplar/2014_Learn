package cn.bmy.form;

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

//负责产生表单
public class FormServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//得到随机数
		String token = TokenProccessor.getInstance().makeToken();	
		//在服务器端保存随机数
		request.getSession().setAttribute("token", token);
		
		out.println("<form action'/ex_day07/servlet/DoFormServlet' method='post'>");
		//通过一个隐藏字段，将一个随机数带给服务器
		//这个随机数name='token', 专业名称叫：令牌
		out.write("<input type='hidden' name='token' value='"+token+"'>");
		
		out.println("用户名：<input type='text' name='username'>");
		out.println("<input type='submit' name='提交'>");
		out.println("</form>");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
//随机数生成器
class TokenProccessor//所有随机数由一个对象产生，所以设计成单态模式
{
	/**
	 * 单态设计模式（保证类的对象在内存中只有一个）
	 * 1、把类的构造函数私有
	 * 2、自己创建一个类的对象
	 * 3、对外提供一个公共的方法，返回类的对象
	 * */
	
	private TokenProccessor(){}
	
	private static final TokenProccessor instance = new TokenProccessor();
	
	public static TokenProccessor getInstance()
	{
		return instance;
	}
	
	public String makeToken() 
	{
		String token = (System.currentTimeMillis()+ new Random().nextInt(999999)+"");
		
		//数据指纹  所有数据指纹都是128位长----通过MD5算法可得
		//(此处只有用了md5算法保证了随机数的长度)
		try 
		{//此处的代码不能抛出，抛出无法解决，没有任何意义
			//抛出 是 checkException
			MessageDigest md = MessageDigest.getInstance("md5");
			byte md5[] = md.digest(token.getBytes());
			
			//base64编码----将任意二进制编码明文字符
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(md5);
			
		} catch (NoSuchAlgorithmException e)
		{//不能打印，要往上抛通知上层代码  进行运行时异常
			throw new RuntimeException(e);
		}
		/*
		 * 一般出了异常，要往上抛，进行运行时异常；
		 *当希望处理这个异常时，进行编译时异常 
		 */
	}
}
/**	base64编码 ---就是将3字节变4字节
 * 		----将任意二进制编码明文字符（键盘上可见字符）
 */
