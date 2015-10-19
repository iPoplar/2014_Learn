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
 * ��Դ�ļ���property	���򵥵�
 * 			xml�����ӵ�
 */
//ʹ��servletContext��ȡ��Դ�ļ�
public class ServletContextDemo4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//test1();
		//test2();
		//test3();
		//test4();
	}
	
	//test1��2��3������Դ����·����
	private void test1() throws FileNotFoundException
	{
		//������ʱ����������ô�ͳ��ʽ��ȡ�ļ�����
		FileInputStream in = new FileInputStream("db.properties");
		System.out.println(in);
	}
	
	//��ȡweb��������Դ�ļ���ģ�����
	private void test2() throws IOException
	{
		//·������Tomcat������Ŀ¼�������jvm��bin����Ŀ¼��������src
		InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
		Properties prop = new Properties();
		prop.load(in);//�������ݷ�װ��prop������ȥ
		
		String driver = prop.getProperty("driver");//��ȡ����
		String url = prop.getProperty("url");
		
		System.out.println(driver);		
	}

		private void test3() throws IOException
	{
		//��ȡweb��Դ�ľ���·��
		String path = this.getServletContext().getRealPath("/WEB-INF/classes/db.properties");
		FileInputStream in = new FileInputStream(path);
		
		Properties prop = new Properties();
		prop.load(in);
		
		String driver = prop.getProperty("driver");
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		
		System.out.println(driver);
	}
	
	//��ȡweb�µ���Դʱ��Ҫ�뵽ServletContext
	//��ȡwebrootĿ¼�µ���Դ
	private void test4() throws IOException
	{
		
		InputStream in = this.getServletContext().getResourceAsStream("/db.properties");
		System.out.println(in);
	}
	
	/**�ļ�̫��ֻ����servletContext
	 * 
	 *  ����װ����װ��db.properties�ļ�
	 * @throws IOException 
	 */
	private void test5() throws IOException
	{
		//��ȡ����ǰ�����װ����
		//���У�ServletContextDemo4.class�ǻ�ȡ������ֽ��� ���ڴ���
		//����ֽ���ֻ��װ��һ��
		//ServletContextDemo4.class.getClassLoaser()�ǻ�������װ����
		ClassLoader loader = ServletContextDemo4.class.getClassLoader();
		
		//����װ����װ��db.properties�ļ�
		InputStream in = loader.getResourceAsStream("db.properties");
		Properties prop = new Properties();
		prop.load(in);
		
		String driver = prop.getProperty("driver");
		String url = prop.getProperty("url");
		String username = prop.getProperty("password");
		
		System.out.println(driver);
	}
	
	//��ȡ��·�����桢�������Դ�ļ�
	public void test6()
	{
		InputStream in = ServletContextDemo4.class.getClassLoader().getResourceAsStream("cn/bmy/context/db.properties");
		System.out.println(in);
	}
	
	//ͨ����װ������ȡ��Դ�ļ���ע��������ʺ�װ�ش��ļ�������ᵼ��jvm�ڴ����
	public void test7()
	{
		InputStream in = ServletContextDemo4.class.getClassLoader().getResourceAsStream("1.mp4");
		System.out.println(in);
	}
	
	//�ļ�̫��ֻ����servletContext
	public void text8() throws IOException
	{
		//��ȡ1.mp4����������e:\��Ŀ¼��
		//path=c:\asdf\adsd\add\1.mp4
		//path=1.mp4
		////��ȡ�ļ���
		String path = this.getServletContext().getRealPath("/WEB-INF/classes/1.mp4");
		String filename = path.substring(path.lastIndexOf("\\")+1);
		
		InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/1.mp4");
		byte buffer[] = new byte[1024];//���建��
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
