package cn.bmy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo4 extends HttpServlet {

	//���಻���ױȸ��������쳣
	int i = 1;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		synchronized (this)
		{//����� ��
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
