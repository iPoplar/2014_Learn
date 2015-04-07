package cn.bmy.reflect;

import java.lang.reflect.Field;

public class test 
{
	public static void main(String[] args) 
	{
		try 
		{
			ReflectPoint point = new ReflectPoint(1,7);
			Field y;
			y = Class.forName("cn.bmy.reflect.ReflectPoint").getField("y");
			//�˴���y��ֻ�ǻ�����ֽ���
			System.out.println(y.get(point)); //�ڴ˲ſ��Ի�� 7
			//�˾��Ȼ����x��˽�е�
			//Field x = Class.forName("cn.itcast.corejava.ReflectPoint").getField("x");
			//��������      		
			//������   	һ�ǲ�����֪������Ǯ      ���ǰ�Ǯ��һ�£�������     ���Ǳ�������
			//��������ǹ���˽�ģ�������
			Field x = Class.forName("cn.bmy.reflect.ReflectPoint").getDeclaredField("x");
			x.setAccessible(true);//����Ĵ����Ѿ�����Ǯ�ˣ���ʼ����
			System.out.println(x.get(point));
		
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
