package cn.bmy.web.servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//列出网站所有下载文件
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
		if(!file.isFile())//当传递的过来的不是文件时，
		{
			File files[] = file.listFiles(); 
			for(File f : files) //递归调用,将files中的所有内容存储到map中
			{
				listfile(f, map);
			}
		}
		else //当传递的是文件
		{
			String realname = file.getName().substring(file.getName().indexOf("_")+1);  //9349249849-88343-8344_阿_凡_达.avi
			map.put(file.getName(), realname);
		}
	}

}
