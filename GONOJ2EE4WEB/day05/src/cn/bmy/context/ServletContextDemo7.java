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

	//����װ������ȡ��Դ�ļ�
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	//�ļ�̫��ֻ����servletContext
	public void test4() throws IOException
	{
		//��ȡPranavMistry_2009I_480.mp4,��������E:/��Ŀ¼��
		//��ȡ�ļ���
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
	
	//����װ������ȡ��Դ�ļ���ע��������ʺ�װ�ش��ļ�������ᵽ����jvm�ڴ����
	public void test3()
	{
		InputStream in = ServletContextDemo7.class.getClassLoader().getResourceAsStream("PranavMistry_2009I_480.mp4");
		System.out.println(in);
	}
	
	
	public void test2()
	{
		//��ȡ��·�����桢���������Դ�ļ�
		InputStream in = ServletContextDemo7.class.getResourceAsStream("cn/itcast/context/db.propertied");
		System.out.println(in);
	}
	
	private void test1() throws IOException 
	{
		//��ȡ��װ�ص�ǰ�����װ����
		ClassLoader loader = ServletContextDemo7.class.getClassLoader();
		
		//����װ����װ��db.properties�ļ�
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
