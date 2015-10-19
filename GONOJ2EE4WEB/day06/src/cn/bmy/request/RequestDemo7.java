package cn.bmy.request;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * mvc :�ص��е��ص�
 *
 */
public class RequestDemo7 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String data = "asbc";
		request.setAttribute("data", data);
		
		//ת��1��
		//this.getServletContext().getRequestDispatcher("/test.jsp").forward(request, response);
		
		//ת��2��
		RequestDispatcher rq = this.getServletContext().getRequestDispatcher("/test.jsp");
		rq.forward(request, response);
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
