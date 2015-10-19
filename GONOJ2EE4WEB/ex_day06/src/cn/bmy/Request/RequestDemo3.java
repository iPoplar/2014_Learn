package cn.bmy.Request;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		//只要是写地址，请统统以/开发
		//"/"是给服务器用的，则代表web工程，"/"是给浏览器用的，则代表webqpps
		//程序处理的是URL资源，用"/"，程序读取硬盘资源，用"\\"
		
		//servletContext
		this.getServletContext().getRealPath("/download/11.jpg");
		
		
		//forward
		this.getServletContext().getRequestDispatcher("/register.html");
		
		//sendRedirct
		response.sendRedirect("/day06/register.html");
		
		//html <a href=""></a> 给浏览器用的
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
	
	private void test1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		/*
		mvc的重点：
		客户端的数据处理交给servlet，用户显示交给jsp，
		数据是jsp交给request域，servlet从request域中获取的；
	*/
	
		String data = "asbc";
		request.setAttribute("data", data);
		
		//转发1；
		//this.getServletContext().getRequestDispatcher("/test.jsp").forward(request, response);
		
		//转发2：
		RequestDispatcher rq = this.getServletContext().getRequestDispatcher("/test.jsp");
		rq.forward(request, response);
		
		//这两种转发均可
	}

}
