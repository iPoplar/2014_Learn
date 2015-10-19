package cn.bmy.Request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
提交数据中文乱码问题：
1.如果提交方式为post，想不乱码，只需设置request对象的编码即可
	注意：客户机是以哪种编码提交的，request就应设置什么编码

2.如果提交方式为get，设置request对象的编码是无效的，
用户想不乱码，只能手工转换
	String data = "?????"; 	//乱码字符
	byte source[] = data.getBytes("iso8859-1");//得到客户机的原始数据
	data = new String(source,"UTF-8");	//解决乱码
	
	//等同于
	
	data = new String(data.getBytes("iso8859-1"),"UTF-8");
	
3.get方式的乱码,还可以通过改变服务器的配置实现
		3.1<Connector post="8080" protocol="HTTP/1.1"
				connectionTimeout="20000" 
				redirectPort="8443"		URIEncoding="UTF-8"/>
		
		3.2<Connector post="8080" protocol="HTTP/1.1"
				connectionTimeout="20000"
				redirectPort="8443" useBodyEncodignForURI="true"/>
				
*/
public class RequestDemo2 extends HttpServlet {

	
	//举例和验证
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		request.setCharacterEncoding("UTF-8");//get方式提交，request设置编码无效
		
		String username = request.getParameter("username");
		System.out.println(username);
		
		byte source[] = username.getBytes("iso8859-1");
		username = new String(source,"UTF-8");
		System.out.println(username);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
