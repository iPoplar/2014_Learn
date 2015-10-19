package cn.bmy.Response;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo5 extends HttpServlet {
	/**
	 * 定时刷新
	 */

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// test1(response);
		test2(response);
		// test3(request, response);has pro
	}

	private void test3(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = "<meta http-equiv='refresh' content='3;url=/day06/index.jsp>登陆成功后，将在3秒后跳转，如果没有，请点<a href=''>超链接</a>";
		request.setAttribute("message", message);
		this.getServletContext().getRequestDispatcher("/message.jsp").forward(
				request, response);
	}

	private void test2(HttpServletResponse response) throws IOException {
		response.setHeader("refresh", "3;url='/day06/index.jsp'");
		response.setContentType("text/html;charset=GB2312");
		String data = new Random().nextInt(100000) + "";
		response.getWriter().write("登陆成功，将在3秒后跳转，如果没有，清点<a href=''>超链接</a>");
	}

	private void test1(HttpServletResponse response) throws IOException {
		response.setHeader("refresh", "3");
		String data = new Random().nextInt(100000) + "";
		response.getWriter().write(data);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
