package cn.bmy.context;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ServletContextDemo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		//test1();
		//test2(request, response);
		//test3(response);
		
		
	}

	private void test3(HttpServletResponse response) throws IOException {
		response.getOutputStream().write("servletDemo3".getBytes());
	}

	/**test2 �� test3�ڴ˴�չʾ�˴��룬��Ҫ��֤�ŵ���ͬ���в���
	 * 
	 * ��servletContextʵ������ת����mvc
	 * ע�⣺
	 * 1.ת��֮ǰ������д�붼��Ч����Ϊresponse����ת֮ǰ�����ݻᱻ���
	 * 2.ת��֮ǰ��response�����ύ������ת��ʱ����������ף�
	 * Cannot forward after response has been committed
		//����һ���ύ��ʽ����������close()����
	 */
	//��Ҫ�����ݽ��б�Ĵ���ʱ������ת���ͷ��������ã�
	private void test2(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		response.getOutputStream().write("1111".getBytes());
		
		ServletContext context = this.getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/servelt/ServletContextDeom3");
		rd.forward(request, response);
		
		response.getOutputStream().write("22220".getBytes());
	}

	
	/**
	 * <Context-param>��ǩ��Ϊ����webվ�����ó�ʼ������
	 */
	//��ȡ����webվ��ĳ�ʼ������
	private void test1() {
		ServletContext context = this.getServletContext();
		String url = context.getInitParameter("url");
		System.out.println(url);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
