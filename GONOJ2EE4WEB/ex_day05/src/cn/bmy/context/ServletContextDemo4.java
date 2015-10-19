package cn.bmy.context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 资源文件：property	：简单的
 * 			xml：复杂的
 */
//使用servletContext读取资源文件
public class ServletContextDemo4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//test1();
		//test2();
		//test3();
		//test4();
	}
	
	//test1、2、3是在资源在类路径下
	private void test1() throws FileNotFoundException
	{
		//做工程时，不建议采用传统方式读取文件数据
		FileInputStream in = new FileInputStream("db.properties");
		System.out.println(in);
	}
	
	//读取web工程中资源文件的模板代码
	private void test2() throws IOException
	{
		//路径：是Tomcat的启动目录，相对于jvm的bin运行目录，并不是src
		InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
		Properties prop = new Properties();
		prop.load(in);//加载数据封装到prop对象中去
		
		String driver = prop.getProperty("driver");//提取数据
		String url = prop.getProperty("url");
		
		System.out.println(driver);		
	}

		private void test3() throws IOException
	{
		//获取web资源的绝对路径
		String path = this.getServletContext().getRealPath("/WEB-INF/classes/db.properties");
		FileInputStream in = new FileInputStream(path);
		
		Properties prop = new Properties();
		prop.load(in);
		
		String driver = prop.getProperty("driver");
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		
		System.out.println(driver);
	}
	
	//读取web下的资源时，要想到ServletContext
	//读取webroot目录下的资源
	private void test4() throws IOException
	{
		
		InputStream in = this.getServletContext().getResourceAsStream("/db.properties");
		System.out.println(in);
	}
	
	/**文件太大，只能用servletContext
	 * 
	 *  用类装载器装载db.properties文件
	 * @throws IOException 
	 */
	private void test5() throws IOException
	{
		//获取到当前类的类装载器
		//其中：ServletContextDemo4.class是获取此类的字节码 到内存中
		//类的字节码只能装载一次
		//ServletContextDemo4.class.getClassLoaser()是获得类的类装载器
		ClassLoader loader = ServletContextDemo4.class.getClassLoader();
		
		//用类装载器装载db.properties文件
		InputStream in = loader.getResourceAsStream("db.properties");
		Properties prop = new Properties();
		prop.load(in);
		
		String driver = prop.getProperty("driver");
		String url = prop.getProperty("url");
		String username = prop.getProperty("password");
		
		System.out.println(driver);
	}
	
	//读取类路径下面、下面的资源文件
	public void test6()
	{
		InputStream in = ServletContextDemo4.class.getClassLoader().getResourceAsStream("cn/bmy/context/db.properties");
		System.out.println(in);
	}
	
	//通过类装载器读取资源文件的注意事项：不适合装载大文件，否则会导致jvm内存溢出
	public void test7()
	{
		InputStream in = ServletContextDemo4.class.getClassLoader().getResourceAsStream("1.mp4");
		System.out.println(in);
	}
	
	//文件太大，只能用servletContext
	public void text8() throws IOException
	{
		//读取1.mp4，并拷贝到e:\根目录下
		//path=c:\asdf\adsd\add\1.mp4
		//path=1.mp4
		////获取文件名
		String path = this.getServletContext().getRealPath("/WEB-INF/classes/1.mp4");
		String filename = path.substring(path.lastIndexOf("\\")+1);
		
		InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/1.mp4");
		byte buffer[] = new byte[1024];//定义缓存
		int len = 0; 
		
		FileOutputStream out = new FileOutputStream("e:\\"+filename);
		while((len=in.read(buffer))>0)
		{
			out.write(buffer,0,len);
		}
		
		out.close();
		in.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
