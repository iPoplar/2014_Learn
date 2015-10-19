package cn.bmy.context;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextDemo7 extends HttpServlet {

	//用类装载器读取资源文件
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	//文件太大，只能用servletContext
	public void test4() throws IOException
	{
		//读取PranavMistry_2009I_480.mp4,并拷贝到E:/根目录下
		//获取文件名
		String path = this.getServletContext().getRealPath("/WEB-INF/classes/PranavMistry_2009I_480.mp4");
		String filename = path.substring(path.lastIndexOf("\\" + 1));
		
		InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/PranavMistry_2009I_480.mp4");
		byte buffer[] = new byte[1024];
		int len  = 0; 
		FileOutputStream out = new FileOutputStream("e:\\" + filename);
		while((len = in.read(buffer))>0)
		{
			out.write(buffer, 0, len);
		}
		
		out.close();
		in.close();
		
		
	}
	
	//用类装载器读取资源文件的注意事项：不适合装载大文件，否则会到导致jvm内存溢出
	public void test3()
	{
		InputStream in = ServletContextDemo7.class.getClassLoader().getResourceAsStream("PranavMistry_2009I_480.mp4");
		System.out.println(in);
	}
	
	
	public void test2()
	{
		//读取类路径下面、包下面的资源文件
		InputStream in = ServletContextDemo7.class.getResourceAsStream("cn/itcast/context/db.propertied");
		System.out.println(in);
	}
	
	private void test1() throws IOException 
	{
		//获取到装载当前类的类装载器
		ClassLoader loader = ServletContextDemo7.class.getClassLoader();
		
		//用类装载器装载db.properties文件
		InputStream in = loader.getResourceAsStream("db.properties");
		Properties prop = new Properties();
		prop.load(in);
		
		String driver = prop.getProperty("driver");
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		System.out.println(driver);
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
