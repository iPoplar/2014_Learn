package cn.bmy.upload;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {

	//如果表单的提交类型为multipart/form-data的话，在servlet方就不能采用传统方式获取表单数据
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		
		//为上传表单，则调用解析器上传数据
		try 
		{
			//1.得到解析器工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			
			//2.得到解析器
			ServletFileUpload upload = new ServletFileUpload(factory) ;
			
			//3.判断上传表单的类型-->??对request的深入理解
			if(!upload.isMultipartContent(request))
			{
				//上传表单为普通表单，则按照传统方式获取数据即可
				return;
			}
			
			List<FileItem> list = upload.parseRequest(request);//FileItem
			
			//遍历list，得到用于封装第一个上传输入项数据fileItem对象
			for(FileItem item : list)
			{
				if(item.isFormField())
				{
					//得到的是普通输入项
					String name = item.getFieldName();//得到输入项的名称
					String value = item.getString();
					System.out.println(name + "=" + value);
				}
				else
				{
					//得到上传输入项
					String filename = item.getName();//得到上传文件名
					filename = filename.substring(filename.lastIndexOf("\\"+1));
					InputStream in = item.getInputStream();//得到上传数据
					int len = 0;
					byte buffer[] = new byte[1024];
					
					//用于保存上传文件的目录应该禁止外界直接访问
					String savepath = this.getServletContext().getRealPath("/WEB-INF/upload");
					
					FileOutputStream out = new FileOutputStream(savepath + "\\" + filename);//向upload目录中写入文件
					while((len=in.read(buffer))>0)
					{
						out.write(buffer, 0, len);
					}
					
					in.close();
					out.close();
					
					
					
				}
			}
		} catch (FileUploadException e) 
		{
			e.printStackTrace();
		}	
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
