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

	/**test2 和 test3在此处展示了代码，但要验证放到不同类中测试
	 * 
	 * 用servletContext实现请求转发：mvc
	 * 注意：
	 * 1.转发之前的所有写入都无效，因为response在跳转之前，数据会被清除
	 * 2.转发之前，response不能提交，否则转发时候服务器会抛：
	 * Cannot forward after response has been committed
		//比如一种提交方式：调用流的close()方法
	 */
	//当要对数据进行别的处理时，请求转发就发挥了作用！
	private void test2(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		response.getOutputStream().write("1111".getBytes());
		
		ServletContext context = this.getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/servelt/ServletContextDeom3");
		rd.forward(request, response);
		
		response.getOutputStream().write("22220".getBytes());
	}

	
	/**
	 * <Context-param>标签是为整个web站点配置初始化参数
	 */
	//获取整个web站点的初始化参数
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
