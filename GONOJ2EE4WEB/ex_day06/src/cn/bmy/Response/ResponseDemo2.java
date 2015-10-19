package cn.bmy.Response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		test1(response);
		test2(response);	
	}

	private void test2(HttpServletResponse response) throws IOException 
	{
		String data = "中國q";
		//設置response使用的码表，以控制response以什么码表向浏览器输入数据，默认为
		//ISO-8859-1
		response.setCharacterEncoding("GB2312");
		//指定浏览器以什么码表打开服务器发送数据
		response.setHeader("Cotent-type", "text/html;charset=GB2312");
		PrintWriter out = response.getWriter();
		out.write(data);
		
	}

	private void test1(HttpServletResponse response) throws IOException
	{
		String data = "中国w";
		//该句代码等价其后两句
		response.setContentType("text/html;charset=GB2312");
		//response.setCharacterEncoding("GB2312");
		//response.setHeader("Content-type", "text/html;charset=ISO-8859-1");
		PrintWriter out = response.getWriter();
		out.write(data);
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
