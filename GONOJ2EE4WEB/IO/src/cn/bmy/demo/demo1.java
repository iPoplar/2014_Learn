package cn.bmy.demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class demo1 
{
	public static void main(String[] args) 
	{
		FileOutputStream fs = null;
		try 
		{
			//以追加的方式写入
			fs = new FileOutputStream("xiao",true);
			//开始写
			String read = "Fighting";
			//将string转换成byte数组
			byte[] bytes = read.getBytes();
			//将byte数组中的所有方式全部写入
			//fs.write(bytes);
			//将byte数组中的一部分写入
			fs.write(bytes, 0, 3);
			
			//建议最后的时候为了保证数据完全写入硬盘，所以要刷新
			fs.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			//关闭
			if(fs!=null)
			{
				try {
					fs.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
