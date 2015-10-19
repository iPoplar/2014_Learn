package cn.bmy.Response;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo5 extends HttpServlet {
	/**
	 * ��ʱˢ��
	 */

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// test1(response);
		test2(response);
		// test3(request, response);has pro
	}

	private void test3(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = "<meta http-equiv='refresh' content='3;url=/day06/index.jsp>��½�ɹ��󣬽���3�����ת�����û�У����<a href=''>������</a>";
		request.setAttribute("message", message);
		this.getServletContext().getRequestDispatcher("/message.jsp").forward(
				request, response);
	}

	private void test2(HttpServletResponse response) throws IOException {
		response.setHeader("refresh", "3;url='/day06/index.jsp'");
		response.setContentType("text/html;charset=GB2312");
		String data = new Random().nextInt(100000) + "";
		response.getWriter().write("��½�ɹ�������3�����ת�����û�У����<a href=''>������</a>");
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
