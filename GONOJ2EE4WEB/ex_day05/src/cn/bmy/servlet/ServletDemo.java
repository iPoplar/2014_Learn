package cn.bmy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 对于不经常变化的数据，在servlet中可以为其设置合理的缓存时间值，
 * 以避免浏览器向服务器发送请求，提升服务器性能 *
 */
public class ServletDemo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String data = "sssssss";
		
		response.setDateHeader("expires", System.currentTimeMillis()+24*3600*1000);//此处设置了一天
		response.getOutputStream().write(data.getBytes());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
