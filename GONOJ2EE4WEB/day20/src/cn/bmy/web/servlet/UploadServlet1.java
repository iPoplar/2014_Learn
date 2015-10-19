package cn.bmy.web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		/**
		 * 1、上传文件名的中文乱码和上传数据的中文乱码
				upload.setHeaderEncoding("UTF-8");  //解决上传文件名的中文乱码
				//表单为文件上传，设置request编码无效,只能手工转换
				1.1 value = new String(value.getBytes("iso8859-1"),"UTF-8");
				1.2 String value = item.getString("UTF-8");
		 */		
		request.setCharacterEncoding("UTF-8");//表单为文件上传，设置request编码无效
		
		//得到上传文件的保存目录
		String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");
		
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setRepository(new File(this.getServletContext().getRealPath("/WEB-INF/temp")));
			/**
			 * 监听文件上传进度；
			 *  ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setProgressListener(new ProgressListener(){
					public void update(long pBytesRead, long pContentLength, int arg2) {
					System.out.println("文件大小为：" + pContentLength + ",当前已处理：" + pBytesRead);
				}
			});
			 */
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			//解决上传文件名的中文乱码	
			upload.setHeaderEncoding("UTF-8");
			
			if(!upload.isMultipartContent(request))
				return;//按照传统方式获取数据
			
	
			List<FileItem>list = upload.parseRequest(request);
			for(FileItem item : list)
			{
				if(item.isFormField())
				{
					//fileitem中封装的是普通输入项的数据
					String name = item.getFieldName();
					String value = item.getString("UTF-8");
					System.out.println(name+ "=" + value);
				}
				else
				{
					//fileitem 中封装的上传文件
					String filename = item.getName();//不同的浏览器提交的文件是不一样的   c:\a\b\1.txt   1.txt
					System.out.println(filename);
					if(filename==null || filename.trim().equals(""))
					{
						continue;
					}
					filename = filename.substring(filename.lastIndexOf("\\")+1);
					
					InputStream in = item.getInputStream();
					String saveFilename = makeFileName(filename);//得到文件的保存名称
					String realSavePath = makePath(saveFilename,savePath);//得到文件保存的目录
					FileOutputStream out = new FileOutputStream(realSavePath + "\\" + saveFilename);
					byte buffer[] = new byte[1024];
					int len = 0; 
					while((len=in.read(buffer))>0)
					{
						out.write(buffer, 0, len);
					}
					
					in.close();
					out.close();
					item.delete();//删除临时文件   想确保临时文件被删除，一定要在处理完上传文件后，调用item.delete方法
					
				}
				
			}
			
		} catch (FileUploadBase.FileSizeLimitExceededException e) {
			e.printStackTrace();
			request.setAttribute("message", "文件超出最大值！！！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			/*
			 * 要限制上传文件的最大值，可以通过：
				ServletFileUpload.setFileSizeMax(1024)
				方法实现，并通过捕获：
				FileUploadBase.FileSizeLimitExceededException异常以给用户友好提示
			 */
			return;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	//为防止一个目录下面出现太多文件，要使用hash算法打散存储
	private String makePath(String filename, String savePath) {
		int hashcode = filename.hashCode();
		int dir1 = hashcode&0xf; //0---15
		int dir2 = (hashcode&0xf0)>>4; //0--15
		
		String dir = savePath + "\\" + dir1 + "\\" + dir2;  //upload\2\3  upload\3\5
		File file = new File(dir);
		if(!file.exists())
		{
			file.mkdirs();//在此要注意：当要获取一级目录时，使用file.mkdir();
						  //要获取二级目录时：使用file.mkdirs();
		}

		return dir;
	}

	//为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名
	private String makeFileName(String filename) {
		return UUID.randomUUID().toString() + "_" + filename;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
