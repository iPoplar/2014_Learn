package cn.bmy.Response;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//�ַ����ֽ�ת��ʱҪ������
//�ֽ������Դ����κ����ݣ����ַ���ֻ�ܴ����ı�������ַ��������ֽ����ݣ��ᵼ�����ݶ�ʧ
public class ResponseDemo3 extends HttpServlet {

	/**
	 * ͨ��responseʵ���ļ�����
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		//test1(response);
		test2(response);
		
	}


	private void test2(HttpServletResponse response)
			throws IOException 
	{
		String path = this.getServletContext().getRealPath("/download/ʷŬ��.jpg");
		String filename = path.substring(path.lastIndexOf("\\")+1);
		
		InputStream in = null;
		OutputStream out = null;
		//������d�ļ��������ļ����t�ļ�����Ҫ���^url���a
		//��Ӧͷ�ı�����ASC�룬ͨ��URLEncoding����Խ�����ת��ASC��
		response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode(filename,"UTF-8"));
		try
		{
			in = new FileInputStream(path);
			int len = 0;
			byte buffer[] = new byte[1024];
			out = response.getOutputStream();
			
			while((len=in.read(buffer))>0)
			{
				out.write(buffer, 0, len);
			}

		}finally
		{
			if(in != null)
			{
				try
				{				
					in.close();
				}catch(Exception e){
					e.printStackTrace();
				}

			}			
		}
	}
	

	private void test1(HttpServletResponse response)
			throws FileNotFoundException, IOException
	{
		String path = this.getServletContext().getRealPath("/download/aa.jpg");
		String filename = path.substring(path.lastIndexOf("\\")+1);
		
		InputStream in = null;
		OutputStream out = null;
		response.setHeader("content-disposition", "attachment;filename="+filename);
		
		try
		{
			in = new FileInputStream(path);
			int len = 0;
			byte buffer[] = new byte[1024];
			out = response.getOutputStream();
			while((len=in.read(buffer))>0)
			{
				out.write(buffer, 0, len);
			}

		}finally
		{
			if(in != null)
			{
				try
				{				
					in.close();
				}catch(Exception e){
					e.printStackTrace();
				}
		//response�Ĵݻ�ͬʱҲ�ر�����ص���
			}			
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
