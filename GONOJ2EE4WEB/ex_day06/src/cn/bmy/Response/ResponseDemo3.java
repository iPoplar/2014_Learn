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

//字符向字节转化时要查码表的
//字节流可以处理任何数据，但字符流只能处理文本，如果字符流处理字节数据，会导致数据丢失
public class ResponseDemo3 extends HttpServlet {

	/**
	 * 通过response实现文件下载
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
		String path = this.getServletContext().getRealPath("/download/史努比.jpg");
		String filename = path.substring(path.lastIndexOf("\\")+1);
		
		InputStream in = null;
		OutputStream out = null;
		//如果下載文件是中文文件，則文件名需要經過url編碼
		//响应头的编码是ASC码，通过URLEncoding类可以将编码转成ASC码
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
		//response的摧毁同时也关闭了相关的流
			}			
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
