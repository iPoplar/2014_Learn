package cn.bmy.response;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *在servlet用getOutputStream输出中文问题 *
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
		//用字符流输出数据
		String data = "中国";
		
		//通知浏览器以utf-8打开
		//法1   response.setHead("Content-type","text/html;chartset=UTF-8");
		//法2	response.setContentType("text/html;charset=UTF-8");	
	
		//通知浏览器以utf-8输出
		//与法1连用 response.setCharacterEncoding("UTF-8"); 	//与法1连用就相当于法2的那一句
		PrintWriter out = response.getWriter();
		out.write(data);
	}


	private void test2(HttpServletResponse response) throws IOException 
	{
		String data="中国2";
		//html:<meta>标签模拟一个http响应头
		OutputStream out = response.getOutputStream();
		//out.write(data.getBytes());
		out.write("<meta http-equiv='content-type'content='text/html;charset=UTF-8'>".getBytes());
	}
	


	private void test1(HttpServletResponse response) throws IOException,
			UnsupportedEncodingException 
	{
		String data = "中国";
		//程序以什么码表输出，一定要控制浏览器以什么码表打开
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
