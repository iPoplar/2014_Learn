package cn.bmy.web.servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//�г���վ���������ļ�
public class ListFileServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String filename = this.getServletContext().getRealPath("/WEB-INF/upload");
		Map map = new HashMap();
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
	
	public void listfile(File file, Map map)
	{
		if(!file.isFile())//�����ݵĹ����Ĳ����ļ�ʱ��
		{
			File files[] = file.listFiles(); 
			for(File f : files) //�ݹ����,��files�е��������ݴ洢��map��
			{
				listfile(f, map);
			}
		}
		else //�����ݵ����ļ�
		{
			String realname = file.getName().substring(file.getName().indexOf("_")+1);  //9349249849-88343-8344_��_��_��.avi
			map.put(file.getName(), realname);
		}
	}

}
