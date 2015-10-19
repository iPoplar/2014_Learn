package cn.bmy.config;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**在Servlet的配置文件中，可以使用一个或多个<init-param>标签为servlet配置一些初始化参数。

	当servlet配置了初始化参数后，web容器在创建servlet实例对象时，
	会自动将这些初始化参数封装到ServletConfig对象中，并在调用servlet的init方法时，
	将ServletConfig对象传递给servlet。	
	进而，程序员通过ServletConfig对象就可以得到当前servlet的初始化参数信息。
 */
public class ServletConfigDemo1 extends HttpServlet {

	private ServletConfig config;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		//获取指定的初始化参数
		String value = config.getInitParameter("xxx");
		response.getOutputStream().write(value.getBytes());
		
		//获取所有的初始化参数
		//Enumeration返回的是一个迭代器
		Enumeration e = config.getInitParameterNames();
		while(e.hasMoreElements())
		{
			String name = (String) e.nextElement();
			value = config.getInitParameter(name);
			//注意：<br/>是在浏览器中显示时有换行
			response.getOutputStream().write((name+"="+value+"<br/>").getBytes());
		}
		
		//在配置文件中配置字符集编码，然后从配置文件中获取，提高了灵活性
		String charset = this.config.getInitParameter("charset");
		
		//此处的方式是写死的方式
		/*String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "root";*/
		//此处的方式是从配置文件中获取信息，提高了开发的灵活性
		String url = this.config.getInitParameter("url");
		String username = this.config.getInitParameter("username");
		String password = this.config.getInitParameter("password");
		
		System.out.println(url);		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	public void init(ServletConfig config) throws ServletException
	{
		this.config = config;
	}
}
