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
		 * 1���ϴ��ļ���������������ϴ����ݵ���������
				upload.setHeaderEncoding("UTF-8");  //����ϴ��ļ�������������
				//��Ϊ�ļ��ϴ�������request������Ч,ֻ���ֹ�ת��
				1.1 value = new String(value.getBytes("iso8859-1"),"UTF-8");
				1.2 String value = item.getString("UTF-8");
		 */		
		request.setCharacterEncoding("UTF-8");//��Ϊ�ļ��ϴ�������request������Ч
		
		//�õ��ϴ��ļ��ı���Ŀ¼
		String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");
		
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setRepository(new File(this.getServletContext().getRealPath("/WEB-INF/temp")));
			/**
			 * �����ļ��ϴ����ȣ�
			 *  ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setProgressListener(new ProgressListener(){
					public void update(long pBytesRead, long pContentLength, int arg2) {
					System.out.println("�ļ���СΪ��" + pContentLength + ",��ǰ�Ѵ���" + pBytesRead);
				}
			});
			 */
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			//����ϴ��ļ�������������	
			upload.setHeaderEncoding("UTF-8");
			
			if(!upload.isMultipartContent(request))
				return;//���մ�ͳ��ʽ��ȡ����
			
	
			List<FileItem>list = upload.parseRequest(request);
			for(FileItem item : list)
			{
				if(item.isFormField())
				{
					//fileitem�з�װ������ͨ�����������
					String name = item.getFieldName();
					String value = item.getString("UTF-8");
					System.out.println(name+ "=" + value);
				}
				else
				{
					//fileitem �з�װ���ϴ��ļ�
					String filename = item.getName();//��ͬ��������ύ���ļ��ǲ�һ����   c:\a\b\1.txt   1.txt
					System.out.println(filename);
					if(filename==null || filename.trim().equals(""))
					{
						continue;
					}
					filename = filename.substring(filename.lastIndexOf("\\")+1);
					
					InputStream in = item.getInputStream();
					String saveFilename = makeFileName(filename);//�õ��ļ��ı�������
					String realSavePath = makePath(saveFilename,savePath);//�õ��ļ������Ŀ¼
					FileOutputStream out = new FileOutputStream(realSavePath + "\\" + saveFilename);
					byte buffer[] = new byte[1024];
					int len = 0; 
					while((len=in.read(buffer))>0)
					{
						out.write(buffer, 0, len);
					}
					
					in.close();
					out.close();
					item.delete();//ɾ����ʱ�ļ�   ��ȷ����ʱ�ļ���ɾ����һ��Ҫ�ڴ������ϴ��ļ��󣬵���item.delete����
					
				}
				
			}
			
		} catch (FileUploadBase.FileSizeLimitExceededException e) {
			e.printStackTrace();
			request.setAttribute("message", "�ļ��������ֵ������");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			/*
			 * Ҫ�����ϴ��ļ������ֵ������ͨ����
				ServletFileUpload.setFileSizeMax(1024)
				����ʵ�֣���ͨ������
				FileUploadBase.FileSizeLimitExceededException�쳣�Ը��û��Ѻ���ʾ
			 */
			return;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	//Ϊ��ֹһ��Ŀ¼�������̫���ļ���Ҫʹ��hash�㷨��ɢ�洢
	private String makePath(String filename, String savePath) {
		int hashcode = filename.hashCode();
		int dir1 = hashcode&0xf; //0---15
		int dir2 = (hashcode&0xf0)>>4; //0--15
		
		String dir = savePath + "\\" + dir1 + "\\" + dir2;  //upload\2\3  upload\3\5
		File file = new File(dir);
		if(!file.exists())
		{
			file.mkdirs();//�ڴ�Ҫע�⣺��Ҫ��ȡһ��Ŀ¼ʱ��ʹ��file.mkdir();
						  //Ҫ��ȡ����Ŀ¼ʱ��ʹ��file.mkdirs();
		}

		return dir;
	}

	//Ϊ��ֹ�ļ����ǵ���������ҪΪ�ϴ��ļ�����һ��Ψһ���ļ���
	private String makeFileName(String filename) {
		return UUID.randomUUID().toString() + "_" + filename;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
