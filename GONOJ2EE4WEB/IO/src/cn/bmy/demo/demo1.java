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
			//��׷�ӵķ�ʽд��
			fs = new FileOutputStream("xiao",true);
			//��ʼд
			String read = "Fighting";
			//��stringת����byte����
			byte[] bytes = read.getBytes();
			//��byte�����е����з�ʽȫ��д��
			//fs.write(bytes);
			//��byte�����е�һ����д��
			fs.write(bytes, 0, 3);
			
			//��������ʱ��Ϊ�˱�֤������ȫд��Ӳ�̣�����Ҫˢ��
			fs.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			//�ر�
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
