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
	 * �����ļ��ĸ���ճ��
	 */
	@Test
	private static void test1() {
		try 
		{
			//����������
			FileInputStream in = new FileInputStream("xiao.txt");
			//���������
			FileOutputStream out = new FileOutputStream("F:/BabyComeOn.txt");
			//һ�߶���һ��д
			byte[] bytes = new byte[1024];
			int temp = 0;
			while((temp=in.read(bytes))!=-1)
			{
				//��byte�����е�����ֱ��д��
				out.write(bytes, 0, temp);
			}
		
			//ˢ��
			out.flush();
			
			//�ر�
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
		 * 		java.io.OutputStreamWriter;ת�������ֽ������---->�ַ��������
		 * 				java.io.FileWriter;�ļ��ַ������
		 */
		try 
		{
			//�����ļ��ַ������
			//FileWriter fw = new FileWriter("xiao.txt");//����
			FileWriter fw = new FileWriter("xiao.txt",true);//׷��
			
			//��ʼд
			fw.write("���ӣ�no one can help you ,just yourself!!!");
			
			//��char�����һ����д��
			char[] chars = {'��','��','��','��','��'};
			
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
