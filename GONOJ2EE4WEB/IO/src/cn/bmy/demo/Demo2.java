package cn.bmy.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class Demo2 
{
	/**
	 * 关于文件的复制粘贴
	 */
	@Test
	private static void test1() {
		try 
		{
			//创建输入流
			FileInputStream in = new FileInputStream("xiao.txt");
			//创建输出流
			FileOutputStream out = new FileOutputStream("F:/BabyComeOn.txt");
			//一边读，一边写
			byte[] bytes = new byte[1024];
			int temp = 0;
			while((temp=in.read(bytes))!=-1)
			{
				//将byte数组中的内容直接写入
				out.write(bytes, 0, temp);
			}
		
			//刷新
			out.flush();
			
			//关闭
			in.close();
			out.close();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Test
	public static void test2()
	{
		/**
		 * java.io.Writer;
		 * 		java.io.OutputStreamWriter;转换流（字节输出流---->字符输出流）
		 * 				java.io.FileWriter;文件字符输出流
		 */
		try 
		{
			//创建文件字符输出流
			//FileWriter fw = new FileWriter("xiao.txt");//覆盖
			FileWriter fw = new FileWriter("xiao.txt",true);//追加
			
			//开始写
			fw.write("孩子，no one can help you ,just yourself!!!");
			
			//将char数组的一部分写入
			char[] chars = {'相','信','有','奇','迹'};
			
			fw.write(chars, 0, 5);
			
			fw.flush();
			
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		//test1();
		test2();
	}
		
}
