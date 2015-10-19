package cn.bmy.context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextDemo6 extends HttpServlet {

	//ʹ��servletContext��ȡ��Դ�ļ�
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	
	private void test4()
	{
		//��ȡwebrootĿ¼�µ���Դ
		InputStream in = this.getServletContext().getResourceAsStream("/db.properties");
		System.out.println(in);
	}
	
	
	public void test3() throws IOException
	{
		//��ȡweb��Դ�еľ���·��
		String path = this.getServletContext().getRealPath("/WEB-INF/classes/db.properties");
		FileInputStream in = new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(in);
		
		String driver = prop.getProperty("driver");
		
		System.out.println(driver);

	}
	
	//**��ȡweb��������Դ��ģ�����
	public void test2() throws IOException
	{
		InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
		Properties prop = new Properties();
		prop.load(in);
		
		String driver = prop.getProperty("driver");
		String url = prop.getProperty("url");
		

		System.out.println(driver);
		
	}
	
	public void test1() throws FileNotFoundException
	{//��web����ʱ����������ô�ͳ��ʽ��ȡ�ļ�����
		FileInputStream in = new FileInputStream("db.properties");
		
		System.out.println(in);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
