package cn.bmy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo4 extends HttpServlet {

	//子类不能抛比父类更多的异常
	int i = 1;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		synchronized (this)
		{//锁旗标 锁
			try 
			{
				Thread.sleep(1000*4);
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			response.getWriter().write(i+"");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
